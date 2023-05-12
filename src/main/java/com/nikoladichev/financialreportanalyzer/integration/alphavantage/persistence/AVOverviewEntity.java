package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AVOverviewEntity {
  @Id
  private String symbol;
  private String name;
  private String description;
  private String assetType;
  private String CIK;
  private String exchange;
  private String currency;
  private String country;
  private String sector;
  private String industry;
  private String address;
  private String fiscalYearEnd;
  private String latestQuarter;
  private String marketCapitalization;
  private String EBITDA;
  private String PERatio;
  private String PEGRatio;
  private String bookValue;
  private String dividendPerShare;
  private String dividendYield;
  private String EPS;
  private String revenuePerShareTTM;
  private String profitMargin;
  private String operatingMarginTTM;
  private String returnOnAssetsTTM;
  private String returnOnEquityTTM;
  private String revenueTTM;
  private String grossProfitTTM;
  private String dilutedEPSTTM;
  private String quarterlyEarningsGrowthYOY;
  private String quarterlyRevenueGrowthYOY;
  private String analystTargetPrice;
  private String trailingPE;
  private String forwardPE;
  private String priceToSalesRatioTTM;
  private String PriceToBookRatio;
  private String EVToRevenue;
  private String EVToEBITDA;
  private String beta;
  private String fiftyTwoWeekHigh;
  private String fiftyTwoWeekLow;
  private String fiftyDayMovingAverage;
  private String twoHundredDayMovingAverage;
  private String sharesOutstanding;
  private Date dividendDate;
  private Date exDividendDate;
}
