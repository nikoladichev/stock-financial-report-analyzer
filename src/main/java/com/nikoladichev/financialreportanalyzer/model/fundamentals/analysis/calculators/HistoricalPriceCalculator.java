package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.calculators;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class HistoricalPriceCalculator {

  /**
   * Calculates the price gain for a specific time difference from the current date.
   *
   * @param historicalDataMap The map of historical data by date.
   * @param timeDifference The time difference from the current date.
   * @return The price gain for the specified time difference.
   */
  public static BigDecimal calculatePriceGain(
      Map<LocalDate, HistoricalStockPrice.HistoricalData> historicalDataMap,
      Period timeDifference) {
    LocalDate endDate = LocalDate.now().minusDays(1);
    LocalDate startDate = endDate.minus(timeDifference);
    BigDecimal startPrice = getPriceOnDate(historicalDataMap, startDate);
    BigDecimal endPrice = getPriceOnDate(historicalDataMap, endDate);

    if (BigDecimal.ZERO.equals(startPrice) || BigDecimal.ZERO.equals(endPrice)) {
      return null;
    }

    return endPrice.subtract(startPrice);
  }

  /**
   * Calculates the price movement percentage for a specific time difference from the current date.
   *
   * @param historicalDataList The list of historical data.
   * @param timeDifference The time difference from the current date.
   * @return The price movement percentage for the specified time difference.
   */
  public static BigDecimal calculatePriceMovementPercentage(
      Map<LocalDate, HistoricalStockPrice.HistoricalData> historicalDataList, Period timeDifference) {
    LocalDate endDate = LocalDate.now().minusDays(1);
    LocalDate startDate = endDate.minus(timeDifference);
    BigDecimal startPrice = getPriceOnDate(historicalDataList, startDate);
    BigDecimal endPrice = getPriceOnDate(historicalDataList, endDate);
    if (BigDecimal.ZERO.equals(startPrice) || BigDecimal.ZERO.equals(endPrice)) {
      return null;
    }

    BigDecimal priceChange = endPrice.subtract(startPrice);
    BigDecimal priceChangePercentage =
        priceChange.divide(startPrice, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    return priceChangePercentage;
  }

  // Helper method to get the price on a specific date

  /**
   * Gets the price of historical data on a specific date.
   *
   * @param historicalData The map of historical data by date.
   * @param date The date to retrieve the price for.
   * @return The price of historical data on the specified date.
   */
  private static BigDecimal getPriceOnDate(
      Map<LocalDate, HistoricalStockPrice.HistoricalData> historicalData, LocalDate date) {

    // In history there are no more than 10 non-working days of the stock market so we should assume
    // that there is no price
    LocalDate searchDate = date;
    for (int i = 0; i < 10; i++) {
      if (historicalData.containsKey(searchDate)) {
        return historicalData.get(searchDate).getClose();
      }

      searchDate = searchDate.minusDays(1);
    }

    return BigDecimal.ZERO; // Or handle the case when price for the date is not available
  }
}
