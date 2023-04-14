package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AlphaVantageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CashFlowReport extends AlphaVantageResponse {
    private CashFlowReportItem[] annualReports;
    private CashFlowReportItem[] quarterlyReports;
}
