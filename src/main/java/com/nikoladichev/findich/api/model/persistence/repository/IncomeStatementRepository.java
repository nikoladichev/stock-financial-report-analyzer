package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.persistence.entity.IncomeStatementEntity;
import com.nikoladichev.findich.api.model.persistence.mapper.IncomeStatementMapper;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeStatementRepository {
  private final IncomeStatementCrudRepository crudRepository;
  private final IncomeStatementMapper mapper;

  public Set<IncomeStatement> findAllBySymbol(String symbol) {
    List<IncomeStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbol(symbol);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toSet());
  }

  public Set<IncomeStatement> findAllBySymbolAndPeriod(String symbol, String period) {
    List<IncomeStatementEntity> incomeStatementEntities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return incomeStatementEntities.stream().map(mapper::entityToDto).collect(Collectors.toSet());
  }

  public Set<IncomeStatement> saveAll(Statement<Set<IncomeStatement>> incomeStatements) {
    var entities = incomeStatements.getReport().stream().map(mapper::dtoToEntity).toList();

    return StreamSupport.stream(crudRepository.saveAll(entities).spliterator(), false)
            .map(mapper::entityToDto)
            .collect(Collectors.toSet());
  }
}
