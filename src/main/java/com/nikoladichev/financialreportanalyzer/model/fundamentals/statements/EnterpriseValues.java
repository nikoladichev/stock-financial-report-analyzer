package com.nikoladichev.financialreportanalyzer.model.fundamentals.statements;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Represents enterprise values for a company.
 */
@Data
@Schema(title = "Enterprise Values", description = "Represents enterprise values for a company")
public class EnterpriseValues {

    /**
     * Symbol of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/symbol.asp">Investopedia: Symbol</a>
     */
    @Schema(description = "Symbol of the company")
    private String symbol;

    /**
     * Date of the enterprise values.
     */
    @Schema(description = "Date of the enterprise values")
    private String date;

    /**
     * Stock price of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/stockprice.asp">Investopedia: Stock Price</a>
     */
    @Schema(description = "Stock price of the company")
    private BigDecimal stockPrice;

    /**
     * Number of shares of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/shares.asp">Investopedia: Shares</a>
     */
    @Schema(description = "Number of shares of the company")
    private BigInteger numberOfShares;

    /**
     * Market capitalization of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/m/marketcapitalization.asp">Investopedia: Market Capitalization</a>
     */
    @Schema(description = "Market capitalization of the company")
    private BigInteger marketCapitalization;

    /**
     * Minus cash and cash equivalents of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/c/cash-and-cash-equivalents.asp">Investopedia: Cash and Cash Equivalents</a>
     */
    @Schema(description = "Minus cash and cash equivalents of the company")
    private BigInteger minusCashAndCashEquivalents;

    /**
     * Total debt of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/t/totaldebt.asp">Investopedia: Total Debt</a>
     */
    @Schema(description = "Total debt of the company")
    private BigInteger addTotalDebt;

    /**
     * Enterprise value of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/e/enterprisevalue.asp">Investopedia: Enterprise Value</a>
     */
    @Schema(description = "Enterprise value of the company")
    private BigInteger enterpriseValue;

    @Override
    public String toString() {
        return "EnterpriseValues{" +
                "symbol='" + symbol + '\'' +
                ", date='" + date + '\'' +
                ", stockPrice=" + stockPrice +
                ", numberOfShares=" + numberOfShares +
                ", marketCapitalization=" + marketCapitalization +
                ", minusCashAndCashEquivalents=" + minusCashAndCashEquivalents +
                ", addTotalDebt=" + addTotalDebt +
                ", enterpriseValue=" + enterpriseValue +
                '}';
    }
}
