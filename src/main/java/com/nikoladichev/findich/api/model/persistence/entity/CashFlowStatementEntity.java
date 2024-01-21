package com.nikoladichev.findich.api.model.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CashFlowStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String symbol;
    private String period;
    private String reportedCurrency;
    private String cik;
    private String fillingDate;
    private String acceptedDate;
    private String calendarYear;
    private long netIncome;
    private long depreciationAndAmortization;
    private long deferredIncomeTax;
    private long stockBasedCompensation;
    private long changeInWorkingCapital;
    private long accountsReceivables;
    private long inventory;
    private long accountsPayables;
    private long otherWorkingCapital;
    private long otherNonCashItems;
    private long netCashProvidedByOperatingActivities;
    private long investmentsInPropertyPlantAndEquipment;
    private long acquisitionsNet;
    private long purchasesOfInvestments;
    private long salesMaturitiesOfInvestments;
    private long otherInvestingActivites;
    private long netCashUsedForInvestingActivites;
    private long debtRepayment;
    private long commonStockIssued;
    private long commonStockRepurchased;
    private long dividendsPaid;
    private long otherFinancingActivites;
    private long netCashUsedProvidedByFinancingActivities;
    private long effectOfForexChangesOnCash;
    private long netChangeInCash;
    private long cashAtEndOfPeriod;
    private long cashAtBeginningOfPeriod;
    private long operatingCashFlow;
    private long capitalExpenditure;
    private long freeCashFlow;
    private String link;
    private String finalLink;
    private long calculatedOtherWorkingCapital;
}