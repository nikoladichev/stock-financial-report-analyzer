package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.AVFunctionType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AVResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheets;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVOverview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.mapper.IncomeStatementsMapper;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository.AVBalanceSheetsRepository;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository.AVCashFlowsRepository;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository.AVIncomeStatementsRepository;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository.AVOverviewRepository;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.service.AVIntegrationService;
import com.nikoladichev.financialreportanalyzer.model.common.IncomeStatementCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockAnalyzerService {

    private final IncomeStatementsMapper incomeStatementsMapper;

    private final AVIntegrationService avIntegrationService;
    private final AVIncomeStatementsRepository avIncomeStatementRepository;
    private final AVBalanceSheetsRepository avBalanceSheetsRepository;
    private final AVCashFlowsRepository avCashFlowRepository;
    private final AVOverviewRepository avOverviewRepository;

    public IncomeStatementCollection getIncomeStatementCollection(String symbol) {
      // TODO - extract to Av...Service
        AVIncomeStatements avIncomeStatements =
                avIncomeStatementRepository.saveOrUpdate(
                        this.avIncomeStatementRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AVFunctionType.INCOME_STATEMENT, symbol)));

        avIncomeStatements = avIncomeStatementRepository.saveOrUpdate(avIncomeStatements);

        return incomeStatementsMapper.normalizeDto(avIncomeStatements);
    }

    public AVBalanceSheets getBalanceSheetReport(String symbol) {
        AVBalanceSheets AVBalanceSheets = this.avBalanceSheetsRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AVFunctionType.BALANCE_SHEET, symbol));

        return avBalanceSheetsRepository.saveOrUpdate(AVBalanceSheets);
    }

    public AVCashFlows getCashFlowReport(String symbol) {
        AVCashFlows AVCashFlows = this.avCashFlowRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AVFunctionType.CASH_FLOW, symbol));

        return avCashFlowRepository.saveOrUpdate(AVCashFlows);
    }

    public AVOverview getOverview(String symbol) {
        AVOverview cashFlowReport = this.avOverviewRepository
                .findBySymbol(symbol)
                .orElse(this.getFinancialStatement(AVFunctionType.OVERVIEW, symbol));

        return avOverviewRepository.saveOrUpdate(cashFlowReport);
    }

//    public FinancialStatement getFinancialStatement(String symbol, FinancialStatementType type) {
//        return new FinancialStatement(
//                this.getIncomeStatementCollection(symbol),
//                this.getBalanceSheetReport(symbol),
//                this.getCashFlowReport(symbol),
//                type
//        );
//    }

    private <T extends AVResponse> T getFinancialStatement(AVFunctionType reportType, String ticker) {
        return avIntegrationService.getAlphaVantageData(reportType, ticker);
    }
}
