package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.EnterpriseValuesEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.EnterpriseValuesMapper;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.RatiosMapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnterpriseValuesRepository {
  private final EnterpriseValuesCrudRepository crudRepository;
  private final EnterpriseValuesMapper mapper;

  public List<EnterpriseValues> findAllBySymbol(String symbol) {
    List<EnterpriseValuesEntity> entities = crudRepository.findAllBySymbol(symbol);
    return entities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  // TODO - add dates as Java.SQL.Date so that we can aggregate the data for a specific time period
  //  public List<EnterpriseValues> findAllBySymbolAndPeriod(String symbol, String period) {
  //    List<EnterpriseValuesEntity> entities = crudRepository.findAllBySymbolAndPeriod(symbol,
  // period);
  //    return entities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  //  }

  public List<EnterpriseValues> saveAll(List<EnterpriseValues> dtos) {
    var entities = dtos.stream().map(mapper::dtoToEntity).toList();

    return crudRepository.saveAll(entities).stream().map(mapper::entityToDto).toList();
  }
}
