package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * POJO representing solvency ratios. Solvency ratios measure a company's long-term financial
 * stability and ability to meet its long-term obligations. These ratios assess the proportion of
 * debt to equity, the coverage of interest expenses, and the cash flow generated to cover the total
 * debt.
 *
 * <p>For more information on solvency ratios, see: <a
 * href="https://www.investopedia.com/terms/s/solvencyratios.asp">Investopedia - Solvency Ratios</a>
 */
@Data
@Builder
public class SolvencyRatios {
  /**
   * Debt-to-Asset Ratio represents the proportion of a company's total debt to its total assets.
   * Formula: Debt-to-Asset Ratio = Total Debt / Total Assets
   */
  private BigDecimal debtToAssetRatio;

  /**
   * Debt-to-Equity Ratio represents the relationship between a company's total debt and its
   * shareholders' equity. Formula: Debt-to-Equity Ratio = Total Debt / Shareholders' Equity
   */
  private BigDecimal debtToEquityRatio;

  /**
   * Equity Ratio represents the proportion of a company's shareholders' equity to its total assets.
   * Formula: Equity Ratio = Shareholders' Equity / Total Assets
   */
  private BigDecimal equityRatio;

  /**
   * Interest Coverage Ratio measures a company's ability to cover its interest expenses with its
   * earnings. Formula: Interest Coverage Ratio = Earnings Before Interest and Taxes (EBIT) /
   * Interest Expense
   */
  private BigDecimal interestCoverageRatio;

  /**
   * Cash Flow to Debt Ratio indicates the ability of a company to generate sufficient cash flow to
   * cover its total debt. Formula: Cash Flow to Debt Ratio = Operating Cash Flow / Total Debt
   */
  private BigDecimal cashFlowToDebtRatio;

  /**
   * Returns a string representation of the solvency ratios.
   *
   * @return A string representation of the solvency ratios.
   */
  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    return "Solvency Ratios:"
        + "\nDebt-to-Asset Ratio: "
        + decimalFormat.format(this.getDebtToAssetRatio())
        + "\nDebt-to-Equity Ratio: "
        + decimalFormat.format(this.getDebtToEquityRatio())
        + "\nEquity Ratio: "
        + decimalFormat.format(this.getEquityRatio())
        + "\nInterest Coverage Ratio: "
        + decimalFormat.format(this.getInterestCoverageRatio())
        + "\nCash Flow to Debt Ratio: "
        + decimalFormat.format(this.getCashFlowToDebtRatio());
  }
}
