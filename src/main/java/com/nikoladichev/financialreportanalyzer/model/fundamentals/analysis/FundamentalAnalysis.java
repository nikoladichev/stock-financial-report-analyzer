package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class FundamentalAnalysis {
    private BigDecimal returns;
}