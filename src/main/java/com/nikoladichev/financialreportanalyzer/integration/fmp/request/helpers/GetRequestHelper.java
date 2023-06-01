package com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GetRequestHelper {

  public static String buildRequest(Object request, String url, String apiKey) {
    url += "?";
    String arguments = buildQueryParametersString(request);
    if (!StringUtils.isEmpty(arguments)) {
      url += arguments;
      url += "&";
    }
    url += "apikey=" + apiKey;

    return url;
  }

  private static String buildQueryParametersString(Object request) {
    if (request == null) {
      return "";
    }

    Class<?> clazz = request.getClass();
    Field[] fields = clazz.getDeclaredFields();
    List<String> conditions = new ArrayList<>();

    for (Field field : fields) {
      if (field.isAnnotationPresent(GetRequestParam.class)) {
        GetRequestParam annotation = field.getAnnotation(GetRequestParam.class);
        String getParamName = annotation.value();

        // Use the field name as the default value
        if (getParamName.isEmpty()) {
          getParamName = field.getName();
        }

        try {
          field.setAccessible(true);
          addCondition(conditions, getParamName, field.get(request));
          field.setAccessible(false);
        } catch (IllegalAccessException | NumberFormatException e) {
          log.error("Can't access the @GetRequestParam value. {0}", e);
        }
      }
    }

    return String.join("&", conditions);
  }

  private static void addCondition(List<String> conditions, String property, Object value) {
    if (value != null) {
      conditions.add(property + "=" + value);
    }
  }
}
