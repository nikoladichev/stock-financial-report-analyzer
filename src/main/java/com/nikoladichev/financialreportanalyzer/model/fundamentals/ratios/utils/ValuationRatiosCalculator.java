package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.utils;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.ValuationRatios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ValuationRatioCalculator calculates valuation ratios based on the provided financial statements.
 */
@AllArgsConstructor
public class ValuationRatiosCalculator {
  private IncomeStatement incomeStatement;
  private BalanceSheetStatement balanceSheet;
  private CashFlowStatement cashFlowStatement;
  private BigDecimal marketPricePerShare;

  /**
   * Calculates the price-to-earnings (P/E) ratio.
   *
   * <p>Formula: P/E Ratio = Market Price per Share / Earnings per Share (EPS)
   *
   * @return The price-to-earnings (P/E) ratio.
   */
  public BigDecimal calculatePriceToEarningsRatio() {
    BigDecimal earningsPerShare = incomeStatement.getEps();
    return marketPricePerShare.divide(earningsPerShare, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the price-to-book (P/B) ratio.
   *
   * <p>Formula: P/B Ratio = Market Price per Share / Book Value per Share
   *
   * @return The price-to-book (P/B) ratio.
   */
  public BigDecimal calculatePriceToBookRatio() {
    return null;
  }

  /**
   * Calculates the dividend yield.
   *
   * <p>Formula: Dividend Yield = Dividends per Share / Market Price per Share
   *
   * @return The dividend yield.
   */
  public BigDecimal calculateDividendYield() {
    return null;
  }

  /**
   * Calculates and returns valuation ratios as a ValuationRatios object.
   *
   * @return The valuation ratios as a ValuationRatios object.
   */
  public ValuationRatios toPojo() {
    return ValuationRatios.builder()
        .priceToEarningsRatio(calculatePriceToEarningsRatio())
        .priceToBookRatio(calculatePriceToBookRatio())
        .dividendYield(calculateDividendYield())
        .build();
  }
}
