package com.nikoladichev.financialreportanalyzer.integration.alphavantage.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.ReportType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class AlphaVantageIntegrationService {

    private RestTemplate restTemplate;

    @Value("${alpha.vantage.query.uri}")
    private String alphaVantageUriTemplate;

    public AlphaVantageIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public <R> R getAlphaVantageData(ReportType function, String ticker) {
        return switch (function) {
            case INCOME_STATEMENT -> (R) executeRequest(function, ticker, IncomeStatementReport.class);
            case CASH_FLOW -> (R) executeRequest(function, ticker, CashFlowReport.class);
            case BALANCE_SHEET -> (R) executeRequest(function, ticker, BalanceSheetReport.class);
        };
    }

    private <R> R executeRequest(ReportType function, String ticker, Class<R> clazz) {
        UriTemplate uriTemplate = new UriTemplate(alphaVantageUriTemplate);
        URI uri = uriTemplate.expand(function.getValue(), ticker);
        ResponseEntity<R> response = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);

        return response.getBody();
    }
}