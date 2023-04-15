package com.nikoladichev.financialreportanalyzer.controller;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatement;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatementType;
import com.nikoladichev.financialreportanalyzer.service.StockAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StockAnalyzerController {

    private final StockAnalyzerService service;

    @GetMapping("/{symbol}/quarterly")
    public FinancialStatement getQuarterlyFinancialStatement(@PathVariable("symbol") String symbol) {
        return service.getFinancialStatement(symbol, FinancialStatementType.QUARTERLY);
    }

    @GetMapping("/{symbol}/annual")
    public FinancialStatement getAnnualFinancialStatement(@PathVariable("symbol") String symbol) {
        return service.getFinancialStatement(symbol, FinancialStatementType.ANNUAL);
    }

    @GetMapping("/{symbol}/income-statement")
    public IncomeStatementReport incomeStatement(@PathVariable("symbol") String symbol) {
        return service.getIncomeStatementReport(symbol);
    }

    @GetMapping("/{symbol}/balance-sheet")
    public BalanceSheetReport balanceSheet(@PathVariable("symbol") String symbol) {
        return service.getBalanceSheetReport(symbol);
    }

    @GetMapping("/{symbol}/cash-flow")
    public CashFlowReport getForSymbol(@PathVariable("symbol") String symbol) {
        return service.getCashFlowReport(symbol);
    }
}
