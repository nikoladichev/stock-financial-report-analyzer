package com.nikoladichev.financialreportanalyzer.api;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.ReportType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.service.StockAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StockAnalyzerApi {

    private final StockAnalyzerService service;

    @GetMapping("/{symbol}/income-statement")
    public IncomeStatementReport incomeStatement(@PathVariable("symbol") String symbol) {
        return service.getFinancialStatement(ReportType.INCOME_STATEMENT, symbol);
    }

    @GetMapping("/{symbol}/balance-sheet")
    public BalanceSheetReport balanceSheet(@PathVariable("symbol") String symbol) {
        return service.getFinancialStatement(ReportType.BALANCE_SHEET, symbol);
    }

    @GetMapping("/{symbol}/cash-flow")
    public CashFlowReport getForSymbol(@PathVariable("symbol") String symbol) {
        return service.getFinancialStatement(ReportType.CASH_FLOW, symbol);
    }
}
