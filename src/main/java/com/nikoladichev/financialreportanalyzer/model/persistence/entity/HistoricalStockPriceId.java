package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalStockPriceId implements Serializable {
    /** The date of the financial data. */
    @Temporal(TemporalType.DATE)
    private @Id LocalDate date;

    /** The symbol representing the company. */
    private @Id String symbol;
}

