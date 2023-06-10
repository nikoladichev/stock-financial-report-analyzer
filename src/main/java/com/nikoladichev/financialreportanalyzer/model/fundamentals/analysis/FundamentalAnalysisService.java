package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.calculators.HistoricalPriceCalculator;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FundamentalAnalysisService {

  private List<LocalDate> sortedDates;
  private Map<LocalDate, FundamentalData> fundamentalData;

  private Map<LocalDate, HistoricalStockPrice.HistoricalData> historicalPriceData;

  private static final Map<String, Period> periods =
      new HashMap<>() {
        {
          put("1 Day", Period.ofDays(1));
          put("7 Days", Period.ofDays(7));
          put("1 Month", Period.ofMonths(1));
          put("3 Months", Period.ofMonths(3));
          put("6 Months", Period.ofMonths(6));
          put("1 Year", Period.ofYears(1));
          put("2 Years", Period.ofYears(2));
          put("5 Years", Period.ofYears(5));
          put("10 Years", Period.ofYears(10));
        }
      };

  public void init(
      Map<LocalDate, FundamentalData> fundamentalData,
      List<HistoricalStockPrice.HistoricalData> historicalPriceData) {
    this.sortedDates = fundamentalData.keySet().stream().sorted().toList();
    this.fundamentalData = fundamentalData;
    this.historicalPriceData =
        historicalPriceData.stream()
            .collect(
                Collectors.toMap(
                    HistoricalStockPrice.HistoricalData::getDate, Function.identity()));
  }

  public FundamentalAnalysis analyse() {
    return FundamentalAnalysis.builder()
        .returns(calculateAverageReturns())
        .priceChanges(calculateHistoricalPriceChanges())
        .build();
  }

  private BigDecimal calculateAverageReturns() {
    List<BigDecimal> returnsPercent = new ArrayList<>();
    BigDecimal previousPrice = null;
    for (LocalDate date : sortedDates) {
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

  private List<PriceChanges> calculateHistoricalPriceChanges() {
    if (this.historicalPriceData.isEmpty()) {
      return null;
    }

    List<PriceChanges> priceChanges = new ArrayList<>();
    periods.forEach(
        (periodKey, period) -> {
          priceChanges.add(
              PriceChanges.builder()
                  .period(periodKey)
                  .priceGainLoss(
                      HistoricalPriceCalculator.calculatePriceGain(
                          this.historicalPriceData, period))
                  .gainLossPercent(
                      HistoricalPriceCalculator.calculatePriceMovementPercentage(
                          this.historicalPriceData, period))
                  .build());
        });

    return priceChanges;
  }
}
