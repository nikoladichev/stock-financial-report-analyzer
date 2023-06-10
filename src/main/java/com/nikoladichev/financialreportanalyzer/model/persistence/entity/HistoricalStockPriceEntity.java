package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@Entity
@Table(name = "historical_stock_price")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(HistoricalStockPriceId.class)
public class HistoricalStockPriceEntity {

  @Id
  @Column(name = "symbol")
  private String symbol;

  @Id
  @Column(name = "date")
  @Temporal(TemporalType.DATE)
  private LocalDate date;

  @Column(name = "close_price")
  private double close;

  @Column(name = "open_price")
  private double open;

  @Column(name = "high_price")
  private double high;

  @Column(name = "low_price")
  private double low;

  @Column(name = "adj_close_price")
  private double adjClose;

  @Column(name = "volume")
  private long volume;

  @Column(name = "unadjusted_volume")
  private long unadjustedVolume;

  @Column(name = "price_change")
  private double change;

  @Column(name = "percent_change")
  private double changePercent;

  @Column(name = "vwap")
  private double vwap;

  @Column(name = "label")
  private String label;

  @Column(name = "change_over_time")
  private double changeOverTime;
}
