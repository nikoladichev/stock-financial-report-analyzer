package com.nikoladichev.financialreportanalyzer.integration.alphavantage.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class AVDeserializationFactory {

  public static MappingJackson2HttpMessageConverter createMappingJackson2HttpMessageConverter() {
    ObjectMapper alphaVantageObjectMapper = new ObjectMapper();
    SimpleModule stringModule = new SimpleModule();
//    stringModule.addDeserializer(String.class, new StringDeserializer());
//    alphaVantageObjectMapper.registerModule(stringModule);

    SimpleModule dateModule = new SimpleModule();
    dateModule.addDeserializer(Date.class, new DateDeserializer());
    alphaVantageObjectMapper.registerModule(dateModule);

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
}
