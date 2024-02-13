package com.nikoladichev.findich.api.integration.scraper;


import com.nikoladichev.findich.api.integration.scraper.response.Analysis;
import java.net.URI;

import com.nikoladichev.findich.api.integration.scraper.response.RevenueBuild;
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
public class FindichScraperApiClient {

    @Value("${scraper-api.analysis.uri}")
    private String analysisUri;

    @Value("${scraper-api.revenue-build.uri}")
    private String revenueBuildUri;

    private final RestTemplate restTemplate;

    public FindichScraperApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Analysis getAnalysis(String symbol) {
        return executeRequest(
                analysisUri,
                symbol,
                new ParameterizedTypeReference<Analysis>() {})
                .getBody();
    }

    public RevenueBuild getRevenueBuild(String symbol) {
        return executeRequest(
                revenueBuildUri,
                symbol,
                new ParameterizedTypeReference<RevenueBuild>() {})
                .getBody();
    }

    private <T> ResponseEntity<T> executeRequest(String url, String symbol, ParameterizedTypeReference<T> clazz) {
        UriTemplate uriTemplate = new UriTemplate(url);
        URI uri = uriTemplate.expand(symbol);

        return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, clazz);
    }

}
