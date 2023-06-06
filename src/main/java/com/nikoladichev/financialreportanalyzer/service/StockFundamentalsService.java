package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.fmp.EnterpriseValuesApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.HistoricalStockPriceApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.RatiosApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.StatementsApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.EnterpriseValuesRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.HistoricalStockPriceRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.StatementRequest;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.*;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StockFundamentalsService {

  private final IncomeStatementRepository incomeStatementRepository;
  private final BalanceSheetStatementRepository balanceSheetStatementRepository;
  private final CashFlowStatementRepository cashFlowStatementRepository;
  private final RatiosRepository ratiosRepository;
  private final EnterpriseValuesRepository enterpriseValuesRepository;
  private final HistoricalStockPriceRepository historicalStockPriceRepository;

  private final StatementsApiServiceClient statementsApiServiceClient;
  private final RatiosApiServiceClient ratiosApiServiceClient;
  private final EnterpriseValuesApiServiceClient enterpriseValuesApiServiceClient;
  private final HistoricalStockPriceApiServiceClient historicalStockPriceApiServiceClient;

  public List<IncomeStatement> getIncomeStatements(String symbol, Period period, Integer limit) {
    List<IncomeStatement> existingStatements = incomeStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    IncomeStatement[] incomeStatements =
        this.statementsApiServiceClient.getIncomeStatement(
            symbol, StatementRequest.builder().period(period).limit(limit).build());

    log.info("Received {} income statements", incomeStatements.length);

    return incomeStatementRepository.saveAll(incomeStatements);
  }

  public List<BalanceSheetStatement> getBalanceSheetStatements(String symbol, Period period, Integer limit) {
    List<BalanceSheetStatement> existingStatements = balanceSheetStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    BalanceSheetStatement[] balanceSheetStatements =
            this.statementsApiServiceClient.getBalanceSheetStatement(
                    symbol, StatementRequest.builder().period(period).limit(limit).build());

    log.info("Received {} balance sheet statements", balanceSheetStatements.length);

    return balanceSheetStatementRepository.saveAll(balanceSheetStatements);
  }


  public List<CashFlowStatement> getCashFlowStatements(String symbol, Period period, Integer limit) {
    List<CashFlowStatement> existingStatements = cashFlowStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    CashFlowStatement[] cashFlowStatements =
            this.statementsApiServiceClient.getCashFlowStatement(
                    symbol, StatementRequest.builder().period(period).limit(limit).build());

    log.info("Received {} balance sheet statements", cashFlowStatements.length);

    return cashFlowStatementRepository.saveAll(cashFlowStatements);
  }


  public List<Ratios> getFinancialRatios(String symbol, Period period, Integer limit) {
    List<Ratios> ratios = ratiosRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (ratios != null && !ratios.isEmpty()) {
      return ratios;
    }

    ratios = this.ratiosApiServiceClient.getRatios(symbol, false);

    log.info("Received {} ratios", ratios.size());

    return ratiosRepository.saveAll(ratios);
  }


  public List<EnterpriseValues> getEnterpriseValues(String symbol, Integer limit) {
    List<EnterpriseValues> enterpriseValues = enterpriseValuesRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (enterpriseValues != null && !enterpriseValues.isEmpty()) {
      return enterpriseValues;
    }

    enterpriseValues =
            this.enterpriseValuesApiServiceClient.getEnterpriseValues(
                    symbol, EnterpriseValuesRequest.builder().limit(limit).build());

    log.info("Received {} enterprise values", enterpriseValues.size());

    return enterpriseValuesRepository.saveAll(enterpriseValues);
  }

  public HistoricalStockPrice getHistoricalStockPrice(String symbol) {
    var historicalStockPrices = historicalStockPriceRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (historicalStockPrices != null) {
      return historicalStockPrices;
    }

    // TODO Add FROM and TO parameters
    historicalStockPrices =
            this.historicalStockPriceApiServiceClient.getHistoricalPrices(
                    symbol, HistoricalStockPriceRequest.builder().build());

    log.info("Received {} enterprise values", historicalStockPrices.getHistorical().size());

    return historicalStockPriceRepository.saveAll(historicalStockPrices);
  }
}
