package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FundamentalAnalysisService {

  private List<Date> sortedDates;
  private Map<Date, FundamentalData> fundamentalData;

  public void init(Map<Date, FundamentalData> fundamentalData) {
    this.sortedDates = fundamentalData.keySet().stream().sorted().toList();
    this.fundamentalData = fundamentalData;
  }

  public FundamentalAnalysis analyse() {
    return FundamentalAnalysis.builder().returns(calculateAverageReturns()).build();
  }

  private BigDecimal calculateAverageReturns() {
    List<BigDecimal> returnsPercent = new ArrayList<>();
    BigDecimal previousPrice = null;
    for (Date date : sortedDates) {
      FundamentalData fundamentals = fundamentalData.get(date);
      EnterpriseValues enterpriseValues = fundamentals.getEnterpriseValues();

      if (previousPrice == null) {
        previousPrice = enterpriseValues.getStockPrice();
      } else {
        returnsPercent.add(
            ((enterpriseValues.getStockPrice().subtract(previousPrice))
                    .divide(previousPrice, 3, RoundingMode.HALF_UP))
                .multiply(BigDecimal.valueOf(100)));
        previousPrice = enterpriseValues.getStockPrice();
      }
    }

    return returnsPercent.stream()
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .divide(BigDecimal.valueOf(returnsPercent.size()), 3, RoundingMode.HALF_UP);
  }
}
