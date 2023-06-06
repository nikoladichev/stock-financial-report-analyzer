package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.IncomeStatementEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.IncomeStatementMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IncomeStatementRepository {
  private final IncomeStatementCrudRepository crudRepository;
  private final IncomeStatementMapper mapper;

  public List<IncomeStatement> findAllBySymbol(String symbol) {
    List<IncomeStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbol(symbol);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<IncomeStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<IncomeStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<IncomeStatement> saveAll(IncomeStatement[] incomeStatements) {
    var entities = Arrays.stream(incomeStatements).map(mapper::dtoToEntity).toList();

    return crudRepository.saveAll(entities).stream()
            .map(mapper::entityToDto)
            .toList();
  }
}
