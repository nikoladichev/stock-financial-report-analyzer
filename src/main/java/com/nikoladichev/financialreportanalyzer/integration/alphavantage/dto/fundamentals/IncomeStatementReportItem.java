package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IncomeStatementReportItem extends AlphaVantageReportItem {
    private String grossProfit;
    private String totalRevenue;
    private String costOfRevenue;
    private String costofGoodsAndServicesSold; // COGS
    private String operatingIncome;
    private String sellingGeneralAndAdministrative;
    private String researchAndDevelopment;
    private String operatingExpenses;
    private String investmentIncomeNet;
    private String netInterestIncome;
    private String interestIncome;
    private String interestExpense;
    private String nonInterestIncome;
    private String otherNonOperatingIncome;
    private String depreciation;
    private String depreciationAndAmortization;
    private String incomeBeforeTax;
    private String incomeTaxExpense;
    private String interestAndDebtExpense;
    private String netIncomeFromContinuingOperations;
    private String comprehensiveIncomeNetOfTax;
    private String ebit;
    private String ebitda;
    private String netIncome;
}
