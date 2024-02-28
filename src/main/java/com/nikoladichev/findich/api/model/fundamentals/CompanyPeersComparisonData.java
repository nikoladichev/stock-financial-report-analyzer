package com.nikoladichev.findich.api.model.fundamentals;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
public class CompanyPeersComparisonData {
    private String companyName;
    private String symbol;
    // Market Data
    private BigDecimal sharePrice;
    private BigInteger sharesOutstanding;
    private BigInteger marketCap;
    private BigInteger cashAndEquivalents;
    private BigInteger netDebt;
    private BigInteger enterpriseValue;

    // Financials
    private BigInteger revenue;
    private BigInteger ebitda;
    private BigInteger netIncome;
}
