package com.nikoladichev.findich.api.model.fundamentals.statements;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Income statements are detailed reports that show how much profit or loss the company has
 * generated over a particular year. The income statement, also known as profit or loss account,
 * reports the company expenses that arise from the business operations.
 *
 * @see <a
 *     href="https://site.financialmodelingprep.com/developer/docs/financial-statement-free-api/">Company
 *     Financial Reports API</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatement implements FinancialStatement {
  private String date;
  private String symbol;
  private String reportedCurrency;
  private String cik;
  private String fillingDate;
  private String acceptedDate;
  private String calendarYear;
  private String period;
  private long revenue;
  private long costOfRevenue;
  private long grossProfit;
  private double grossProfitRatio;
  private long researchAndDevelopmentExpenses;
  private long generalAndAdministrativeExpenses;
  private long sellingAndMarketingExpenses;
  private long sellingGeneralAndAdministrativeExpenses;
  private long otherExpenses;
  private long operatingExpenses;
  private long costAndExpenses;
  private long interestIncome;
  private long interestExpense;
  private long depreciationAndAmortization;
  private long ebitda;
  private double ebitdaratio;
  private long operatingIncome;
  private double operatingIncomeRatio;
  private long totalOtherIncomeExpensesNet;
  private long incomeBeforeTax;
  private double incomeBeforeTaxRatio;
  private long incomeTaxExpense;
  private long netIncome;
  private double netIncomeRatio;
  private double eps;
  private double epsdiluted;
  private long weightedAverageShsOut;
  private long weightedAverageShsOutDil;
  private String link;
  private String finalLink;
  private long calculatedOtherExpenses;
  private long calculatedOperatingExpenses;
  private long calculatedNetInterest;
  private long calculatedOtherIncome;
  private long calculatedIncomeNonControlling;
  private long calculatedEbitda;

  @Override
  public FinancialStatementType getStatementType() {
    return FinancialStatementType.INCOME_STATEMENT;
  }
}
