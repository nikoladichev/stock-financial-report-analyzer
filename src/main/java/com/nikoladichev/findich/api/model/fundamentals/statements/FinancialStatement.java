package com.nikoladichev.findich.api.model.fundamentals.statements;

public interface FinancialStatement {
    String getDate();
    FinancialStatementType getStatementType();
}
