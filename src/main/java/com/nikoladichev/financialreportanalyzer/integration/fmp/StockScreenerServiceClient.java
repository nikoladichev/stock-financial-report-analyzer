package com.nikoladichev.financialreportanalyzer.integration.fmp;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.StockScreenerRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestHelper;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockScreenerServiceClient {
  @Value("${fmp.api.key}")
  private String apiKey;

  @Value("${fmp.stock-screener.uri}")
  private String stockScreenerUri;

  private RestTemplate restTemplate;

  public StockScreenerServiceClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public Stock[] getStocks() {
    return getStocks(StockScreenerRequest.builder().limit(Integer.MAX_VALUE).build());
  }

  public Stock[] getStocks(StockScreenerRequest request) {
    String url = GetRequestHelper.buildRequest(request, stockScreenerUri, apiKey);

    try {
      return executeRequest(Stock[].class, new URI(url)).getBody();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  private <T> ResponseEntity<T[]> executeRequest(Class<T[]> clazz, URI uri) {
    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }
}
