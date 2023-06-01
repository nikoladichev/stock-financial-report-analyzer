package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * POJO representing valuation ratios. Valuation ratios are used to assess the attractiveness of an
 * investment by evaluating the relationship between the market price of a company's stock and its
 * fundamental indicators. These ratios provide insights into the market's perception of the
 * company's value and growth prospects.
 *
 * <p>For more information on valuation ratios, see: <a
 * href="https://www.investopedia.com/terms/v/valuationratio.asp">Investopedia - Valuation
 * Ratios</a>
 */
@Data
@Builder
public class ValuationRatios {
  /**
   * The price-to-earnings (P/E) ratio measures the market price per share relative to the company's
   * earnings per share (EPS). Formula: P/E Ratio = Market Price per Share / Earnings per Share
   * (EPS)
   */
  private BigDecimal priceToEarningsRatio;

  /**
   * The price-to-book (P/B) ratio compares the market price per share to the book value per share.
   * Formula: P/B Ratio = Market Price per Share / Book Value per Share
   */
  private BigDecimal priceToBookRatio;

  /**
   * The dividend yield measures the annual dividend payments relative to the market price per
   * share. Formula: Dividend Yield = Dividends per Share / Market Price per Share
   */
  private BigDecimal dividendYield;

  /**
   * Returns a string representation of the valuation ratios.
   *
   * @return A string representation of the valuation ratios.
   */
  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    StringBuilder sb = new StringBuilder();
    sb.append("Valuation Ratios:")
        .append("\nPrice-to-Earnings Ratio: ")
        .append(decimalFormat.format(priceToEarningsRatio))
        .append("\nPrice-to-Book Ratio: ")
        .append(decimalFormat.format(priceToBookRatio))
        .append("\nDividend Yield: ")
        .append(decimalFormat.format(dividendYield));

    return sb.toString();
  }
}
