package com.nikoladichev.financialreportanalyzer.model.fundamentals;


import lombok.Data;
import lombok.ToString;

/**
 * Represents a stock.
 */
@Data
@ToString
public class Stock {
    /**
     * The stock symbol.
     */
    private String symbol;

    /**
     * The name of the company.
     */
    private String companyName;

    /**
     * The market capitalization of the company.
     * <p>
     * Market capitalization is the total value of a company's outstanding shares of stock.
     * </p>
     * <p>
     * Source: Investopedia - <a href="https://www.investopedia.com/terms/m/marketcapitalization.asp">Market Capitalization</a>
     * </p>
     */
    private long marketCap;

    /**
     * The sector in which the company operates.
     */
    private String sector;

    /**
     * The industry to which the company belongs.
     */
    private String industry;

    /**
     * The beta value of the stock.
     * <p>
     * Beta measures the volatility or systematic risk of a stock compared to the market as a whole.
     * </p>
     * <p>
     * Source: Investopedia - <a href="https://www.investopedia.com/terms/b/beta.asp">Beta</a>
     * </p>
     */
    private double beta;

    /**
     * The current price of the stock.
     */
    private double price;

    /**
     * The last annual dividend paid by the company.
     */
    private double lastAnnualDividend;

    /**
     * The trading volume of the stock.
     */
    private int volume;

    /**
     * The exchange on which the stock is traded.
     */
    private String exchange;

    /**
     * The short name of the exchange on which the stock is traded.
     */
    private String exchangeShortName;

    /**
     * The country where the stock is listed.
     */
    private String country;

    /**
     * Indicates whether the stock is an ETF (Exchange-Traded Fund) or not.
     */
    private boolean isEtf;

    /**
     * Indicates whether the stock is actively trading or not.
     */
    private boolean isActivelyTrading;

    public void setIsEtf(boolean etf) {
        isEtf = etf;
    }

    public boolean getIsEtf() {
        return isEtf;
    }
}
