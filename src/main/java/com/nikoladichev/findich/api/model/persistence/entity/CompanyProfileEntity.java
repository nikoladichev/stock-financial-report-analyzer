package com.nikoladichev.findich.api.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class CompanyProfileEntity {
    private @Id String symbol;
    private String date;
    @Column(columnDefinition = "DECIMAL(20,2)")
    private double price;
    @Column(columnDefinition = "DECIMAL(20,2)")
    private double beta;
    private Long volAvg;
    @Column(columnDefinition = "DECIMAL(20,2)")
    private BigDecimal mktCap;
    @Column(columnDefinition = "DECIMAL(20, 2)")
    private double lastDiv;
    @Column(columnDefinition = "DECIMAL(20,2)")
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
    @Column(columnDefinition = "DECIMAL(20,2)")
    private double dcfDiff;
    @Column(columnDefinition = "DECIMAL(20,2)")
    private double dcf;
    private String image;
    private String ipoDate;
    private boolean defaultImage;
    private boolean isEtf;
    private boolean isActivelyTrading;
    private boolean isAdr;
    private boolean isFund;
    @Column(columnDefinition = "DECIMAL(20,2)")
    private double rangeMin;
    @Column(columnDefinition = "DECIMAL(20,2)", nullable = false)
    private double rangeMax;
    private String reportedCurrency;
}
