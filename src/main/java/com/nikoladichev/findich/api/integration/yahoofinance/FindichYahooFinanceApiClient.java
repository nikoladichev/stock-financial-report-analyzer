package com.nikoladichev.findich.api.integration.yahoofinance;


import com.nikoladichev.findich.api.integration.yahoofinance.response.Analysis;
import java.net.URI;
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
public class FindichYahooFinanceApiClient {

    @Value("${yahoo-finance.analysis.uri}")
    private String analysisUri;

    private final RestTemplate restTemplate;

    public FindichYahooFinanceApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Analysis getAnalysis(String symbol) {
        return executeRequest(
                analysisUri,
                symbol,
                new ParameterizedTypeReference<Analysis>() {})
                .getBody();
    }

    private <T> ResponseEntity<T> executeRequest(String url, String symbol, ParameterizedTypeReference<T> clazz) {
        UriTemplate uriTemplate = new UriTemplate(url);
        URI uri = uriTemplate.expand(symbol);

        return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
    }

}
