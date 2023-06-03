package com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FundamentalData {
    private String symbol;
    private IncomeStatement incomeStatement;
    private BalanceSheetStatement balanceSheetStatement;
    private CashFlowStatement cashFlowStatement;
    private EnterpriseValues enterpriseValues;
    private Ratios ratios;
}
