package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatement;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowsEntity;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatementType;
import com.nikoladichev.financialreportanalyzer.model.common.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.common.IncomeStatementCollection;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    injectionStrategy = InjectionStrategy.FIELD,
    uses = IncomeStatementMapper.class)
public abstract class IncomeStatementsMapper {

  @Autowired
  private IncomeStatementMapper incomeStatementMapper;

  @Mappings({
    @Mapping(target = "symbol", source = "avDto.symbol"),
    @Mapping(target = "entries", ignore = true)
  })
  public abstract IncomeStatementCollection normalizeDto(AVIncomeStatements avDto);

  @AfterMapping
  public void afterMapping(
      @MappingTarget IncomeStatementCollection normalizedDto, AVIncomeStatements avDto) {
    Map<Date, IncomeStatement> entries = new LinkedHashMap<>();
    for (AVIncomeStatement avIncomeStatement : avDto.getAnnualReports()) {
      entries.put(
          avIncomeStatement.getFiscalDateEnding(),
          incomeStatementMapper.normalizeDto(avIncomeStatement, FinancialStatementType.ANNUAL));
    }

    for (AVIncomeStatement avIncomeStatement : avDto.getQuarterlyReports()) {
      entries.put(
          avIncomeStatement.getFiscalDateEnding(),
          incomeStatementMapper.normalizeDto(avIncomeStatement, FinancialStatementType.QUARTERLY));
    }

    normalizedDto.setEntries(entries);
  }
}
