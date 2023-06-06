package com.nikoladichev.financialreportanalyzer.integration.fmp;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.HistoricalStockPriceRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestHelper;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;

import java.net.URI;

import com.nikoladichev.financialreportanalyzer.model.persistence.mapper.HistoricalStockPriceMapper;
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
public class HistoricalStockPriceApiServiceClient {
  @Value("${fmp.api.key}")
  private String apiKey;

  @Value("${fmp.historical-stock-price.uri}")
  private String historicalStockPriceUri;

  private final RestTemplate restTemplate;

  private final HistoricalStockPriceMapper mapper;

  public HistoricalStockPriceApiServiceClient(RestTemplateBuilder restTemplateBuilder,
                                              HistoricalStockPriceMapper mapper) {
    this.restTemplate = restTemplateBuilder.build();
    this.mapper = mapper;
  }

  public HistoricalStockPrice getHistoricalPrices(String symbol, HistoricalStockPriceRequest request) {
    String url = GetRequestHelper.buildRequest(request, historicalStockPriceUri, apiKey);
    ResponseEntity<HistoricalStockPrice> response = executeRequest(HistoricalStockPrice.class, url, symbol);

    return response.getBody();
  }

  private <T> ResponseEntity<T> executeRequest(Class<T> clazz, String url, String symbol) {
    UriTemplate uriTemplate = new UriTemplate(url);
    URI uri = uriTemplate.expand(symbol);

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }
}
