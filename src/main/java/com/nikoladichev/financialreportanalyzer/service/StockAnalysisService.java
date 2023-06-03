package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.fmp.EnterpriseValuesApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.RatiosApiServiceClient;
import com.nikoladichev.financialreportanalyzer.model.common.DateFormatter;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.FundamentalAnalysis;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.FundamentalAnalysisService;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.FundamentalData;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.*;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.BalanceSheetStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.CashFlowStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.IncomeStatementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockAnalysisService {
  private final RatiosApiServiceClient ratiosApiServiceClient;
  private final EnterpriseValuesApiServiceClient enterpriseValuesApiServiceClient;

  private final IncomeStatementRepository incomeStatementRepository;
  private final BalanceSheetStatementRepository balanceSheetStatementRepository;
  private final CashFlowStatementRepository cashFlowStatementRepository;

  private final FundamentalAnalysisService fundamentalAnalysisService;

  public FundamentalAnalysis executeAnalysis(String symbol) {
    Map<String, IncomeStatement> incomeStatements =
        incomeStatementRepository.findAllBySymbol(symbol).stream()
            .collect(Collectors.toMap(IncomeStatement::getDate, Function.identity()));

    Map<String, BalanceSheetStatement> balanceSheetStatements =
        balanceSheetStatementRepository.findAllBySymbol(symbol).stream()
            .collect(Collectors.toMap(BalanceSheetStatement::getDate, Function.identity()));

    Map<String, CashFlowStatement> cashFlowStatements =
        cashFlowStatementRepository.findAllBySymbol(symbol).stream()
            .collect(Collectors.toMap(CashFlowStatement::getDate, Function.identity()));

    Map<String, Ratios> ratiosByFillingDate =
        ratiosApiServiceClient.getRatios(symbol, false).stream()
            .collect(Collectors.toMap(Ratios::getDate, Function.identity()));

    Map<String, EnterpriseValues> enterpriseValuesByFillingDate =
        enterpriseValuesApiServiceClient.getEnterpriseValues(symbol).stream()
            .collect(Collectors.toMap(EnterpriseValues::getDate, Function.identity(), (a, b) -> a));

    var fundamentalData = new TreeMap<Date, FundamentalData>();

    for (String fillingDate : enterpriseValuesByFillingDate.keySet()) {
      fundamentalData.put(
          DateFormatter.parse(fillingDate),
          FundamentalData.builder()
              .symbol(symbol)
              .incomeStatement(incomeStatements.get(fillingDate))
              .balanceSheetStatement(balanceSheetStatements.get(fillingDate))
              .cashFlowStatement(cashFlowStatements.get(fillingDate))
              .ratios(ratiosByFillingDate.get(fillingDate))
              .enterpriseValues(enterpriseValuesByFillingDate.get(fillingDate))
              .build());
    }

    fundamentalAnalysisService.init(fundamentalData);

    return fundamentalAnalysisService.analyse();
  }
}
