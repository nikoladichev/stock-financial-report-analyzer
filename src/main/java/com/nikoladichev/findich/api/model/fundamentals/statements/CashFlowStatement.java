package com.nikoladichev.findich.api.model.fundamentals.statements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cash flow statements are financial reports that summarize the inflows and outflows of cash and
 * cash equivalents for a business over a period.
 *
 * @see <a
 *     href="https://site.financialmodelingprep.com/developer/docs/financial-statement-free-api/">Company
 *     Financial Reports API</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashFlowStatement implements FinancialStatement {
  private String date;
  private String symbol;
  private String reportedCurrency;
  private String cik;
  private String fillingDate;
  private String acceptedDate;
  private String calendarYear;
  private String period;
  private long netIncome;
  private long depreciationAndAmortization;
  private long deferredIncomeTax;
  private long stockBasedCompensation;
  private long changeInWorkingCapital;
  private long accountsReceivables;
  private long inventory;
  private long accountsPayables;
  private long otherWorkingCapital;
  private long otherNonCashItems;
  private long netCashProvidedByOperatingActivities;
  private long investmentsInPropertyPlantAndEquipment;
  private long acquisitionsNet;
  private long purchasesOfInvestments;
  private long salesMaturitiesOfInvestments;
  private long otherInvestingActivites;
  private long netCashUsedForInvestingActivites;
  private long debtRepayment;
  private long commonStockIssued;
  private long commonStockRepurchased;
  private long dividendsPaid;
  private long otherFinancingActivites;
  private long netCashUsedProvidedByFinancingActivities;
  private long effectOfForexChangesOnCash;
  private long netChangeInCash;
  private long cashAtEndOfPeriod;
  private long cashAtBeginningOfPeriod;
  private long operatingCashFlow;
  private long capitalExpenditure;
  private long freeCashFlow;
  private String link;
  private String finalLink;
  private long calculatedOtherWorkingCapital;

  @Override
  public FinancialStatementType getStatementType() {
    return FinancialStatementType.CASH_FLOW_STATEMENT;
  }
}
