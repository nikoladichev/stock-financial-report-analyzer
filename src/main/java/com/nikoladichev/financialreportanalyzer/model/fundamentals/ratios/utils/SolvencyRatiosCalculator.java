package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.utils;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.SolvencyRatios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * SolvencyRatioCalculator calculates solvency ratios based on the provided financial statements.
 */
@AllArgsConstructor
public class SolvencyRatiosCalculator {
  private IncomeStatement incomeStatement;
  private BalanceSheetStatement balanceSheet;
  private CashFlowStatement cashFlowStatement;

  /**
   * Calculates the debt-to-asset ratio.
   *
   * <p>Formula: Debt-to-Asset Ratio = Total Debt / Total Assets
   *
   * @return The debt-to-asset ratio.
   */
  public BigDecimal calculateDebtToAssetRatio() {
    BigDecimal totalDebt = balanceSheet.getTotalDebt();
    BigDecimal totalAssets = balanceSheet.getTotalAssets();
    return totalDebt.divide(totalAssets, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the debt-to-equity ratio.
   *
   * <p>Formula: Debt-to-Equity Ratio = Total Debt / Shareholders' Equity
   *
   * @return The debt-to-equity ratio.
   */
  public BigDecimal calculateDebtToEquityRatio() {
    BigDecimal totalDebt = balanceSheet.getTotalDebt();
    BigDecimal shareholdersEquity = balanceSheet.getTotalStockholdersEquity();
    return totalDebt.divide(shareholdersEquity, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the equity ratio.
   *
   * <p>Formula: Equity Ratio = Shareholders' Equity / Total Assets
   *
   * @return The equity ratio.
   */
  public BigDecimal calculateEquityRatio() {
    BigDecimal shareholdersEquity = balanceSheet.getTotalStockholdersEquity();
    BigDecimal totalAssets = balanceSheet.getTotalAssets();
    return shareholdersEquity.divide(totalAssets, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the interest coverage ratio.
   *
   * <p>Formula: Interest Coverage Ratio = Earnings Before Interest and Taxes (EBIT) / Interest
   * Expense
   *
   * @return The interest coverage ratio.
   */
  public BigDecimal calculateInterestCoverageRatio() {
    BigDecimal earningsBeforeInterestAndTaxes = incomeStatement.getEbit();
    BigDecimal interestExpense = incomeStatement.getInterestExpense();
    return earningsBeforeInterestAndTaxes.divide(interestExpense, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates the cash flow to debt ratio.
   *
   * <p>Formula: Cash Flow to Debt Ratio = Operating Cash Flow / Total Debt
   *
   * @return The cash flow to debt ratio.
   */
  public BigDecimal calculateCashFlowToDebtRatio() {
    BigDecimal operatingCashFlow = cashFlowStatement.getOperatingCashFlow();
    BigDecimal totalDebt = balanceSheet.getTotalDebt();
    return operatingCashFlow.divide(totalDebt, 2, RoundingMode.HALF_UP);
  }

  /**
   * Calculates and returns solvency ratios as a SolvencyRatios object using the builder pattern.
   *
   * @return The solvency ratios as a SolvencyRatios object.
   */
  public SolvencyRatios toPojo() {
    return SolvencyRatios.builder()
        .debtToAssetRatio(calculateDebtToAssetRatio())
        .debtToEquityRatio(calculateDebtToEquityRatio())
        .equityRatio(calculateEquityRatio())
        .interestCoverageRatio(calculateInterestCoverageRatio())
        .cashFlowToDebtRatio(calculateCashFlowToDebtRatio())
        .build();
  }
}
