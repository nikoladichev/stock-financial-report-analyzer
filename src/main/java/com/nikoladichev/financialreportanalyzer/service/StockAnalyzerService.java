package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.AlphaVantageFunctionType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.Overview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.service.AlphaVantageIntegrationService;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatement;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatementType;
import com.nikoladichev.financialreportanalyzer.persistence.repository.BalanceSheetReportRepository;
import com.nikoladichev.financialreportanalyzer.persistence.repository.CashFlowReportRepository;
import com.nikoladichev.financialreportanalyzer.persistence.repository.IncomeStatementReportRepository;
import com.nikoladichev.financialreportanalyzer.persistence.repository.OverviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockAnalyzerService {

    private final AlphaVantageIntegrationService alphaVantageService;

    private final IncomeStatementReportRepository incomeStatementRepository;
    private final BalanceSheetReportRepository balanceSheetReportRepository;
    private final CashFlowReportRepository cashFlowRepository;
    private final OverviewRepository overviewRepository;

    public IncomeStatementReport getIncomeStatementReport(String symbol) {
        IncomeStatementReport incomeStatementReport = this.incomeStatementRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AlphaVantageFunctionType.INCOME_STATEMENT, symbol));

        return incomeStatementRepository.saveOrUpdate(incomeStatementReport);
    }

    public BalanceSheetReport getBalanceSheetReport(String symbol) {
        BalanceSheetReport balanceSheetReport = this.balanceSheetReportRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AlphaVantageFunctionType.BALANCE_SHEET, symbol));

        return balanceSheetReportRepository.saveOrUpdate(balanceSheetReport);
    }

    public CashFlowReport getCashFlowReport(String symbol) {
        CashFlowReport cashFlowReport = this.cashFlowRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AlphaVantageFunctionType.CASH_FLOW, symbol));

        return cashFlowRepository.saveOrUpdate(cashFlowReport);
    }

    public Overview getOverview(String symbol) {
        Overview cashFlowReport = this.overviewRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AlphaVantageFunctionType.OVERVIEW, symbol));

        return overviewRepository.saveOrUpdate(cashFlowReport);
    }

    public FinancialStatement getFinancialStatement(String symbol, FinancialStatementType type) {
        return new FinancialStatement(
                this.getIncomeStatementReport(symbol),
                this.getBalanceSheetReport(symbol),
                this.getCashFlowReport(symbol),
                type
        );
    }

    private <T extends AlphaVantageResponse> T getFinancialStatement(AlphaVantageFunctionType reportType, String ticker) {
        return alphaVantageService.getAlphaVantageData(reportType, ticker);
    }
}
