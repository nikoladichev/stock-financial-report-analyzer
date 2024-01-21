package com.nikoladichev.findich.api.service;

import com.nikoladichev.findich.api.integration.dcf.DisountingCashflowsApiClient;
import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.model.common.Comparators;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.fundamentals.FinancialData;
import com.nikoladichev.findich.api.model.fundamentals.StockData;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
import com.nikoladichev.findich.api.model.persistence.repository.BalanceSheetStatementRepository;
import com.nikoladichev.findich.api.model.persistence.repository.CashFlowStatementRepository;
import com.nikoladichev.findich.api.model.persistence.repository.CompanyProfileRepository;
import com.nikoladichev.findich.api.model.persistence.repository.IncomeStatementRepository;
import java.util.List;
import java.util.Map;
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

  private static int compare(String a, String b) {
    if (a.equals("TTM")) {
      return 1;
    } else if (b.equals("TTM")) {
      return -1;
    } else {
      return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
    }
  }

  public List<IncomeStatement> getIncomeStatements(String symbol, Period period) {
    List<IncomeStatement> existingStatements = incomeStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    Statement<List<IncomeStatement>> incomeStatements =
        this.disountingCashflowsApiClient.getIncomeStatement(symbol, period);

    log.info("Received {} income statements", incomeStatements.getReport().size());

    return incomeStatementRepository.saveAll(incomeStatements);
  }

  public List<BalanceSheetStatement> getBalanceSheetStatements(String symbol, Period period) {
    List<BalanceSheetStatement> existingStatements =
        balanceSheetStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    Statement<List<BalanceSheetStatement>> balanceSheetStatements =
        this.disountingCashflowsApiClient.getBalanceSheetStatement(symbol, period);

    log.info("Received {} balance sheet statements", balanceSheetStatements.getReport().size());

    return balanceSheetStatementRepository.saveAll(balanceSheetStatements);
  }

  public List<CashFlowStatement> getCashFlowStatements(String symbol, Period period) {
    List<CashFlowStatement> existingStatements =
        cashFlowStatementRepository.findAllBySymbol(symbol);
    // TODO [STATEMENT_DATE_VALIDATION] - should three months or one year depending on the period
    if (existingStatements != null && !existingStatements.isEmpty()) {
      return existingStatements;
    }

    Statement<List<CashFlowStatement>> cashFlowStatements =
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

  public StockData getStockData(String symbol) {
    var annualIncomeStatements =
        getIncomeStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(IncomeStatement::getCalendarYear, Function.identity()));
    var ttmIncomeStatements = getIncomeStatements(symbol, Period.ANNUAL).stream().findFirst().orElse(null);

    var annualBalanceSheetStatements =
        getBalanceSheetStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(BalanceSheetStatement::getCalendarYear, Function.identity()));
    var ttmBalanceSheetStatements =
        getBalanceSheetStatements(symbol, Period.QUARTERLY).stream()
                .max((a,b) -> Comparators.financialDateComparator(a.getDate(), b.getDate()))
                .orElse(null);

    var annualCashFlowStatements =
        getCashFlowStatements(symbol, Period.ANNUAL).stream()
            .collect(Collectors.toMap(CashFlowStatement::getCalendarYear, Function.identity()));
    var ttmCashFlowStatements =
        getCashFlowStatements(symbol, Period.ANNUAL).stream().findFirst().orElse(null);

    Map<String, FinancialData> financialData = new TreeMap<>(Comparators.financialYearAndTtmDateComparator);
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

    return StockData.builder()
        .companyProfile(getCompanyProfile(symbol))
        .financialData(financialData)
        .build();
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
