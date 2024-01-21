package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.persistence.entity.CashFlowStatementEntity;
import com.nikoladichev.findich.api.model.persistence.mapper.CashFlowStatementMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CashFlowStatementRepository {
  private final CashFlowStatementCrudRepository crudRepository;
  private final CashFlowStatementMapper mapper;

  public List<CashFlowStatement> findAllBySymbol(String symbol) {
    List<CashFlowStatementEntity> statementEntities = crudRepository.findAllBySymbol(symbol);
    return statementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<CashFlowStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<CashFlowStatementEntity> statementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return statementEntities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<CashFlowStatement> saveAll(Statement<List<CashFlowStatement>> statements) {
    var entities = statements.getReport().stream().map(mapper::dtoToEntity).toList();

    return StreamSupport.stream(crudRepository.saveAll(entities).spliterator(), false)
            .map(mapper::entityToDto)
            .toList();
  }
}
