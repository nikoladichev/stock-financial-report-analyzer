package com.nikoladichev.findich.api.integration.dcf;

import com.nikoladichev.findich.api.integration.dcf.response.Statement;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.fundamentals.Treasury;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class DisountingCashflowsApiClient {
  @Value("${dcf.income-annual-statement.uri}")
  private String incomeAnnualStatementUri;

  @Value("${dcf.income-ltm-statement.uri}")
  private String incomeLtmStatementUri;

  @Value("${dcf.income-quarterly-statement.uri}")
  private String incomeQuarterlyStatementUri;

  @Value("${dcf.balance-sheet-annual-statement.uri}")
  private String balanceSheetAnnualStatement;

  @Value("${dcf.balance-sheet-quarterly-statement.uri}")
  private String balanceSheetQuarterlyStatement;

  @Value("${dcf.cash-flow-annual-statement.uri}")
  private String cashFlowAnnualStatementUri;

  @Value("${dcf.cash-flow-ltm-statement.uri}")
  private String cashFlowLtmStatementUri;

  @Value("${dcf.cash-flow-quarterly-statement.uri}")
  private String cashFlowQuarterlyStatementUri;

  @Value("${dcf.company-profile.uri}")
  private String companyProfileUri;

  @Value("${dcf.treasury.uri}")
  private String treasuryUri;

  private final RestTemplate restTemplate;

  public DisountingCashflowsApiClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public Treasury getTreasury() {
    return restTemplate.exchange(treasuryUri, HttpMethod.GET, HttpEntity.EMPTY, Treasury.class).getBody();
  }

  public Statement<List<CompanyProfile>> getCompanyProfile(String symbol) {
    return executeStatementRequest(
            companyProfileUri,
            symbol,
            new ParameterizedTypeReference<Statement<List<CompanyProfile>>>() {})
        .getBody();
  }

  public Statement<Set<IncomeStatement>> getIncomeStatement(String symbol, Period period) {
    return getStatement(
        symbol,
        period,
        incomeAnnualStatementUri,
        incomeQuarterlyStatementUri,
        incomeLtmStatementUri,
        new ParameterizedTypeReference<>() {},
        new ParameterizedTypeReference<>() {});
  }

  public Statement<Set<BalanceSheetStatement>> getBalanceSheetStatement(
      String symbol, Period period) {
    return getStatement(
        symbol,
        period,
        balanceSheetAnnualStatement,
        balanceSheetQuarterlyStatement,
        null,
        new ParameterizedTypeReference<>() {},
        new ParameterizedTypeReference<>() {});
  }

  public Statement<Set<CashFlowStatement>> getCashFlowStatement(String symbol, Period period) {
    return getStatement(
        symbol,
        period,
        cashFlowAnnualStatementUri,
        cashFlowQuarterlyStatementUri,
        cashFlowLtmStatementUri,
        new ParameterizedTypeReference<>() {},
        new ParameterizedTypeReference<>() {});
  }

  private <T> Statement<Set<T>> getStatement(
      String symbol,
      Period period,
      String annualStatementUri,
      String quarterlyStatementUri,
      String ltmStatementUri,
      ParameterizedTypeReference<Statement<T>> singleRef,
      ParameterizedTypeReference<Statement<Set<T>>> listRef) {

    switch (period) {
      case ANNUAL -> {
        return executeStatementRequest(annualStatementUri, symbol, listRef).getBody();
      }
      case QUARTERLY -> {
        return executeStatementRequest(quarterlyStatementUri, symbol, listRef).getBody();
      }
      case LTM -> {
        var resp = executeStatementRequest(ltmStatementUri, symbol, singleRef).getBody();
        assert resp != null;
        return new Statement<>(
            resp.getOriginalCurrency(), resp.getConvertedCurrency(), Set.of(resp.getReport()));
      }
    }

    return null;
  }

  private <T> ResponseEntity<T> executeStatementRequest(
      String url, String symbol, ParameterizedTypeReference<T> clazz) {
    UriTemplate uriTemplate = new UriTemplate(url);
    URI uri = uriTemplate.expand(symbol);

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }

  protected <T> ParameterizedTypeReference<Statement<Set<T>>> getParametrizedType() {
    return new ParameterizedTypeReference<>() {};
  }
}
