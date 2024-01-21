package com.nikoladichev.findich.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI(@Value("${springdoc.version}") String apiVersion) {
        return new OpenAPI()
                .info(new Info().title("Stock Data API").description("").version(apiVersion));
    }
}
