package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.RatiosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RatiosRepository {
  private final RatiosCrudRepository crudRepository;
  private final RatiosMapper mapper;

  public List<Ratios> findAllBySymbol(String symbol) {
    List<RatiosEntity> ratios = crudRepository.findAllBySymbol(symbol);
    return ratios.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<Ratios> findAllBySymbolAndPeriod(String symbol, String period) {
    List<RatiosEntity> entities = crudRepository.findAllBySymbolAndPeriod(symbol, period);
    return entities.stream().map(mapper::entityToDto).collect(Collectors.toList());
  }

  public List<Ratios> saveAll(List<Ratios> dtos) {
    var entities = dtos.stream().map(mapper::dtoToEntity).toList();

    return crudRepository.saveAll(entities).stream()
            .map(mapper::entityToDto)
            .toList();
  }
}
