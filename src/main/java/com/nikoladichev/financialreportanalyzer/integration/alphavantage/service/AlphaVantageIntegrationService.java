package com.nikoladichev.financialreportanalyzer.integration.alphavantage.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.AlphaVantageFunctionType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.Overview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.serialization.AlphaVantageDeserializationFactory;
import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class AlphaVantageIntegrationService {

  private RestTemplate restTemplate;

  @Value("${alpha.vantage.query.uri}")
  private String alphaVantageUriTemplate;

  public AlphaVantageIntegrationService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
    this.restTemplate
        .getMessageConverters()
        .add(0, AlphaVantageDeserializationFactory.createMappingJackson2HttpMessageConverter());
  }

  public <R extends AlphaVantageResponse> R getAlphaVantageData(
      AlphaVantageFunctionType function, String ticker) {
    return switch (function) {
      case OVERVIEW -> (R) executeRequest(function, ticker, Overview.class);
      case INCOME_STATEMENT -> (R) executeRequest(function, ticker, IncomeStatementReport.class);
      case CASH_FLOW -> (R) executeRequest(function, ticker, CashFlowReport.class);
      case BALANCE_SHEET -> (R) executeRequest(function, ticker, BalanceSheetReport.class);
    };
  }

  private <R extends AlphaVantageResponse> R executeRequest(
      AlphaVantageFunctionType function, String ticker, Class<R> clazz) {
    UriTemplate uriTemplate = new UriTemplate(alphaVantageUriTemplate);
    URI uri = uriTemplate.expand(function.getValue(), ticker);
    ResponseEntity<R> response =
        restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);

    return response.getBody();
  }
}
