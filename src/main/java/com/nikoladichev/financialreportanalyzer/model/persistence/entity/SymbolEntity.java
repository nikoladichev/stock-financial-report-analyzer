package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class SymbolEntity {
    @Id
    @NotNull
    private final String symbol;
}
