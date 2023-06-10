package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.HistoricalStockPriceEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.HistoricalStockPriceMapper;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.RatiosMapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HistoricalStockPriceRepository {
  private final HistoricalStockPriceCrudRepository crudRepository;
  private final HistoricalStockPriceMapper mapper;

  public HistoricalStockPrice findAllBySymbol(String symbol) {
    var entities = crudRepository.findAllBySymbol(symbol);

    return mapper.entityListToDto(entities);
  }

  public Optional<LocalDate> findLastDateFilling(String symbol) {
    return crudRepository.findLastDateFilling(symbol);
  }

  public HistoricalStockPrice saveAll(HistoricalStockPrice dto) {
    var entities = mapper.dtoToEntityList(dto);

    return mapper.entityListToDto(crudRepository.saveAll(entities));
  }
}
