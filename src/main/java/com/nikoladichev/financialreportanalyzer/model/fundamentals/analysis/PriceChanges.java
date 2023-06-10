package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PriceChanges {
    private String period;
    private BigDecimal priceGainLoss;
    private BigDecimal gainLossPercent;
}
