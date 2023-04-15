package com.nikoladichev.financialreportanalyzer.model.ratios;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatiosWrapper {
    private Ratio[] ratios;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Ratio {
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date ratio;
        private Profitability profitability;
        private ManagementEffectiveness managementEffectiveness;
        private Liquidity liquidity;
        private FinancialStrength financialStrength;
        private Efficiency efficiency;
        private MarketRatios marketRatios;
    }
}
