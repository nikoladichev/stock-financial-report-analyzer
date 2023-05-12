package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ItemId.class)
public class AVCashFlowEntity {
    @Id
    private String symbol;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "org.hibernate.id.UUIDGenerator")
    private String uuid;
    private Date fiscalDateEnding;
    private String reportedCurrency;
    private String operatingCashflow;
    private String paymentsForOperatingActivities;
    private String proceedsFromOperatingActivities;
    private String changeInOperatingLiabilities;
    private String changeInOperatingAssets;
    private String depreciationDepletionAndAmortization;
    private String capitalExpenditures;
    private String changeInReceivables;
    private String changeInInventory;
    private String profitLoss;
    private String cashflowFromInvestment;
    private String cashflowFromFinancing;
    private String proceedsFromRepaymentsOfShortTermDebt;
    private String paymentsForRepurchaseOfCommonStock;
    private String paymentsForRepurchaseOfEquity;
    private String paymentsForRepurchaseOfPreferredStock;
    private String dividendPayout;
    private String dividendPayoutCommonStock;
    private String dividendPayoutPreferredStock;
    private String proceedsFromIssuanceOfCommonStock;
    private String proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet;
    private String proceedsFromIssuanceOfPreferredStock;
    private String proceedsFromRepurchaseOfEquity;
    private String proceedsFromSaleOfTreasuryStock;
    private String changeInCashAndCashEquivalents;
    private String changeInExchangeRate;
    private String netIncome;
}
