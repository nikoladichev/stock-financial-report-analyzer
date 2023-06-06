package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalStockPriceId implements Serializable {
    /** The date of the financial data. */
    private @Id String date;

    /** The symbol representing the company. */
    private @Id String symbol;
}

