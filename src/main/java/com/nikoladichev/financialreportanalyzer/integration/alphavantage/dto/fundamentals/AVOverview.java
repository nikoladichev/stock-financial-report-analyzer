package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AVResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AVOverview extends AVResponse {
    private String name;
    private String description;
    private String assetType;
    private @JsonProperty("CIK") String CIK;
    private String exchange;
    private String currency;
    private String country;
    private String sector;
    private String industry;
    private String address;
    private String fiscalYearEnd;
    private String latestQuarter;
    private String marketCapitalization;
    private @JsonProperty("EBITDA") String EBITDA;
    private @JsonProperty("PERatio") String PERatio;
    private @JsonProperty("PEGRatio") String PEGRatio;
    private String bookValue;
    private String dividendPerShare;
    private String dividendYield;
    private @JsonProperty("EPS") String EPS;
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
    private String priceToBookRatio;
    private @JsonProperty("EVToRevenue") String EVToRevenue;
    private @JsonProperty("EVToEBITDA") String EVToEBITDA;
    private String beta;
    private @JsonProperty("52WeekHigh") String fiftyTwoWeekHigh;
    private @JsonProperty("52WeekLow") String fiftyTwoWeekLow;
    private @JsonProperty("50DayMovingAverage") String fiftyDayMovingAverage;
    private @JsonProperty("200DayMovingAverage") String twoHundredDayMovingAverage;
    private String sharesOutstanding;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dividendDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date exDividendDate;

    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        super.setSymbol(symbol);
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("AssetType")
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    @JsonProperty("Exchange")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Sector")
    public void setSector(String sector) {
        this.sector = sector;
    }

    @JsonProperty("Industry")
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("FiscalYearEnd")
    public void setFiscalYearEnd(String fiscalYearEnd) {
        this.fiscalYearEnd = fiscalYearEnd;
    }

    @JsonProperty("LatestQuarter")
    public void setLatestQuarter(String latestQuarter) {
        this.latestQuarter = latestQuarter;
    }

    @JsonProperty("MarketCapitalization")
    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    @JsonProperty("BookValue")
    public void setBookValue(String bookValue) {
        this.bookValue = bookValue;
    }

    @JsonProperty("DividendPerShare")
    public void setDividendPerShare(String dividendPerShare) {
        this.dividendPerShare = dividendPerShare;
    }

    @JsonProperty("DividendYield")
    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    @JsonProperty("RevenuePerShareTTM")
    public void setRevenuePerShareTTM(String revenuePerShareTTM) {
        this.revenuePerShareTTM = revenuePerShareTTM;
    }

    @JsonProperty("ProfitMargin")
    public void setProfitMargin(String profitMargin) {
        this.profitMargin = profitMargin;
    }

    @JsonProperty("OperatingMarginTTM")
    public void setOperatingMarginTTM(String operatingMarginTTM) {
        this.operatingMarginTTM = operatingMarginTTM;
    }

    @JsonProperty("ReturnOnAssetsTTM")
    public void setReturnOnAssetsTTM(String returnOnAssetsTTM) {
        this.returnOnAssetsTTM = returnOnAssetsTTM;
    }

    @JsonProperty("ReturnOnEquityTTM")
    public void setReturnOnEquityTTM(String returnOnEquityTTM) {
        this.returnOnEquityTTM = returnOnEquityTTM;
    }

    @JsonProperty("RevenueTTM")
    public void setRevenueTTM(String revenueTTM) {
        this.revenueTTM = revenueTTM;
    }

    @JsonProperty("GrossProfitTTM")
    public void setGrossProfitTTM(String grossProfitTTM) {
        this.grossProfitTTM = grossProfitTTM;
    }

    @JsonProperty("DilutedEPSTTM")
    public void setDilutedEPSTTM(String dilutedEPSTTM) {
        this.dilutedEPSTTM = dilutedEPSTTM;
    }

    @JsonProperty("QuarterlyEarningsGrowthYOY")
    public void setQuarterlyEarningsGrowthYOY(String quarterlyEarningsGrowthYOY) {
        this.quarterlyEarningsGrowthYOY = quarterlyEarningsGrowthYOY;
    }

    @JsonProperty("QuarterlyRevenueGrowthYOY")
    public void setQuarterlyRevenueGrowthYOY(String quarterlyRevenueGrowthYOY) {
        this.quarterlyRevenueGrowthYOY = quarterlyRevenueGrowthYOY;
    }

    @JsonProperty("AnalystTargetPrice")
    public void setAnalystTargetPrice(String analystTargetPrice) {
        this.analystTargetPrice = analystTargetPrice;
    }

    @JsonProperty("TrailingPE")
    public void setTrailingPE(String trailingPE) {
        this.trailingPE = trailingPE;
    }

    @JsonProperty("ForwardPE")
    public void setForwardPE(String forwardPE) {
        this.forwardPE = forwardPE;
    }

    @JsonProperty("PriceToSalesRatioTTM")
    public void setPriceToSalesRatioTTM(String priceToSalesRatioTTM) {
        this.priceToSalesRatioTTM = priceToSalesRatioTTM;
    }

    @JsonProperty("PriceToBookRatio")
    public void setPriceToBookRatio(String priceToBookRatio) {
        this.priceToBookRatio = priceToBookRatio;
    }

    @JsonProperty("Beta")
    public void setBeta(String beta) {
        this.beta = beta;
    }

    @JsonProperty("SharesOutstanding")
    public void setSharesOutstanding(String sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    @JsonProperty("DividendDate")
    public void setDividendDate(Date dividendDate) {
        this.dividendDate = dividendDate;
    }

    @JsonProperty("ExDividendDate")
    public void setExDividendDate(Date exDividendDate) {
        this.exDividendDate = exDividendDate;
    }
}
