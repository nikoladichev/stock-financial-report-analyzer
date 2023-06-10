package com.nikoladichev.financialreportanalyzer.model.common;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class DateFormatter {
  public static final SimpleDateFormat FORMATTER = new SimpleDateFormat(Constants.DATE_FORMAT);

  public static LocalDate parse(String date) {
    //        try {
    return LocalDate.parse(date);
    //        } catch (ParseException pe) {
    //            log.error("Can't parse date string: {}. {}", date, pe.getStackTrace());
    //        }
    //
    //        return null;
  }

  public static String format(LocalDate date) {
    if (date == null) {
      return null;
    }

    return FORMATTER.format(date);
  }
}
