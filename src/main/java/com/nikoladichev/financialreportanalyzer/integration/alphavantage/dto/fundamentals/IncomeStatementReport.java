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
public class IncomeStatementReport extends AlphaVantageResponse {
    private IncomeStatementReportItem[] annualReports;
    private IncomeStatementReportItem[] quarterlyReports;
}
