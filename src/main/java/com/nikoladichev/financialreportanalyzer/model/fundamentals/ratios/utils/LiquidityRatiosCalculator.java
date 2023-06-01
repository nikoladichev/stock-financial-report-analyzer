package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.utils;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * LiquidityRatioCalculator calculates liquidity ratios based on the provided financial statements.
 */
@AllArgsConstructor
public class LiquidityRatiosCalculator {
    private BalanceSheetStatement balanceSheet;
    
    /**
     * Calculates the current ratio.
     *
     * Formula: Current Ratio = Current Assets / Current Liabilities
     *
     * @return The current ratio.
     */
    public BigDecimal calculateCurrentRatio() {
        BigDecimal currentAssets = balanceSheet.getTotalCurrentAssets();
        BigDecimal currentLiabilities = balanceSheet.getTotalCurrentLiabilities();
        return currentAssets.divide(currentLiabilities, 2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the quick ratio (also known as the acid-test ratio).
     *
     * Formula: Quick Ratio = (Current Assets - Inventory) / Current Liabilities
     *
     * @param inventory The value of inventory.
     * @return The quick ratio.
     */
    public BigDecimal calculateQuickRatio(BigDecimal inventory) {
        BigDecimal currentAssets = balanceSheet.getTotalCurrentAssets();
        BigDecimal currentLiabilities = balanceSheet.getTotalCurrentLiabilities();
        BigDecimal quickAssets = currentAssets.subtract(inventory);
        return quickAssets.divide(currentLiabilities, 2, RoundingMode.HALF_UP);
    }

    /**
     * Calculates the cash ratio.
     *
     * Formula: Cash Ratio = Cash and Cash Equivalents / Current Liabilities
     *
     * @param cashAndCashEquivalents The value of cash and cash equivalents.
     * @return The cash ratio.
     */
    public BigDecimal calculateCashRatio(BigDecimal cashAndCashEquivalents) {
        BigDecimal currentLiabilities = balanceSheet.getTotalCurrentLiabilities();
        return cashAndCashEquivalents.divide(currentLiabilities, 2, RoundingMode.HALF_UP);
    }

    /**
     * Returns a string representation of the liquidity ratios.
     *
     * @param inventory                The value of inventory.
     * @param cashAndCashEquivalents   The value of cash and cash equivalents.
     * @return A string representation of the liquidity ratios.
     */
    public String toString(BigDecimal inventory, BigDecimal cashAndCashEquivalents) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        BigDecimal currentRatio = calculateCurrentRatio();
        BigDecimal quickRatio = calculateQuickRatio(inventory);
        BigDecimal cashRatio = calculateCashRatio(cashAndCashEquivalents);

        StringBuilder sb = new StringBuilder();
        sb.append("Liquidity Ratios:")
                .append("\nCurrent Ratio: ")
                .append(decimalFormat.format(currentRatio))
                .append("\nQuick Ratio: ")
                .append(decimalFormat.format(quickRatio))
                .append("\nCash Ratio: ")
                .append(decimalFormat.format(cashRatio));

        return sb.toString();
    }
}