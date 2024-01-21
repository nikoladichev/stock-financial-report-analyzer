package com.nikoladichev.findich.api.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nikoladichev.findich.api.model.common.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

  @Bean
  public ObjectMapper objectMapper() {
    return JsonMapper.builder()
        .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        .defaultDateFormat(DateFormatter.FORMATTER)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .build();
  }
}
