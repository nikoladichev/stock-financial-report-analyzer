package com.nikoladichev.financialreportanalyzer.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.ReportType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.service.AlphaVantageIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockAnalyzerService {

    private final AlphaVantageIntegrationService alphaVantageService;

    public <T extends AlphaVantageResponse> T getFinancialStatement(ReportType reportType, String ticker) {
        return alphaVantageService.getAlphaVantageData(reportType, ticker);
    }
}
