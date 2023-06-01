package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FundamentalAnalysis {
    private List<IncomeStatement> incomeStatements;
    private List<BalanceSheetStatement> balanceSheetStatements;
    private List<CashFlowStatement> cashFlowStatements;
    private List<Ratios> ratios;
    private List<Ratios> ratiosTTM;
}
