package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AlphaVantageResponse {
    private String symbol;
}
