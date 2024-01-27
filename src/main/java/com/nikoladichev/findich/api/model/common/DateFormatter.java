package com.nikoladichev.findich.api.model.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateFormatter {
  public static final SimpleDateFormat FORMATTER = new SimpleDateFormat(Constants.DATE_FORMAT);
  public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

  public static LocalDate parse(String date) {

    return LocalDate.parse(date);
  }

  public static String format(LocalDate date) {
    if (date == null) {
      return null;
    }

    return LOCAL_DATE_FORMATTER.format(date);
  }
}
