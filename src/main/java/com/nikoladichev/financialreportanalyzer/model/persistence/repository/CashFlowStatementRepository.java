package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.CashFlowStatementEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.CashFlowStatementMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CashFlowStatementRepository {
  private final CashFlowStatementCrudRepository crudRepository;
  private final CashFlowStatementMapper mapper;

  public List<CashFlowStatement> findAllBySymbol(String symbol) {
    List<CashFlowStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbol(symbol);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<CashFlowStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<CashFlowStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<CashFlowStatement> saveAll(CashFlowStatement[] incomeStatements) {
    var entities = Arrays.stream(incomeStatements).map(mapper::dtoToEntity).toList();

    return crudRepository.saveAll(entities).stream()
            .map(mapper::entityToDto)
            .toList();
  }
}
