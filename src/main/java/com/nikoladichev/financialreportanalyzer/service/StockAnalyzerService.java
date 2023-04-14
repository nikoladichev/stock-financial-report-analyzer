package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.ReportType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.service.AlphaVantageIntegrationService;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.repository.BalanceSheetReportRepository;
import com.nikoladichev.financialreportanalyzer.persistence.repository.CashFlowReportRepository;
import com.nikoladichev.financialreportanalyzer.persistence.repository.IncomeStatementReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockAnalyzerService {

    private final AlphaVantageIntegrationService alphaVantageService;

    private final IncomeStatementReportRepository incomeStatementRepository;
    private final BalanceSheetReportRepository balanceSheetReportRepository;
    private final CashFlowReportRepository cashFlowRepository;

    public IncomeStatementReport getIncomeStatementReport(String symbol) {
        IncomeStatementReport incomeStatementReport = this.incomeStatementRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(ReportType.INCOME_STATEMENT, symbol));

        return incomeStatementRepository.saveOrUpdate(incomeStatementReport);
    }

    public BalanceSheetReport getBalanceSheetReport(String symbol) {
        BalanceSheetReport balanceSheetReport = this.balanceSheetReportRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(ReportType.BALANCE_SHEET, symbol));

        return balanceSheetReportRepository.saveOrUpdate(balanceSheetReport);
    }

    public CashFlowReport getCashFlowReport(String symbol) {
        CashFlowReport cashFlowReport = this.cashFlowRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(ReportType.CASH_FLOW, symbol));

        return cashFlowRepository.saveOrUpdate(cashFlowReport);
    }

    private <T extends AlphaVantageResponse> T getFinancialStatement(ReportType reportType, String ticker) {
        return alphaVantageService.getAlphaVantageData(reportType, ticker);
    }
}
