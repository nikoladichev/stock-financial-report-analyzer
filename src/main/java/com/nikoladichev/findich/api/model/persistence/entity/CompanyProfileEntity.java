package com.nikoladichev.findich.api.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CompanyProfileEntity {
    private @Id String symbol;
    private String date;
    @Column(columnDefinition = "DECIMAL")
    private double price;
    @Column(columnDefinition = "DECIMAL")
    private double beta;
    private Long volAvg;
    @Column(columnDefinition = "DECIMAL")
    private double mktCap;
    @Column(columnDefinition = "DECIMAL")
    private double lastDiv;
    @Column(columnDefinition = "DECIMAL")
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
    @Column(columnDefinition = "TEXT")
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
    @Column(columnDefinition = "DECIMAL")
    private double dcfDiff;
    @Column(columnDefinition = "DECIMAL")
    private double dcf;
    private String image;
    private String ipoDate;
    private boolean defaultImage;
    private boolean isEtf;
    private boolean isActivelyTrading;
    private boolean isAdr;
    private boolean isFund;
    @Column(columnDefinition = "DECIMAL")
    private double rangeMin;
    @Column(columnDefinition = "DECIMAL", nullable = false)
    private double rangeMax;
    private String reportedCurrency;
}
