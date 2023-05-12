package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatementType;
import com.nikoladichev.financialreportanalyzer.model.common.IncomeStatement;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeStatementMapper {
  @Mappings({
    @Mapping(target = "currency", source = "avDto.reportedCurrency"),
    @Mapping(target = "totalRevenue", source = "avDto.nonInterestIncome"),
    @Mapping(
        target = "costOfGoodsAndServicesExcludingDepreciationAndAmortization",
        expression =
            "java(new BigDecimal(avDto.getCostofGoodsAndServicesSold()).subtract(new BigDecimal(avDto.getDepreciationAndAmortization())))"),
    @Mapping(
        target = "amortizationIntangibles",
        expression =
            "java(new BigDecimal(avDto.getDepreciationAndAmortization()).subtract(new BigDecimal(avDto.getDepreciation())))"),
    @Mapping(target = "statementType", source = "type"),
  })
  IncomeStatement normalizeDto(AVIncomeStatement avDto, FinancialStatementType type);
}
