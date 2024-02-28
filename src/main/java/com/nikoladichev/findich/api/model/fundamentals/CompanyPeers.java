package com.nikoladichev.findich.api.model.fundamentals;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class CompanyPeers {
    private final String symbol;
    private final Set<CompanyPeers> peers;
}
