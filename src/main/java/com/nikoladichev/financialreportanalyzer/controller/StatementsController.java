package com.nikoladichev.financialreportanalyzer.controller;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import com.nikoladichev.financialreportanalyzer.service.FinancialStatementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{symbol}")
@RequiredArgsConstructor
public class StatementsController {
  private final FinancialStatementService service;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/income-statement")
  public List<IncomeStatement> incomeStatements(
      @PathVariable String symbol,
      @RequestParam(required = false, defaultValue = "ANNUAL") Period period,
      @RequestParam(required = false) Integer limit) {
    return service.getIncomeStatements(symbol, period, limit);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/balance-sheet-statement")
  public List<BalanceSheetStatement> balanceSheetStatements(
          @PathVariable String symbol,
          @RequestParam(required = false, defaultValue = "ANNUAL") Period period,
          @RequestParam(required = false) Integer limit) {
    return service.getBalanceSheetStatements(symbol, period, limit);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/cash-flow-statement")
  public List<CashFlowStatement> cashFlowStatements(
          @PathVariable String symbol,
          @RequestParam(required = false, defaultValue = "ANNUAL") Period period,
          @RequestParam(required = false) Integer limit) {
    return service.getCashFlowStatements(symbol, period, limit);
  }
}
