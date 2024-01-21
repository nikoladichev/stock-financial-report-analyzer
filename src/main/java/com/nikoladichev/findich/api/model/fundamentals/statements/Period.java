package com.nikoladichev.findich.api.model.fundamentals.statements;

public enum Period {
    QUARTERLY,
    ANNUAL,

    LTM;

    @Override
    public String toString() {
        return this.name();
    }
}