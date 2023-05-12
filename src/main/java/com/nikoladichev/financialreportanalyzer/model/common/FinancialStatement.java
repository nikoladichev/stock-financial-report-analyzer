package com.nikoladichev.financialreportanalyzer.model.common;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class FinancialStatement {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Map<String, FinancialStatementItem> financialStatement;

    public FinancialStatement(AVIncomeStatements AVIncomeStatements,
                              AVBalanceSheets AVBalanceSheets,
                              AVCashFlows AVCashFlows,
                              FinancialStatementType type) {
        AVIncomeStatement[] incomeStatementRecords =
                type == FinancialStatementType.QUARTERLY
                        ? AVIncomeStatements.getQuarterlyReports()
                        : AVIncomeStatements.getAnnualReports();
        AVBalanceSheet[] balanceSheetReportItems =
                type == FinancialStatementType.QUARTERLY
                        ? AVBalanceSheets.getQuarterlyReports()
                        : AVBalanceSheets.getAnnualReports();
        AVCashFlow[] cashFlowReportItems =
                type == FinancialStatementType.QUARTERLY
                        ? AVCashFlows.getQuarterlyReports()
                        : AVCashFlows.getAnnualReports();

        this.financialStatement = new LinkedHashMap<>();
        for (AVIncomeStatement income : incomeStatementRecords) {
            String date = sdf.format(income.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setIncomeStatement(income);
            this.financialStatement.put(date, financialStatement);
        }

        for (AVBalanceSheet balance : balanceSheetReportItems) {
            String date = sdf.format(balance.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setBalanceSheet(balance);
            this.financialStatement.put(date, financialStatement);
        }

        for (AVCashFlow cashFlow : cashFlowReportItems) {
            String date = sdf.format(cashFlow.getFiscalDateEnding());
            FinancialStatementItem financialStatement =
                    this.financialStatement.getOrDefault(date, new FinancialStatementItem());

            financialStatement.setCashFlow(cashFlow);
            this.financialStatement.put(date, financialStatement);
        }
    }
}
