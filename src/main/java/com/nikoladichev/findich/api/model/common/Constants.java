package com.nikoladichev.findich.api.model.common;

import static com.nikoladichev.findich.api.model.common.Comparators.statementDateComparator;

import com.nikoladichev.findich.api.model.fundamentals.statements.FinancialStatement;
import java.time.LocalDate;
import java.util.List;

public interface Constants {
  String DATE_FORMAT = "yyyy-MM-dd";

  int LAST_10_YEARS_PLUS_LTM = 11;

  // TODO - evaluate if we must check filling date instead
  static boolean latestStatementIsInThePastThreeMonths(List<? extends FinancialStatement> statements) {
    var mostRecentDate = statements.stream().max(statementDateComparator).orElse(null);

    if (mostRecentDate == null) {
      return false;
    }

    String date = mostRecentDate.getDate();
    if ("LTM".equals(date)) {
      return false; // FIXME
    }

    return DateFormatter.parse(date).isAfter(LocalDate.now().minusMonths(3));
  }
}
