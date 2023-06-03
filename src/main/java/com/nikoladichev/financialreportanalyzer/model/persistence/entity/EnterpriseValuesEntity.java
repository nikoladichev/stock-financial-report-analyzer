package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(EnterpriseValuesId.class)
public class EnterpriseValuesEntity {
    /**
     * Symbol of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/symbol.asp">Investopedia: Symbol</a>
     */
    @Schema(description = "Symbol of the company")
    private @Id String symbol;

    /**
     * Date of the enterprise values.
     */
    @Schema(description = "Date of the enterprise values")
    private @Id String date;

    /**
     * Stock price of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/stockprice.asp">Investopedia: Stock Price</a>
     */
    @Schema(description = "Stock price of the company")
    private double stockPrice;

    /**
     * Number of shares of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/s/shares.asp">Investopedia: Shares</a>
     */
    @Schema(description = "Number of shares of the company")
    private long numberOfShares;

    /**
     * Market capitalization of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/m/marketcapitalization.asp">Investopedia: Market Capitalization</a>
     */
    @Schema(description = "Market capitalization of the company")
    private long marketCapitalization;

    /**
     * Minus cash and cash equivalents of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/c/cash-and-cash-equivalents.asp">Investopedia: Cash and Cash Equivalents</a>
     */
    @Schema(description = "Minus cash and cash equivalents of the company")
    private long minusCashAndCashEquivalents;

    /**
     * Total debt of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/t/totaldebt.asp">Investopedia: Total Debt</a>
     */
    @Schema(description = "Total debt of the company")
    private long addTotalDebt;

    /**
     * Enterprise value of the company.
     *
     * @see <a href="https://www.investopedia.com/terms/e/enterprisevalue.asp">Investopedia: Enterprise Value</a>
     */
    @Schema(description = "Enterprise value of the company")
    private long enterpriseValue;

}

