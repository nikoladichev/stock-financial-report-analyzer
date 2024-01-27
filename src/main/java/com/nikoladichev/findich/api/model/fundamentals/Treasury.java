package com.nikoladichev.findich.api.model.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Treasury {
    private String date;
    private Double month1;
    private Double month2;
    private Double month3;
    private Double month6;
    private Double year1;
    private Double year2;
    private Double year3;
    private Double year5;
    private Double year7;
    private Double year10;
    private Double year20;
    private Double year30;
}
