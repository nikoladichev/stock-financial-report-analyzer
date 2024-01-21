package com.nikoladichev.findich.api.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class IncomeStatementEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String date;
  private String symbol;
  private String period;
  private String reportedCurrency;
  private String cik;
  private String fillingDate;
  private String acceptedDate;
  private String calendarYear;
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
}
