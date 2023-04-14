package com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AlphaVantageReportItem {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fiscalDateEnding;
    private String reportedCurrency;
}
