package com.nikoladichev.findich.api.service;

import com.nikoladichev.findich.api.integration.dcf.DisountingCashflowsApiClient;
import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.integration.scraper.FindichScraperApiClient;
import com.nikoladichev.findich.api.integration.scraper.response.Analysis;
import com.nikoladichev.findich.api.integration.scraper.response.RevenueBuild;
import com.nikoladichev.findich.api.model.common.Comparators;
import com.nikoladichev.findich.api.model.common.Constants;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.fundamentals.FinancialData;
import com.nikoladichev.findich.api.model.fundamentals.StockData;
import com.nikoladichev.findich.api.model.fundamentals.Treasury;
import com.nikoladichev.findich.api.model.fundamentals.statements.*;
import com.nikoladichev.findich.api.model.persistence.repository.BalanceSheetStatementRepository;
import com.nikoladichev.findich.api.model.persistence.repository.CashFlowStatementRepository;
import com.nikoladichev.findich.api.model.persistence.repository.CompanyProfileRepository;
import com.nikoladichev.findich.api.model.persistence.repository.IncomeStatementRepository;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FundamentalsService {

  private final IncomeStatementRepository incomeStatementRepository;
  private final BalanceSheetStatementRepository balanceSheetStatementRepository;
  private final CashFlowStatementRepository cashFlowStatementRepository;
  private final CompanyProfileRepository companyProfileRepository;
  private final DisountingCashflowsApiClient disountingCashflowsApiClient;
  private final FindichScraperApiClient yahooFinanceApiClient;

  private static int compare(String a, String b) {
    if (a.equals("TTM")) {
      return 1;
    } else if (b.equals("TTM")) {
      return -1;
    } else {
      return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
    }
  }

  public Set<IncomeStatement> getIncomeStatements(String symbol, Period period) {
    Set<IncomeStatement> existingStatements = incomeStatementRepository.findAllBySymbol(symbol);
    if (existingStatements != null
        && !existingStatements.isEmpty()
        && Constants.latestStatementIsInThePastThreeMonths(existingStatements)) {
      return existingStatements;
    }

    Statement<Set<IncomeStatement>> incomeStatements =
        this.disountingCashflowsApiClient.getIncomeStatement(symbol, period);

    log.info("Received {} income statements", incomeStatements.getReport().size());

    return incomeStatementRepository.saveAll(incomeStatements);
  }

  public Set<BalanceSheetStatement> getBalanceSheetStatements(String symbol, Period period) {
    Set<BalanceSheetStatement> existingStatements =
        balanceSheetStatementRepository.findAllBySymbol(symbol);
    if (existingStatements != null
        && !existingStatements.isEmpty()
        && Constants.latestStatementIsInThePastThreeMonths(existingStatements)) {
      return existingStatements;
    }

    Statement<Set<BalanceSheetStatement>> balanceSheetStatements = null;
    if (Period.LTM.equals(period)) {
      balanceSheetStatements =
          this.disountingCashflowsApiClient.getBalanceSheetStatement(symbol, Period.QUARTERLY);
      var statement =
          balanceSheetStatements.getReport().stream()
              .max(Comparators.statementDateComparator)
              .get();

      balanceSheetStatements =
          new Statement<>(
              balanceSheetStatements.getOriginalCurrency(),
              balanceSheetStatements.getConvertedCurrency(),
              Set.of(statement));
    } else {
      balanceSheetStatements =
          this.disountingCashflowsApiClient.getBalanceSheetStatement(symbol, period);
    }

    log.info("Received {} balance sheet statements", balanceSheetStatements.getReport().size());

    return balanceSheetStatementRepository.saveAll(balanceSheetStatements);
  }

  public Set<CashFlowStatement> getCashFlowStatements(String symbol, Period period) {
    Set<CashFlowStatement> existingStatements =
        cashFlowStatementRepository.findAllBySymbol(symbol);
    if (existingStatements != null
        && !existingStatements.isEmpty()
        && Constants.latestStatementIsInThePastThreeMonths(existingStatements)) {
      return existingStatements;
    }

    Statement<Set<CashFlowStatement>> cashFlowStatements =
        this.disountingCashflowsApiClient.getCashFlowStatement(symbol, period);

    log.info("Received {} balance sheet statements", cashFlowStatements.getReport().size());

    return cashFlowStatementRepository.saveAll(cashFlowStatements);
  }

  public CompanyProfile getCompanyProfile(String symbol) {
    var existingCompanyProfile = companyProfileRepository.findBySymbol(symbol);
    if (existingCompanyProfile != null) {
      return existingCompanyProfile;
    }

    var companyProfile = this.disountingCashflowsApiClient.getCompanyProfile(symbol);

    log.info("Received {} company profile", companyProfile.getReport().get(0).getCompanyName());

    return companyProfileRepository.save(companyProfile.getReport().get(0));
  }

  public Analysis getAnalysis(String symbol) {
    var start = System.currentTimeMillis();
    var analysis = this.yahooFinanceApiClient.getAnalysis(symbol);

    log.info("Received {} analysis in {} ms", symbol, (System.currentTimeMillis() - start));

    return analysis;
  }

  public RevenueBuild getRevenueBuild(String symbol) {
    var start = System.currentTimeMillis();
    var revenueBuild = this.yahooFinanceApiClient.getRevenueBuild(symbol);

    log.info("Received {} revenue build in {} ms", symbol, (System.currentTimeMillis() - start));

    return revenueBuild;
  }

  public StockData getStockData(String symbol) {
    var annualIncomeStatements =
        getIncomeStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(IncomeStatement::getCalendarYear, Function.identity()));
    var ttmIncomeStatements =
        getIncomeStatements(symbol, Period.ANNUAL).stream().findFirst().orElse(null);

    var annualBalanceSheetStatements =
        getBalanceSheetStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(BalanceSheetStatement::getCalendarYear, Function.identity()));
    var ttmBalanceSheetStatements =
        getBalanceSheetStatements(symbol, Period.QUARTERLY).stream()
            .max(Comparators.statementDateComparator)
            .orElse(null);

    var annualCashFlowStatements =
        getCashFlowStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(CashFlowStatement::getCalendarYear, Function.identity()));
    var ttmCashFlowStatements =
        getCashFlowStatements(symbol, Period.ANNUAL).stream().findFirst().orElse(null);

    Map<String, FinancialData> financialData =
        new TreeMap<>(Comparators.financialYearAndTtmDateComparator);
    for (String year : annualCashFlowStatements.keySet()) {
      financialData.put(
          year,
          FinancialData.builder()
              .incomeStatement(annualIncomeStatements.get(year))
              .balanceSheetStatement(annualBalanceSheetStatements.get(year))
              .cashFlowStatement(annualCashFlowStatements.get(year))
              .build());
    }
    financialData.put(
        "TTM",
        FinancialData.builder()
            .incomeStatement(ttmIncomeStatements)
            .balanceSheetStatement(ttmBalanceSheetStatements)
            .cashFlowStatement(ttmCashFlowStatements)
            .build());

//    Analysis analysis = yahooFinanceApiClient.getAnalysis(symbol);

    return StockData.builder()
        .companyProfile(getCompanyProfile(symbol))
        .financialData(financialData)
//        .analysis(analysis)
        .build();
  }

  public Treasury getTreasury() {
    // TODO - save in db

    return disountingCashflowsApiClient.getTreasury();
  }

  //
  //  public List<Ratios> getFinancialRatios(String symbol, Period period, Integer limit) {
  //    List<Ratios> ratios = ratiosRepository.findAllBySymbol(symbol);
  //    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the
  // period
  //    if (ratios != null && !ratios.isEmpty()) {
  //      return ratios;
  //    }
  //
  //    ratios = this.ratiosApiServiceClient.getRatios(symbol, false);
  //
  //    log.info("Received {} ratios", ratios.size());
  //
  //    return ratiosRepository.saveAll(ratios);
  //  }
}
