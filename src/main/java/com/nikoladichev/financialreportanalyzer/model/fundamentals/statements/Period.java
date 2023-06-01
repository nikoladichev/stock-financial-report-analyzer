package com.nikoladichev.financialreportanalyzer.model.fundamentals.statements;

public enum Period {
    QUARTER,
    ANNUAL;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}