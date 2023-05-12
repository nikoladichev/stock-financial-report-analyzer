package com.nikoladichev.financialreportanalyzer.integration.alphavantage.service;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.api.AVFunctionType;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AVResponse;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheets;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVOverview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.serialization.AVDeserializationFactory;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class AVIntegrationService {

  private RestTemplate restTemplate;

  @Value("${alpha.vantage.query.uri}")
  private String alphaVantageUriTemplate;

  public AVIntegrationService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
    this.restTemplate.getMessageConverters()
            .add(0,
            AVDeserializationFactory.createMappingJackson2HttpMessageConverter());
  }

  public <R extends AVResponse> R getAlphaVantageData(
          AVFunctionType function, String ticker) {
    return switch (function) {
      case OVERVIEW -> (R) executeRequest(function, ticker, AVOverview.class);
      case INCOME_STATEMENT -> (R) executeRequest(function, ticker, AVIncomeStatements.class);
      case CASH_FLOW -> (R) executeRequest(function, ticker, AVCashFlows.class);
      case BALANCE_SHEET -> (R) executeRequest(function, ticker, AVBalanceSheets.class);
    };
  }

  private <R extends AVResponse> R executeRequest(
          AVFunctionType function, String ticker, Class<R> clazz) {
    UriTemplate uriTemplate = new UriTemplate(alphaVantageUriTemplate);
    URI uri = uriTemplate.expand(function.getValue(), ticker);
    ResponseEntity<R> response =
        restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);

    return response.getBody();
  }
}
