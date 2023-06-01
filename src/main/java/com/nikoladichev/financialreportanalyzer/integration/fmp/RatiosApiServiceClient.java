package com.nikoladichev.financialreportanalyzer.integration.fmp;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.RatiosRequest;
import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestHelper;
import com.nikoladichev.financialreportanalyzer.integration.fmp.response.RatiosTTM;
import com.nikoladichev.financialreportanalyzer.integration.fmp.response.mapper.RatiosTTMMapper;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RatiosApiServiceClient {
  @Value("${fmp.api.key}")
  private String apiKey;

  @Value("${fmp.financial-ratios.uri}")
  private String ratiosUri;

  @Value("${fmp.financial-ratios-ttm.uri}")
  private String ratiosTtmUri;

  private final RestTemplate restTemplate;

  private final RatiosTTMMapper ratiosTTMMapper;

  public RatiosApiServiceClient(RestTemplateBuilder restTemplateBuilder,
                                RatiosTTMMapper ratiosTTMMapper) {
    this.restTemplate = restTemplateBuilder.build();
    this.ratiosTTMMapper = ratiosTTMMapper;
  }

  public List<Ratios> getRatios(String symbol, boolean useTtm) {
    return useTtm
            ? this.getRatiosTTM(symbol)
            : this.getRatios(symbol, RatiosRequest.builder().period(Period.ANNUAL).build());
  }

  public List<Ratios> getRatios(String symbol, RatiosRequest request) {
    String url = GetRequestHelper.buildRequest(request, ratiosUri, apiKey);
    ResponseEntity<Ratios[]> response = executeRequest(Ratios[].class, url, symbol);

    return Arrays.asList(Objects.requireNonNull(response.getBody()));
  }

  private List<Ratios> getRatiosTTM(String symbol) {
    String url = GetRequestHelper.buildRequest(null, ratiosUri, apiKey);
    ResponseEntity<RatiosTTM[]> response = executeRequest(RatiosTTM[].class, url, symbol);

    return Arrays.stream(Objects.requireNonNull(response.getBody())).map(ratiosTTMMapper::normalize).toList();
  }

  private <T> ResponseEntity<T[]> executeRequest(Class<T[]> clazz, String url, String symbol) {
    UriTemplate uriTemplate = new UriTemplate(url);
    URI uri = uriTemplate.expand(symbol);

    return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
  }
}
