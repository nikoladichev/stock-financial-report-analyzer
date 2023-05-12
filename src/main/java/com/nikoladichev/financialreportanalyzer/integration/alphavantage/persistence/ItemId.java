package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ItemId implements Serializable {
    private String uuid;
    private String symbol;
}
