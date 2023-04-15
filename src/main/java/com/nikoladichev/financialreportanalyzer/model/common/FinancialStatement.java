package com.nikoladichev.financialreportanalyzer.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class FinancialStatement {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Map<String, FinancialStatementItem> financialStatement;

    public FinancialStatement(IncomeStatementReport incomeStatementReport,
                              BalanceSheetReport balanceSheetReport,
                              CashFlowReport cashFlowReport,
                              FinancialStatementType type) {
        IncomeStatementReportItem[] incomeStatementRecords =
                type == FinancialStatementType.QUARTERLY
                        ? incomeStatementReport.getQuarterlyReports()
                        : incomeStatementReport.getAnnualReports();
        BalanceSheetReportItem[] balanceSheetReportItems =
                type == FinancialStatementType.QUARTERLY
                        ? balanceSheetReport.getQuarterlyReports()
                        : balanceSheetReport.getAnnualReports();
        CashFlowReportItem[] cashFlowReportItems =
                type == FinancialStatementType.QUARTERLY
                        ? cashFlowReport.getQuarterlyReports()
                        : cashFlowReport.getAnnualReports();

        this.financialStatement = new LinkedHashMap<>();
        for (IncomeStatementReportItem income : incomeStatementRecords) {
            String date = sdf.format(income.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setIncomeStatement(income);
            this.financialStatement.put(date, financialStatement);
        }

        for (BalanceSheetReportItem balance : balanceSheetReportItems) {
            String date = sdf.format(balance.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setBalanceSheet(balance);
            this.financialStatement.put(date, financialStatement);
        }

        for (CashFlowReportItem cashFlow : cashFlowReportItems) {
            String date = sdf.format(cashFlow.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setCashFlow(cashFlow);
            this.financialStatement.put(date, financialStatement);
        }
    }
}
