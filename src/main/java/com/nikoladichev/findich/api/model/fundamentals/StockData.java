package com.nikoladichev.findich.api.model.fundamentals;

import java.util.Map;
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
}
