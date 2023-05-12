package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.AVResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AVIncomeStatements extends AVResponse {
    private AVIncomeStatement[] annualReports;
    private AVIncomeStatement[] quarterlyReports;
}
