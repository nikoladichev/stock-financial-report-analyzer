package com.nikoladichev.financialreportanalyzer.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Structured as a hybrid between MarketWatch & Yahoo Finance statements.
 * Example <a href="https://www.marketwatch.com/investing/stock/aapl/financials?mod=mw_quote_tab">AAPL in MarketWatch</a>
 * Example <a href="https://finance.yahoo.com/quote/AAPL/financials/">AAPL in Yahoo Finance</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatement {
    private String currency;
    private FinancialStatementType statementType;
    private BigDecimal totalRevenue;                                               // I    // nonInterestIncome
    private BigDecimal costofGoodsAndServicesSold;                                 // I.2  // COGS
    private BigDecimal costOfGoodsAndServicesExcludingDepreciationAndAmortization; // I.3  // COGS - DA
    private BigDecimal depreciationAndAmortization;                                // I.4
    private BigDecimal depreciation;                                               // I.4.A
    private BigDecimal amortizationIntangibles;                                    // I.4.B
    private BigDecimal grossProfit;                                                // II
    private BigDecimal operatingExpenses;                                          // III
    private BigDecimal sellingGeneralAndAdministrative;                            // III.1    // SG&A Expense
    private BigDecimal researchAndDevelopment;                                     // III.2
    private BigDecimal operatingIncome;                                            // IV
    private BigDecimal otherNonOperatingIncome;                                    // V        // Non Operating Income/Expense
    private BigDecimal interestIncome;                                             // VI       // investmentIncomeNet
    private BigDecimal interestExpense;                                            // VII
    private BigDecimal netInterestIncome;                                          // VIII     // investmentNetIncome - interestExpense
    private BigDecimal incomeBeforeTax;                                            // IX       // Pretax income
    private BigDecimal incomeTaxExpense;                                           // X        // Tax Provision
    private BigDecimal ebit;                                                       // XI
    private BigDecimal ebitda;                                                     // XII
    private BigDecimal netIncomeFromContinuingOperations;                          // XIII  // Net Income from Conitnuing & Discontinued operations
    private BigDecimal netIncome;                                                  // XIV   // Net Income
}
