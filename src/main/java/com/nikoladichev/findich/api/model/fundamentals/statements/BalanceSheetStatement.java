package com.nikoladichev.findich.api.model.fundamentals.statements;

import lombok.*;

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
  private String date;
  private String symbol;
  private String period;
  private String reportedCurrency;
  private String cik;
  private String fillingDate;
  private String acceptedDate;
  private String calendarYear;
  private long cashAndCashEquivalents;
  private long shortTermInvestments;
  private long cashAndShortTermInvestments;
  private long netReceivables;
  private long inventory;
  private long otherCurrentAssets;
  private long totalCurrentAssets;
  private long propertyPlantEquipmentNet;
  private long goodwill;
  private long intangibleAssets;
  private long goodwillAndIntangibleAssets;
  private long longTermInvestments;
  private long taxAssets;
  private long otherNonCurrentAssets;
  private long totalNonCurrentAssets;
  private long otherAssets;
  private long totalAssets;
  private long accountPayables;
  private long shortTermDebt;
  private long taxPayables;
  private long deferredRevenue;
  private long otherCurrentLiabilities;
  private long totalCurrentLiabilities;
  private long longTermDebt;
  private long deferredRevenueNonCurrent;
  private long deferredTaxLiabilitiesNonCurrent;
  private long otherNonCurrentLiabilities;
  private long totalNonCurrentLiabilities;
  private long otherLiabilities;
  private long capitalLeaseObligations;
  private long totalLiabilities;
  private long preferredStock;
  private long commonStock;
  private long retainedEarnings;
  private long accumulatedOtherComprehensiveIncomeLoss;
  private long othertotalStockholdersEquity;
  private long totalStockholdersEquity;
  private long totalEquity;
  private long totalLiabilitiesAndStockholdersEquity;
  private long minorityInterest;
  private long totalLiabilitiesAndTotalEquity;
  private long totalInvestments;
  private long totalDebt;
  private long netDebt;
  private String link;
  private String finalLink;
  private long calculatedOtherCurrentAssets;
  private long calculatedOtherNonCurrentAssets;
  private long calculatedOtherCurrentLiabilities;
  private long calculatedOtherNonCurrentLiabilities;
  @Override
  public FinancialStatementType getStatementType() {
    return FinancialStatementType.BALANCE_SHEET_STATEMENT;
  }
}
