package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseValuesId implements Serializable {
    /** The date of the financial data. */
    private @Id String date;

    /** The symbol representing the company. */
    private @Id String symbol;
}

