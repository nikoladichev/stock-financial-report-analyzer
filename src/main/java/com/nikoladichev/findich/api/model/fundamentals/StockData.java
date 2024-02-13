package com.nikoladichev.findich.api.model.fundamentals;

import java.util.Map;

import com.nikoladichev.findich.api.integration.scraper.response.Analysis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockData {
    CompanyProfile companyProfile;
    Map<String, FinancialData> financialData;
    Analysis analysis;
}
