package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.utils;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * Calculator for activity ratios based on financial statements. For more information on activity
 * ratios, refer to: {@link <a
 * href="https://www.investopedia.com/terms/a/activityratio.asp">Investopedia - Activity Ratio</a>}
 */
@AllArgsConstructor
public class ActivityRatiosCalculator {

  /**
   * Calculates the inventory turnover ratio.
   *
   * <p>The inventory turnover ratio measures how efficiently a company manages its inventory by
   * indicating the number of times inventory is sold and replaced during a specific period. A
   * higher ratio indicates more efficient inventory management.
   *
   * <p>Formula: Cost of Goods Sold / Average Inventory
   *
   * @param balanceSheetStatement The balance sheet statement.
   * @param incomeStatement The income statement.
   * @return The inventory turnover ratio.
   * @see <a href="https://www.investopedia.com/terms/i/inventoryturnover.asp">Investopedia -
   *     Inventory Turnover Ratio</a>
   */
  public static BigDecimal calculateInventoryTurnoverRatio(
      BalanceSheetStatement balanceSheetStatement, IncomeStatement incomeStatement) {
    //    BigDecimal costOfGoodsSold = incomeStatement.getCostOfRevenue();
    //    BigDecimal averageInventory = balanceSheetStatement.getAverageInventory();ø
    //    return costOfGoodsSold.divide(averageInventory, 2, BigDecimal.ROUND_HALF_UP);

    return null;
  }

  /**
   * Calculates the accounts receivable turnover ratio.
   *
   * <p>The accounts receivable turnover ratio measures how efficiently a company collects payment
   * from its customers on credit sales. A higher ratio indicates faster collection of accounts
   * receivable.
   *
   * <p>Formula: Net Credit Sales / Average Accounts Receivable
   *
   * @param incomeStatement The income statement.
   * @return The accounts receivable turnover ratio.
   * @see <a href="https://www.investopedia.com/terms/a/accountsreceivableturnover.asp">Investopedia
   *     - Accounts Receivable Turnover Ratio</a>
   */
  public static BigDecimal calculateAccountsReceivableTurnoverRatio(
      IncomeStatement incomeStatement) {
    //    BigDecimal netCreditSales = incomeStatement.getNetCreditSales();
    //    BigDecimal averageAccountsReceivable = incomeStatement.getAverageAccountsReceivable();
    //    return netCreditSales.divide(averageAccountsReceivable, 2, BigDecimal.ROUND_HALF_UP);

    return null;
  }

  /**
   * Calculates the days sales outstanding (DSO) ratio.
   *
   * <p>The days sales outstanding (DSO) ratio measures the average number of days it takes for a
   * company to collect payment from its customers after a sale is made. A lower DSO indicates
   * faster collection of accounts receivable.
   *
   * <p>Formula: (Average Accounts Receivable / Net Credit Sales) * Number of Days in the Period
   *
   * @param incomeStatement The income statement.
   * @return The days sales outstanding (DSO) ratio.
   * @see <a href="https://www.investopedia.com/terms/d/dso.asp">Investopedia - Days Sales
   *     Outstanding (DSO) Ratio</a>
   */
  public static BigDecimal calculateDaysSalesOutstanding(IncomeStatement incomeStatement) {
    //    BigDecimal averageAccountsReceivable = incomeStatement.getAverageAccountsReceivable();
    //    BigDecimal netCreditSales = incomeStatement.getNetCreditSales();
    //    int numberOfDays = incomeStatement.getNumberOfDays();
    //    BigDecimal ratio =
    //        averageAccountsReceivable.divide(netCreditSales, 2, BigDecimal.ROUND_HALF_UP);
    //    return ratio.multiply(BigDecimal.valueOf(numberOfDays));

    return null;
  }

  /**
   * Calculates the fixed asset turnover ratio.
   *
   * <p>The fixed asset turnover ratio measures how efficiently a company generates sales from its
   * fixed assets. A higher ratio indicates more efficient utilization of fixed assets.
   *
   * <p>Formula: Net Sales / Average Fixed Assets
   *
   * @param incomeStatement The income statement.
   * @param balanceSheetStatement The balance sheet statement.
   * @return The fixed asset turnover ratio.
   * @see <a href="https://www.investopedia.com/terms/f/fixed-asset-turnover.asp">Investopedia -
   *     Fixed Asset Turnover Ratio</a>
   */
  public static BigDecimal calculateFixedAssetTurnoverRatio(
      IncomeStatement incomeStatement, BalanceSheetStatement balanceSheetStatement) {
    //    BigDecimal netSales = incomeStatement.getNetSales();
    //    BigDecimal averageFixedAssets = balanceSheetStatement.getAverageFixedAssets();
    //    return netSales.divide(averageFixedAssets, 2, BigDecimal.ROUND_HALF_UP);
    return null;
  }

  /**
   * Calculates the payables turnover ratio.
   *
   * <p>The payables turnover ratio measures how efficiently a company manages its payments to
   * suppliers and creditors. A higher ratio indicates faster payment of accounts payable.
   *
   * <p>Formula: Cost of Goods Sold / Average Accounts Payable
   *
   * @param incomeStatement The income statement.
   * @param balanceSheetStatement The balance sheet statement.
   * @return The payables turnover ratio.
   * @see <a href="https://www.investopedia.com/terms/p/payablesturnover.asp">Investopedia -
   *     Payables Turnover Ratio</a>
   */
  public static BigDecimal calculatePayablesTurnoverRatio(
      IncomeStatement incomeStatement, BalanceSheetStatement balanceSheetStatement) {
    //        BigDecimal costOfGoodsSold = incomeStatement.getCostOfRevenue();
    //        BigDecimal averageAccountsPayable = balanceSheetStatement.getAverageAccountsPayable();
    //        return costOfGoodsSold.divide(averageAccountsPayable, 2, BigDecimal.ROUND_HALF_UP);
    return null;
  }
}
