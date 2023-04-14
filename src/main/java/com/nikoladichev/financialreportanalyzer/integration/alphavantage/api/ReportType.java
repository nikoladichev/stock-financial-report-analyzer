package com.nikoladichev.financialreportanalyzer.integration.alphavantage.api;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.*;

public enum ReportType {
    INCOME_STATEMENT("INCOME_STATEMENT"),
    BALANCE_SHEET("BALANCE_SHEET"),
    CASH_FLOW("CASH_FLOW");

    private final String value;

    private ReportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
