package com.nikoladichev.financialreportanalyzer.model.common;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReportItem;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReportItem;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReportItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialStatementItem {
    private IncomeStatementReportItem incomeStatement;
    private BalanceSheetReportItem balanceSheet;
    private CashFlowReportItem cashFlow;
}
