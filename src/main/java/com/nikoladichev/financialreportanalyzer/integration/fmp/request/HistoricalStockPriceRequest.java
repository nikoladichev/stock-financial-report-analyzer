package com.nikoladichev.financialreportanalyzer.integration.fmp.request;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestParam;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoricalStockPriceRequest {
  private final @GetRequestParam("serietype") String serieType;
  private final @GetRequestParam("timeseries") Integer timeSeries;
  private final @GetRequestParam String from;
  private final @GetRequestParam String to;
}
