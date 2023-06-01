package com.nikoladichev.financialreportanalyzer.integration.fmp.request;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestParam;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockScreenerRequest {
  private final @GetRequestParam Double marketCapMoreThan;
  private final @GetRequestParam Double marketCapLowerThan;
  private final @GetRequestParam Double priceMoreThan;
  private final @GetRequestParam Double priceLowerThan;
  private final @GetRequestParam Double betaMoreThan;
  private final @GetRequestParam Double betaLowerThan;
  private final @GetRequestParam Double volumeMoreThan;
  private final @GetRequestParam Double volumeLowerThan;
  private final @GetRequestParam Double dividendMoreThan;
  private final @GetRequestParam Double dividendLowerThan;
  private final @GetRequestParam Boolean isEtf;
  private final @GetRequestParam Boolean isActivelyTrading;
  private final @GetRequestParam String sector;
  private final @GetRequestParam String industry;
  private final @GetRequestParam String country;
  private final @GetRequestParam String exchange;
  private final @GetRequestParam Integer limit;
}
