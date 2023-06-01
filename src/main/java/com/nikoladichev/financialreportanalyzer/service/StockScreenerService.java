package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.fmp.Stock;
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
}
