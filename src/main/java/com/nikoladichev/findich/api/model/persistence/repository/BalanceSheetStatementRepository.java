package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.persistence.entity.BalanceSheetStatementEntity;
import com.nikoladichev.findich.api.model.persistence.mapper.BalanceSheetStatementMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BalanceSheetStatementRepository {
  private final BalanceSheetStatementCrudRepository crudRepository;
  private final BalanceSheetStatementMapper mapper;

  public List<BalanceSheetStatement> findAllBySymbol(String symbol) {
    List<BalanceSheetStatementEntity> statementEntities = crudRepository.findAllBySymbol(symbol);
    return statementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<BalanceSheetStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<BalanceSheetStatementEntity> statementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return statementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<BalanceSheetStatement> saveAll(Statement<List<BalanceSheetStatement>> statements) {
    var entities = statements.getReport().stream().map(mapper::dtoToEntity).toList();

    return StreamSupport.stream(crudRepository.saveAll(entities).spliterator(), false)
            .map(mapper::entityToDto)
            .toList();
  }
}
