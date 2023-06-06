package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.Stock;
import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.StockMapper;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.StockEntity;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StockRepository {
  private final StockCrudRepository stockCrudRepository;
  private final StockMapper stockMapper;

  public List<Stock> findByIsEtf(boolean isEtf) {
    List<StockEntity> stockEntities = stockCrudRepository.findByIsEtf(isEtf);
    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public Stock findBySymbol(String symbol) {
    StockEntity stockEntity = stockCrudRepository.findById(symbol).orElse(null);
    if (stockEntity != null) {
      return stockMapper.entityToDto(stockEntity);
    }
    return null;
  }

  public List<Stock> findBySector(String sector) {
    List<StockEntity> stockEntities = stockCrudRepository.findBySector(sector);
    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public List<Stock> findByIndustry(String industry) {
    List<StockEntity> stockEntities = stockCrudRepository.findByIndustry(industry);
    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public List<Stock> findByExchange(String exchange) {
    List<StockEntity> stockEntities = stockCrudRepository.findByExchange(exchange);
    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public List<Stock> findBySectorAndIndustry(String sector, String industry) {
    List<StockEntity> stockEntities = stockCrudRepository.findBySectorAndIndustry(sector, industry);
    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public List<Stock> findAll() {
    List<StockEntity> stockEntities = stockCrudRepository.findAll();

    return stockEntities.stream().map(stockMapper::entityToDto).collect(Collectors.toList());
  }

  public List<Stock> saveAll(Stock[] stocks) {
    var stockEntities = Arrays.stream(stocks).map(stockMapper::dtoToEntity).toList();

    return stockCrudRepository.saveAll(stockEntities).stream()
        .map(stockMapper::entityToDto)
        .toList();
  }
}
