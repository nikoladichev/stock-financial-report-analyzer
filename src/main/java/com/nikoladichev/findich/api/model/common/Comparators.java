package com.nikoladichev.findich.api.model.common;

import java.time.LocalDate;
import java.util.Comparator;

public class Comparators {

    public static Comparator<String> financialYearAndTtmDateComparator =
      (a, b) -> {
        if (a.equals("TTM")) {
          return 1;
        } else if (b.equals("TTM")) {
          return -1;
        } else {
          return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
        }
      };

    public static int financialDateComparator(String a, String b) {
        LocalDate localDateA = DateFormatter.parse(a);
        LocalDate localDateB = DateFormatter.parse(b);

        return localDateA.compareTo(localDateB);
    }
}
