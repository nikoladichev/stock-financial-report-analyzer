package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BalanceSheetReportItem extends AlphaVantageReportItem {
    private String totalAssets;
    private String totalCurrentAssets;
    private String cashAndCashEquivalentsAtCarryingValue;
    private String cashAndShortTermInvestments;
    private String inventory;
    private String currentNetReceivables;
    private String totalNonCurrentAssets;
    private String propertyPlantEquipment;
    private String accumulatedDepreciationAmortizationPPE;
    private String intangibleAssets;
    private String intangibleAssetsExcludingGoodwill;
    private String goodwill;
    private String investments;
    private String longTermInvestments;
    private String shortTermInvestments;
    private String otherCurrentAssets;
    private String otherNonCurrentAssets;
    private String totalLiabilities;
    private String totalCurrentLiabilities;
    private String currentAccountsPayable;
    private String deferredRevenue;
    private String currentDebt;
    private String shortTermDebt;
    private String totalNonCurrentLiabilities;
    private String capitalLeaseObligations;
    private String longTermDebt;
    private String currentLongTermDebt;
    private String longTermDebtNoncurrent;
    private String shortLongTermDebtTotal;
    private String otherCurrentLiabilities;
    private String otherNonCurrentLiabilities;
    private String totalShareholderEquity;
    private String treasuryStock;
    private String retainedEarnings;
    private String commonStock;
    private String commonStockSharesOutstanding;
}
