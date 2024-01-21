package com.nikoladichev.findich.api.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BalanceSheetStatementEntity {
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
}
