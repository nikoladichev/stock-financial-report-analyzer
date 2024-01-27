package com.nikoladichev.findich.api.model.common;

import com.nikoladichev.findich.api.model.fundamentals.statements.FinancialStatement;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;

public class Comparators {

  public static Comparator<String> financialYearAndTtmDateComparator =
      (a, b) -> {
        if (a.equals("TTM")) {
          return 1;
        } else if (b.equals("TTM")) {
          return -1;
        } else {
          try {
            return DateFormatter.parse(a).compareTo(DateFormatter.parse(b));
          } catch (DateTimeParseException e) {
            return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
          }
        }
      };

  public static Comparator<? super FinancialStatement> statementDateComparator =
      (s1, s2) -> {
        if ("LTM".equals(s1.getDate())) {
          return 1;
        } else if ("LTM".equals(s2.getDate())) {
          return -1;
        }

        return financialYearAndTtmDateComparator.compare(s1.getDate(), s2.getDate());
      };

  public static Comparator<String> financialDateComparator =
      (a, b) -> {
        LocalDate localDateA = DateFormatter.parse(a);
        LocalDate localDateB = DateFormatter.parse(b);

        return localDateA.compareTo(localDateB);
      };
}
