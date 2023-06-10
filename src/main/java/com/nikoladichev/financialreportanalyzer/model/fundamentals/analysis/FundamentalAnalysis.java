package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class FundamentalAnalysis {
    private BigDecimal returns;
    private List<PriceChanges> priceChanges;
}