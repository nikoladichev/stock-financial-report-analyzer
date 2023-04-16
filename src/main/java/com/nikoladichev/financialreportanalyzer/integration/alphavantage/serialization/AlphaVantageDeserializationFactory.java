package com.nikoladichev.financialreportanalyzer.integration.alphavantage.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class AlphaVantageDeserializationFactory {

  public static MappingJackson2HttpMessageConverter createMappingJackson2HttpMessageConverter() {
    ObjectMapper alphaVantageObjectMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(Date.class, new DateDeserializer());
    module.addDeserializer(String.class, new StringDeserializer());
    module.addDeserializer(Double.class, new DoubleDeserializer());
    module.addDeserializer(Long.class, new LongDeserializer());
    alphaVantageObjectMapper.registerModule(module);

    return new MappingJackson2HttpMessageConverter(alphaVantageObjectMapper);
  }

  private static <T> T noneToNullDeserialize(
      JsonParser jsonParser, DeserializationContext context, Class<T> clazz) throws IOException {
    if (jsonParser.getCodec() == null) {
      return null;
    }

    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    if (node.isNull() || Objects.equals(node.asText(), "None")) {
      return null;
    } else {
      return context.readValue(node.traverse(), clazz);
    }
  }

  private static class DateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context)
        throws IOException {
      return noneToNullDeserialize(jsonParser, context, Date.class);
    }
  }

  private static class StringDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext context)
        throws IOException {
      return noneToNullDeserialize(jsonParser, context, String.class);
    }
  }

  private static class DoubleDeserializer extends JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext context)
        throws IOException {
      return noneToNullDeserialize(jsonParser, context, Double.class);
    }
  }

  private static class LongDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser jsonParser, DeserializationContext context)
        throws IOException {
      return noneToNullDeserialize(jsonParser, context, Long.class);
    }
  }
}
