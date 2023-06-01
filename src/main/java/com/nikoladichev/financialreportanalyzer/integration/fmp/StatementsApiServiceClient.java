package com.nikoladichev.financialreportanalyzer.integration.fmp;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.StatementRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestHelper;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
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
public class StatementsApiServiceClient {
  @Value("${fmp.api.key}")
  private String apiKey;

  @Value("${fmp.income-statement.uri}")
  private String incomeStatementUri;

  @Value("${fmp.balance-sheet-statement.uri}")
  private String balanceSheetStatement;

  @Value("${fmp.cash-flow-statement.uri}")
  private String cashFlowStatementUri;

  private RestTemplate restTemplate;

  // TODO [STATEMENTS_AS_REPORTED] - to implement as reported API calls (calculated COGS, etc.)
  //  @Value("${fmp.income-statement-as-reported.uri}")
  //  private String incomeStatementAsReportedUri;

  public StatementsApiServiceClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public IncomeStatement[] getIncomeStatement(String symbol) {
    return this.getIncomeStatement(
        symbol, StatementRequest.builder().period(Period.ANNUAL).build());
  }

  public IncomeStatement[] getIncomeStatement(String symbol, StatementRequest request) {
    String url = GetRequestHelper.buildRequest(request, incomeStatementUri, apiKey);
    ResponseEntity<IncomeStatement[]> response =
        executeStatementRequest(url, symbol, IncomeStatement[].class);

    return response.getBody();
  }

  public BalanceSheetStatement[] getBalanceSheetStatement(String symbol) {
    return this.getBalanceSheetStatement(
        symbol, StatementRequest.builder().period(Period.ANNUAL).build());
  }

  public BalanceSheetStatement[] getBalanceSheetStatement(String symbol, StatementRequest request) {
    String url = GetRequestHelper.buildRequest(request, balanceSheetStatement, apiKey);
    ResponseEntity<BalanceSheetStatement[]> response =
        executeStatementRequest(url, symbol, BalanceSheetStatement[].class);

    return response.getBody();
  }

  public CashFlowStatement[] getCashFlowStatement(String symbol) {
    return this.getCashFlowStatement(
        symbol, StatementRequest.builder().period(Period.ANNUAL).build());
  }

  public CashFlowStatement[] getCashFlowStatement(String symbol, StatementRequest request) {
    String url = GetRequestHelper.buildRequest(request, cashFlowStatementUri, apiKey);
    ResponseEntity<CashFlowStatement[]> response =
        executeStatementRequest(url, symbol, CashFlowStatement[].class);

    return response.getBody();
  }

  private <T> ResponseEntity<T[]> executeStatementRequest(
      String url, String symbol, Class<T[]> clazz) {
    UriTemplate uriTemplate = new UriTemplate(url);
    URI uri = uriTemplate.expand(symbol);

    return executeRequest(clazz, uri);
  }

  private <T> ResponseEntity<T[]> executeRequest(Class<T[]> clazz, URI uri) {
    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }
}
