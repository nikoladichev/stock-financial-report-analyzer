package com.nikoladichev.financialreportanalyzer.integration.fmp;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.EnterpriseValuesRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestHelper;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Slf4j
@Service
public class EnterpriseValuesApiServiceClient {
  @Value("${fmp.api.key}")
  private String apiKey;

  @Value("${fmp.enterprise-values.uri}")
  private String enterpriseValuesUri;

  private final RestTemplate restTemplate;

  public EnterpriseValuesApiServiceClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public List<EnterpriseValues> getEnterpriseValues(String symbol) {
    return this.getEnterpriseValues(symbol, EnterpriseValuesRequest.builder().period(Period.ANNUAL).build());
  }

  public List<EnterpriseValues> getEnterpriseValues(String symbol, EnterpriseValuesRequest request) {
    String url = GetRequestHelper.buildRequest(request, enterpriseValuesUri, apiKey);
    ResponseEntity<EnterpriseValues[]> response = executeRequest(EnterpriseValues[].class, url, symbol);

    return Arrays.asList(Objects.requireNonNull(response.getBody()));
  }

  private <T> ResponseEntity<T[]> executeRequest(Class<T[]> clazz, String url, String symbol) {
    UriTemplate uriTemplate = new UriTemplate(url);
    URI uri = uriTemplate.expand(symbol);

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }
}
