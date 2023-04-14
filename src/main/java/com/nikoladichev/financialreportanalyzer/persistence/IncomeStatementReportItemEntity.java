package com.nikoladichev.financialreportanalyzer.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ItemId.class)
public class IncomeStatementReportItemEntity {
    @Id
    private String symbol;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "org.hibernate.id.UUIDGenerator")
    private String uuid;
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
