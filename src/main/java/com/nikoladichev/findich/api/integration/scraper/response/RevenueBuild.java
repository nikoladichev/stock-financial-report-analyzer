package com.nikoladichev.findich.api.integration.scraper.response;


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
public class RevenueBuild {
    private String sector;
    private String industry;
    private String country;
    private String exchange;
    @JsonProperty("revenue_build")
    private RevenueBuildData revenueBuildData;
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RevenueBuildData {
        @JsonProperty("products_and_services")
        private RevenueEntry productsAndServices;
        @JsonProperty("regions")
        private RevenueEntry regions;
        @JsonProperty("segment")
        private RevenueEntry segment;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RevenueEntry {
        private Map<String, Map<String, Double>> revenues;
        @JsonProperty("table_description")
        private String tableDescription;
        private String unit;
    }
}
