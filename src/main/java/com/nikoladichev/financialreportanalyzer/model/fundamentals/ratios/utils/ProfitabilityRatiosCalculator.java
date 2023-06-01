package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.utils;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.ProfitabilityRatios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ProfitabilityRatioCalculator calculates profitability ratios based on the provided financial
 * statements.
 */
@AllArgsConstructor
public class ProfitabilityRatiosCalculator {
  private IncomeStatement incomeStatement;
  private BalanceSheetStatement balanceSheet;

  /**
   * Calculates the gross profit margin.
   *
   * <p>Formula: Gross Profit Margin = (Revenue - Cost of Goods Sold) / Revenue
   *
   * @return The gross profit margin.
   */
  public BigDecimal calculateGrossProfitMargin() {
    BigDecimal revenue = incomeStatement.getRevenue();
    BigDecimal costOfGoodsSold = incomeStatement.getCostOfRevenue();
    BigDecimal grossProfit = revenue.subtract(costOfGoodsSold);
    return grossProfit.divide(revenue, 4, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the net profit margin.
   *
   * <p>Formula: Net Profit Margin = Net Income / Revenue
   *
   * @return The net profit margin.
   */
  public BigDecimal calculateNetProfitMargin() {
    BigDecimal netIncome = incomeStatement.getNetIncome();
    BigDecimal revenue = incomeStatement.getRevenue();
    return netIncome.divide(revenue, 4, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the return on assets (ROA).
   *
   * <p>Formula: Return on Assets = Net Income / Total Assets
   *
   * @return The return on assets (ROA).
   */
  public BigDecimal calculateReturnOnAssets() {
    BigDecimal netIncome = incomeStatement.getNetIncome();
    BigDecimal totalAssets = balanceSheet.getTotalAssets();
    return netIncome.divide(totalAssets, 4, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the return on equity (ROE).
   *
   * <p>Formula: Return on Equity = Net Income / Shareholders' Equity
   *
   * @return The return on equity (ROE).
   */
  public BigDecimal calculateReturnOnEquity() {
    BigDecimal netIncome = incomeStatement.getNetIncome();
    BigDecimal shareholdersEquity = balanceSheet.getTotalStockholdersEquity();
    return netIncome.divide(shareholdersEquity, 4, RoundingMode.HALF_UP);
  }

  /**
   * Calculates and returns profitability ratios as a ProfitabilityRatios object.
   *
   * @return The profitability ratios as a ProfitabilityRatios object.
   */
  public ProfitabilityRatios toPojo() {
    return ProfitabilityRatios.builder()
        .grossProfitMargin(calculateGrossProfitMargin())
        .netProfitMargin(calculateNetProfitMargin())
        .returnOnAssets(calculateReturnOnAssets())
        .returnOnEquity(calculateReturnOnEquity())
        .build();
  }
}
