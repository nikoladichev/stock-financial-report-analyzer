package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(StatementId.class)
public class CashFlowStatementEntity {
    /** The date of the financial data. */
    private @Id String date;

    /** The symbol representing the company. */
    private @Id String symbol;

    /** The period of the financial data (e.g., FY for fiscal year). */
    private @Id String period;

    /** The Central Index Key (CIK) of the company. */
    private String cik;

    /** The currency in which the financial data is reported. */
    private String reportedCurrency;

    /** The filing date of the financial data. */
    private String fillingDate;

    /** The accepted date of the financial data. */
    private String acceptedDate;

    /** The calendar year of the financial data. */
    private String calendarYear;

    /**
     * The net income of the company. It represents the company's earnings after deducting all
     * expenses and taxes.
     */
    private BigDecimal netIncome;

    /** The amount of depreciation and amortization expense incurred by the company. */
    private BigDecimal depreciationAndAmortization;

    /**
     * The change in deferred income tax, which represents the change in the company's tax liabilities
     * due to temporary differences between accounting and tax rules.
     */
    private BigDecimal deferredIncomeTax;

    /**
     * The value of stock-based compensation, which represents non-cash compensation provided to
     * employees in the form of company stock or stock options.
     */
    private BigDecimal stockBasedCompensation;

    /**
     * The change in working capital, which represents the change in the company's current assets and
     * current liabilities.
     */
    private BigDecimal changeInWorkingCapital;

    /**
     * The change in accounts receivables, which represents the change in the amount owed to the
     * company by customers.
     */
    private BigDecimal accountsReceivables;

    /**
     * The change in inventory, which represents the change in the value of goods held by the company
     * for sale.
     */
    private BigDecimal inventory;

    /**
     * The change in accounts payables, which represents the change in the amount owed by the company
     * to suppliers.
     */
    private BigDecimal accountsPayables;

    /**
     * The change in other working capital items, excluding accounts receivables, inventory, and
     * accounts payables.
     */
    private BigDecimal otherWorkingCapital;

    /**
     * The change in other non-cash items, which represents the change in non-cash expenses or
     * revenues.
     */
    private BigDecimal otherNonCashItems;

    /**
     * The net cash provided by operating activities, which represents the net cash generated or used
     * by the company's core operations.
     */
    private BigDecimal netCashProvidedByOperatingActivities;

    /**
     * The investments made in property, plant, and equipment, which represents the cash spent on
     * acquiring or upgrading physical assets.
     */
    private BigDecimal investmentsInPropertyPlantAndEquipment;

    /** The net amount spent on acquisitions, including the purchase price and associated costs. */
    private BigDecimal acquisitionsNet;

    /**
     * The purchases of investments, which represents the cash spent on acquiring financial
     * investments.
     */
    private BigDecimal purchasesOfInvestments;

    /**
     * The sales or maturities of investments, which represents the cash received from selling or
     * maturing financial investments.
     */
    private BigDecimal salesMaturitiesOfInvestments;

    /**
     * The other investing activities, which represents cash flows related to investing activities not
     * covered by other specific categories.
     */
    private BigDecimal otherInvestingActivites;

    /**
     * The net cash used for investing activities, which represents the net cash flow from the
     * company's investing activities.
     */
    private BigDecimal netCashUsedForInvestingActivites;

    /**
     * The amount of debt repayment, which represents the cash paid towards reducing the company's
     * debt obligations.
     */
    private BigDecimal debtRepayment;

    /**
     * The amount of common stock issued, which represents the cash received from issuing new common
     * stock.
     */
    private BigDecimal commonStockIssued;

    /**
     * The amount of common stock repurchased, which represents the cash spent on buying back
     * company's own common stock.
     */
    private BigDecimal commonStockRepurchased;

    /** The dividends paid by the company to its shareholders. */
    private BigDecimal dividendsPaid;

    /**
     * The other financing activities, which represents cash flows related to financing activities not
     * covered by other specific categories.
     */
    private BigDecimal otherFinancingActivites;

    /**
     * The net cash used/provided by financing activities, which represents the net cash flow from the
     * company's financing activities.
     */
    private BigDecimal netCashUsedProvidedByFinancingActivities;

    /** The effect of foreign exchange rate changes on cash. */
    private BigDecimal effectOfForexChangesOnCash;

    /**
     * The net change in cash, which represents the overall change in the company's cash balance
     * during the specified period.
     */
    private BigDecimal netChangeInCash;

    /** The cash balance at the end of the period. */
    private BigDecimal cashAtEndOfPeriod;

    /** The cash balance at the beginning of the period. */
    private BigDecimal cashAtBeginningOfPeriod;

    /**
     * The operating cash flow, which represents the cash generated by the company's core operations.
     */
    private BigDecimal operatingCashFlow;

    /**
     * The capital expenditure, which represents the cash spent on acquiring or upgrading property,
     * plant, and equipment.
     */
    private BigDecimal capitalExpenditure;

    /**
     * The free cash flow, which represents the cash flow available for distribution to investors
     * after deducting capital expenditures from operating cash flow.
     */
    private BigDecimal freeCashFlow;

    /** The link to the financial data on the SEC website. */
    private String link;

    /** The final link to the specific financial filing on the SEC website. */
    private String finalLink;
}

