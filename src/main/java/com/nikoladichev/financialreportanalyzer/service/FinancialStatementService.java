package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.fmp.StatementsApiServiceClient;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.StatementRequest;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.BalanceSheetStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.CashFlowStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.IncomeStatementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FinancialStatementService {

  private final IncomeStatementRepository incomeStatementRepository;
  private final BalanceSheetStatementRepository balanceSheetStatementRepository;
  private final CashFlowStatementRepository cashFlowStatementRepository;
  private final StatementsApiServiceClient statementsApiServiceClient;

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
}
