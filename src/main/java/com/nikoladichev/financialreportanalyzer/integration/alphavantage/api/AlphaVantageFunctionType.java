package com.nikoladichev.financialreportanalyzer.integration.alphavantage.api;

public enum AlphaVantageFunctionType {
    OVERVIEW("OVERVIEW"),
    INCOME_STATEMENT("INCOME_STATEMENT"),
    BALANCE_SHEET("BALANCE_SHEET"),
    CASH_FLOW("CASH_FLOW");

    private final String value;

    private AlphaVantageFunctionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
