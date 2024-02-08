package com.nikoladichev.findich.api.model.fundamentals;

import com.nikoladichev.findich.api.integration.yahoofinance.response.Analysis;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialData {
    IncomeStatement incomeStatement;
    BalanceSheetStatement balanceSheetStatement;
    CashFlowStatement cashFlowStatement;
}
