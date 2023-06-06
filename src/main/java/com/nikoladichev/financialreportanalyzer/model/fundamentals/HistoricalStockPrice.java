package com.nikoladichev.financialreportanalyzer.model.fundamentals;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import lombok.*;

/**
 * Represents a financial instrument.
 *
 * @see <a href="https://www.investopedia.com/">Investopedia</a>
 */
@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Represents a the daily historical stock price")
public class HistoricalStockPrice {

  /**
   * The ticker symbol of the financial instrument.
   */
  @Schema(description = "The ticker symbol of the financial instrument")
  private String symbol;


  /**
   * The historical data for the financial instrument.
   */
  @Schema(description = "The historical data for the financial instrument")
  private List<HistoricalData> historical;

  /**
   * Represents the extended historical data for a financial instrument.
   */
  @Data
  @ToString
  @NoArgsConstructor
  @Schema(description = "Represents the extended historical data for a financial instrument")
  public static class HistoricalData {

    /**
     * The date of the historical data.
     */
    @Schema(description = "The date of the historical data")
    private String date;

    /**
     * The closing price on the given date.
     */
    @Schema(description = "The closing price on the given date")
    private BigDecimal close;

    /**
     * The opening price on the given date.
     */
    @Schema(description = "The opening price on the given date")
    private BigDecimal open;

    /**
     * The highest price reached on the given date.
     */
    @Schema(description = "The highest price reached on the given date")
    private BigDecimal high;

    /**
     * The lowest price reached on the given date.
     */
    @Schema(description = "The lowest price reached on the given date")
    private BigDecimal low;

    /**
     * The adjusted closing price on the given date.
     */
    @Schema(description = "The adjusted closing price on the given date")
    private BigDecimal adjClose;

    /**
     * The trading volume on the given date.
     */
    @Schema(description = "The trading volume on the given date")
    private BigInteger volume;

    /**
     * The unadjusted trading volume on the given date.
     */
    @Schema(description = "The unadjusted trading volume on the given date")
    private BigInteger unadjustedVolume;

    /**
     * The price change on the given date.
     */
    @Schema(description = "The price change on the given date")
    private BigDecimal change;

    /**
     * The percentage change in price on the given date.
     */
    @Schema(description = "The percentage change in price on the given date")
    private BigDecimal changePercent;

    /**
     * The volume-weighted average price on the given date.
     */
    @Schema(description = "The volume-weighted average price on the given date")
    private BigDecimal vwap;

    /**
     * The label for the given date.
     */
    @Schema(description = "The label for the given date")
    private String label;

    /**
     * The change over time on the given date.
     */
    @Schema(description = "The change over time on the given date")
    private BigDecimal changeOverTime;
  }
}
