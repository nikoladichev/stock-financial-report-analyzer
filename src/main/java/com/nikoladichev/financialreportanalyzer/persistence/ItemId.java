package com.nikoladichev.financialreportanalyzer.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemId implements Serializable {
    private String uuid;
    private String symbol;
}
