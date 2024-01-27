package com.nikoladichev.findich.api.model.fundamentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfile {
    private String symbol;
    private double price;
    private double beta;
    private long volAvg;
    private BigDecimal mktCap;
    private double lastDiv;
    private String range;
    private double changes;
    private String companyName;
    private String currency;
    private String cik;
    private String isin;
    private String cusip;
    private String exchange;
    private String exchangeShortName;
    private String industry;
    private String website;
    private String description;
    private String ceo;
    private String sector;
    private String country;
    private String fullTimeEmployees;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private double dcfDiff;
    private double dcf;
    private String image;
    private String ipoDate;
    private boolean defaultImage;
    private boolean isEtf;
    private boolean isActivelyTrading;
    private boolean isAdr;
    private boolean isFund;
    private double rangeMin;
    private double rangeMax;
    private String reportedCurrency;
}
