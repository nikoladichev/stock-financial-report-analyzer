package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.Stock;
import com.nikoladichev.financialreportanalyzer.integration.fmp.StockScreenerServiceClient;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.StockRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StockScreenerService {
  private final StockRepository stockRepository;
  private final StockScreenerServiceClient stockScreenerServiceClient;

  public List<Stock> getStocks() {

    Stock[] stocks = this.stockScreenerServiceClient.getStocks();

    log.info("Received {} stocks", stocks.length);

    return stockRepository.saveAll(stocks);
  }

  public List<Stock> getStocksByIndustryAndSector(String industry, String sector) {
    List<Stock> stocks = stockRepository.findBySectorAndIndustry(sector, industry);

    log.info("Symbols that are in industry=[{}] and sector=[{}] are [{}].",
            String.join(", ", stocks.stream().map(Stock::getSymbol).toList()));

    return stocks;
  }
}
