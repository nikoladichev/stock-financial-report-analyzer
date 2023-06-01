package com.nikoladichev.financialreportanalyzer.model.fundamentals.statements;

import lombok.*;
import java.math.BigDecimal;

/**
 * Balance sheets are financial statements that reveal data about the company’s assets,
 * shareholders’ equity and liabilities for a certain period of time that is either annual or
 * quarter. This data allows you to calculate the rates of return and evaluate the capital structure
 * of the company, which gives you useful insights for your personal or business needs.
 *
 * @see <a
 *     href="https://site.financialmodelingprep.com/developer/docs/financial-statement-free-api/">Company
 *     Financial Reports API</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceSheetStatement implements FinancialStatement {
  /** The date of the financial data. */
  private String date;

  /** The symbol representing the company. */
  private String symbol;

  /** The Central Index Key (CIK) of the company. */
  private String cik;

  /** The currency in which the financial data is reported. */
  private String reportedCurrency;

  /** The filing date of the financial data. */
  private String fillingDate;

  /** The accepted date of the financial data. */
  private String acceptedDate;

  /** The calendar year of the financial data. */
  private String calendarYear;

  /** The period of the financial data (e.g., FY for fiscal year). */
  private String period;

  /** The amount of cash and cash equivalents held by the company. */
  private BigDecimal cashAndCashEquivalents;

  /** The amount of short-term investments held by the company. */
  private BigDecimal shortTermInvestments;

  /** The total amount of cash and short-term investments held by the company. */
  private BigDecimal cashAndShortTermInvestments;

  /** The amount of net receivables (money owed to the company by customers). */
  private BigDecimal netReceivables;

  /** The value of inventory held by the company. */
  private BigDecimal inventory;

  /** The value of other current assets held by the company. */
  private BigDecimal otherCurrentAssets;

  /** The total value of current assets held by the company. */
  private BigDecimal totalCurrentAssets;

  /**
   * The net value of property, plant, and equipment after accounting for depreciation and
   * amortization.
   */
  private BigDecimal propertyPlantEquipmentNet;

  /**
   * The value of goodwill, which represents the premium paid for acquiring another company above
   * its book value.
   */
  private BigDecimal goodwill;

  /** The value of intangible assets, such as patents and trademarks. */
  private BigDecimal intangibleAssets;

  /** The total value of goodwill and intangible assets held by the company. */
  private BigDecimal goodwillAndIntangibleAssets;

  /** The amount of long-term investments held by the company. */
  private BigDecimal longTermInvestments;

  /** The value of tax-related assets, such as tax credits. */
  private BigDecimal taxAssets;

  /** The value of other non-current assets held by the company. */
  private BigDecimal otherNonCurrentAssets;

  /** The total value of non-current assets held by the company. */
  private BigDecimal totalNonCurrentAssets;

  /** The value of other assets held by the company. */
  private BigDecimal otherAssets;

  /** The total value of assets held by the company. */
  private BigDecimal totalAssets;

  /** The amount of account payables (money owed by the company to suppliers). */
  private BigDecimal accountPayables;

  /** The amount of short-term debt owed by the company. */
  private BigDecimal shortTermDebt;

  /** The amount of tax payables (taxes owed by the company). */
  private BigDecimal taxPayables;

  /** The amount of deferred revenue (revenue received but not yet earned). */
  private BigDecimal deferredRevenue;

  /** The value of other current liabilities of the company. */
  private BigDecimal otherCurrentLiabilities;

  /** The total value of current liabilities of the company. */
  private BigDecimal totalCurrentLiabilities;

  /** The amount of long-term debt owed by the company. */
  private BigDecimal longTermDebt;

  /**
   * The amount of non-current deferred revenue (revenue received but not yet earned) of the
   * company.
   */
  private BigDecimal deferredRevenueNonCurrent;

  /** The amount of non-current deferred tax liabilities of the company. */
  private BigDecimal deferredTaxLiabilitiesNonCurrent;

  /** The value of other non-current liabilities of the company. */
  private BigDecimal otherNonCurrentLiabilities;

  /** The total value of non-current liabilities of the company. */
  private BigDecimal totalNonCurrentLiabilities;

  /** The value of other liabilities of the company. */
  private BigDecimal otherLiabilities;

  /** The amount of capital lease obligations of the company. */
  private BigDecimal capitalLeaseObligations;

  /** The total value of liabilities of the company. */
  private BigDecimal totalLiabilities;

  /** The value of preferred stock held by the company. */
  private BigDecimal preferredStock;

  /** The value of common stock held by the company. */
  private BigDecimal commonStock;

  /** The value of retained earnings (accumulated profits) of the company. */
  private BigDecimal retainedEarnings;

  /** The accumulated other comprehensive income/loss of the company. */
  private BigDecimal accumulatedOtherComprehensiveIncomeLoss;

  /** The value of other total stockholders' equity. */
  private BigDecimal othertotalStockholdersEquity;

  /** The total value of stockholders' equity of the company. Also known as shareholders equity */
  private BigDecimal totalStockholdersEquity;

  /** The total value of liabilities and stockholders' equity of the company. */
  private BigDecimal totalLiabilitiesAndStockholdersEquity;

  /** The minority interest in the company's equity. */
  private BigDecimal minorityInterest;

  /** The total equity of the company. */
  private BigDecimal totalEquity;

  /** The total value of liabilities and total equity of the company. */
  private BigDecimal totalLiabilitiesAndTotalEquity;

  /** The total value of investments held by the company. */
  private BigDecimal totalInvestments;

  /** The total amount of debt owed by the company. */
  private BigDecimal totalDebt;

  /**
   * The net debt of the company, calculated as the difference between total debt and cash and cash
   * equivalents.
   */
  private BigDecimal netDebt;

  /** The link to the financial data on the SEC website. */
  private String link;

  /** The final link to the specific financial filing on the SEC website. */
  private String finalLink;

  @Override
  public FinancialStatementType getStatementType() {
    return FinancialStatementType.BALANCE_SHEET_STATEMENT;
  }
}
