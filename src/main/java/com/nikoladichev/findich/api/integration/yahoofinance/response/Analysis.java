package com.nikoladichev.findich.api.integration.yahoofinance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {
    @JsonProperty("earnings_estimate")
    private Map<String, EarningsEstimate> earningsEstimate;
    @JsonProperty("earnings_history")
    private Map<String, EarningsHistory> earningsHistory;
    @JsonProperty("eps_revisions")
    private Map<String, EpsRevision> epsRevisions;
    @JsonProperty("eps_trend")
    private Map<String, EpsTrend> epsTrend;
    @JsonProperty("growth_estimates")
    private Map<String, GrowthEstimate> growthEstimates;
    @JsonProperty("revenue_estimate")
    private Map<String, RevenueEstimate> revenueEstimate;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EarningsEstimate {
        @JsonProperty("avg_estimate")
        private Double avgEstimate;
        @JsonProperty("high_estimate")
        private Double highEstimate;
        @JsonProperty("low_estimate")
        private Double lowEstimate;
        @JsonProperty("no_of_analysts")
        private Double noOfAnlysts;
        @JsonProperty("year_ago_eps")
        private Double yearAgoEps;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RevenueEstimate {
        @JsonProperty("avg_estimate")
        private Long avgEstimate;
        @JsonProperty("high_estimate")
        private Long highEstimate;
        @JsonProperty("low_estimate")
        private Long lowEstimate;
        @JsonProperty("no_of_analysts")
        private Double noOfAnlysts;
        @JsonProperty("sales_growth_year_over_est")
        private Double salesGrowthYearOverEst;
        @JsonProperty("year_ago_sales")
        private Long yearAgoSales;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EarningsHistory {
        @JsonProperty("difference")
        private Double difference;
        @JsonProperty("eps_actual")
        private Double epsActual;
        @JsonProperty("eps_est")
        private Double epsEst;
        @JsonProperty("surprise_percent")
        private Double surprisePercent;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EpsRevision {
        @JsonProperty("down_last_30_days")
        private Double downLast30Days;
        @JsonProperty("down_last_7_days")
        private Double downLast7Days;
        @JsonProperty("up_last_30_days")
        private Double upLast30Days;
        @JsonProperty("up_last_7_days")
        private Double upLast7Days;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EpsTrend {
        @JsonProperty("30_days_ago")
        private Double thirtyDaysAgo;
        @JsonProperty("60_days_ago")
        private Double sixtyDaysAgo;
        @JsonProperty("7_days_ago")
        private Double sevenDaysAgo;
        @JsonProperty("90_days_ago")
        private Double ninetyDaysAgo;
        @JsonProperty("current_estimate")
        private Double currentEstimate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GrowthEstimate {
        @JsonProperty("current_qtr")
        private Double currentQtr;
        @JsonProperty("current_year")
        private Double currentYear;
        @JsonProperty("next_5_years_per_annum")
        private Double next5YearsPerAnnum;
        @JsonProperty("next_qtr")
        private Double nextQtr;
        @JsonProperty("next_year")
        private Double nextYear;
        @JsonProperty("past_5_years_per_annum")
        private Double past5YearsPerAnnum;
    }
}
