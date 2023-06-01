package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.fmp.RatiosApiServiceClient;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.FundamentalAnalysis;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.FinancialStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.BalanceSheetStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.CashFlowStatementRepository;
import com.nikoladichev.financialreportanalyzer.model.persistence.repository.IncomeStatementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockAnalysisService {
    private final RatiosApiServiceClient ratiosApiServiceClient;

    private final IncomeStatementRepository incomeStatementRepository;
    private final BalanceSheetStatementRepository balanceSheetStatementRepository;
    private final CashFlowStatementRepository cashFlowStatementRepository;

    public FundamentalAnalysis executeAnalysis(String symbol) {
        // FIXME key should be a date. TODO - to implement date formatter in the mappers!
        Map<String, List<FinancialStatement>> statements = new HashMap<>();

        List<IncomeStatement> incomeStatements = incomeStatementRepository.findAllBySymbol(symbol);
        for (var statement: incomeStatements) {
            statements.computeIfAbsent(statement.getDate(), key -> new ArrayList<>()).add(statement);
        }

        List<BalanceSheetStatement> balanceSheetStatements = balanceSheetStatementRepository.findAllBySymbol(symbol);
        for (var statement: balanceSheetStatements) {
            statements.computeIfAbsent(statement.getDate(), key -> new ArrayList<>()).add(statement);
        }

        List<CashFlowStatement> cashFlowStatements = cashFlowStatementRepository.findAllBySymbol(symbol);
        for (var statement: cashFlowStatements) {
            statements.computeIfAbsent(statement.getDate(), key -> new ArrayList<>()).add(statement);
        }

        List<Ratios> ratios = ratiosApiServiceClient.getRatios(symbol, false);
//        List<Ratios> ratiosTTM = ratiosApiServiceClient.getRatios(symbol, true);

        return FundamentalAnalysis.builder()
                .incomeStatements(incomeStatements)
                .balanceSheetStatements(balanceSheetStatements)
                .cashFlowStatements(cashFlowStatements)
                .ratios(ratios)
//                .ratiosTTM(ratiosTTM)
                .build();
    }
}
