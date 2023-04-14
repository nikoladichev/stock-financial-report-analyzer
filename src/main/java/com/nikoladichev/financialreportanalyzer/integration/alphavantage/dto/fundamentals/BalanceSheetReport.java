package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BalanceSheetReport extends AlphaVantageResponse {
    private BalanceSheetReportItem[] annualReports;
    private BalanceSheetReportItem[] quarterlyReports;
}
