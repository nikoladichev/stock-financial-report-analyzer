package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * POJO representing profitability ratios. Profitability ratios measure a company's ability to
 * generate earnings and profits from its operations. These ratios provide insights into a company's
 * efficiency, profitability, and overall financial performance.
 *
 * <p>For more information on profitability ratios, see: <a
 * href="https://www.investopedia.com/terms/p/profitabilityratios.asp">Investopedia - Profitability
 * Ratios</a>
 */
@Data
@Builder
public class ProfitabilityRatios {
  /**
   * The gross profit margin indicates the profitability of a company's core operations by comparing
   * gross profit to revenue. Formula: Gross Profit Margin = (Revenue - Cost of Goods Sold) /
   * Revenue
   */
  private BigDecimal grossProfitMargin;

  /**
   * The net profit margin measures the percentage of each dollar of revenue that results in net
   * income after all expenses. Formula: Net Profit Margin = Net Income / Revenue
   */
  private BigDecimal netProfitMargin;

  /**
   * The return on assets (ROA) measures how efficiently a company utilizes its assets to generate
   * profits. Formula: Return on Assets = Net Income / Total Assets
   */
  private BigDecimal returnOnAssets;

  /**
   * The return on equity (ROE) evaluates a company's profitability by comparing net income to
   * shareholders' equity. Formula: Return on Equity = Net Income / Shareholders' Equity
   */
  private BigDecimal returnOnEquity;

  /**
   * Returns a string representation of the profitability ratios.
   *
   * @return A string representation of the profitability ratios.
   */
  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00%");

    StringBuilder sb = new StringBuilder();
    sb.append("Profitability Ratios:")
        .append("\nGross Profit Margin: ")
        .append(decimalFormat.format(grossProfitMargin))
        .append("\nNet Profit Margin: ")
        .append(decimalFormat.format(netProfitMargin))
        .append("\nReturn on Assets: ")
        .append(decimalFormat.format(returnOnAssets))
        .append("\nReturn on Equity: ")
        .append(decimalFormat.format(returnOnEquity));

    return sb.toString();
  }
}
