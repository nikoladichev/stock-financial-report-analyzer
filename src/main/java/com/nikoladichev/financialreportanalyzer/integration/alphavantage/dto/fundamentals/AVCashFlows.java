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
public class AVCashFlows extends AVResponse {
    private AVCashFlow[] annualReports;
    private AVCashFlow[] quarterlyReports;
}
