package com.nikoladichev.financialreportanalyzer.model.common;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheet;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlow;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialStatementItem {
    private AVIncomeStatement incomeStatement;
    private AVBalanceSheet balanceSheet;
    private AVCashFlow cashFlow;
}
