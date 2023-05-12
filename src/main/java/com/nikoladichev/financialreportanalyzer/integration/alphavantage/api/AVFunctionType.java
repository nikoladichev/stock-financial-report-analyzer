package com.nikoladichev.financialreportanalyzer.integration.alphavantage.api;

public enum AVFunctionType {
    OVERVIEW("OVERVIEW"),
    INCOME_STATEMENT("INCOME_STATEMENT"),
    BALANCE_SHEET("BALANCE_SHEET"),
    CASH_FLOW("CASH_FLOW");

    private final String value;

    private AVFunctionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
