package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.BalanceSheetStatementEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.BalanceSheetStatementMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BalanceSheetStatementRepository {
  private final BalanceSheetStatementCrudRepository crudRepository;
  private final BalanceSheetStatementMapper mapper;

  public List<BalanceSheetStatement> findAllBySymbol(String symbol) {
    List<BalanceSheetStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbol(symbol);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<BalanceSheetStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<BalanceSheetStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<BalanceSheetStatement> saveAll(BalanceSheetStatement[] incomeStatements) {
    var entities = Arrays.stream(incomeStatements).map(mapper::dtoToEntity).toList();

    return crudRepository.saveAll(entities).stream()
            .map(mapper::entityToDto)
            .toList();
  }
}
