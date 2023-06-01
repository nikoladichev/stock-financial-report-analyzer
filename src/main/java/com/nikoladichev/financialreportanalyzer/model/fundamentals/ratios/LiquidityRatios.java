package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * POJO representing liquidity ratios. Liquidity ratios assess a company's ability to meet its
 * short-term obligations and manage its current liabilities effectively. These ratios provide
 * insights into a company's liquidity, cash flow, and ability to cover immediate financial
 * obligations.
 *
 * <p>For more information on liquidity ratios, see: <a
 * href="https://www.investopedia.com/terms/l/liquidityratios.asp">Investopedia - Liquidity Ratios</a>
 */
@Data
@Builder
class LiquidityRatios {
  /**
   * The current ratio represents the proportion of current assets to current liabilities. Formula:
   * Current Ratio = Current Assets / Current Liabilities
   */
  private BigDecimal currentRatio;

  /**
   * The quick ratio (also known as the acid-test ratio) measures the ability to cover short-term
   * liabilities with quick assets, excluding inventory. Formula: Quick Ratio = (Current Assets -
   * Inventory) / Current Liabilities
   */
  private BigDecimal quickRatio;

  /**
   * The cash ratio represents the proportion of cash and cash equivalents to current liabilities.
   * Formula: Cash Ratio = Cash and Cash Equivalents / Current Liabilities
   */
  private BigDecimal cashRatio;

  /**
   * Returns a string representation of the liquidity ratios.
   *
   * @return A string representation of the liquidity ratios.
   */
  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    return "Liquidity Ratios:"
        + "\nCurrent Ratio: "
        + decimalFormat.format(currentRatio)
        + "\nQuick Ratio: "
        + decimalFormat.format(quickRatio)
        + "\nCash Ratio: "
        + decimalFormat.format(cashRatio);
  }
}
