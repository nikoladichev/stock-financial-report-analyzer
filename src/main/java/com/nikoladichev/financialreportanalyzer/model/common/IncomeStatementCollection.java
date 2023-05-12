package com.nikoladichev.financialreportanalyzer.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatementCollection {
    private String symbol;
    private Map<Date, IncomeStatement> entries;
}
