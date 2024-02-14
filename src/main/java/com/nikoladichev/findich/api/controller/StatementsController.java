package com.nikoladichev.findich.api.controller;

import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.fundamentals.StockData;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
import com.nikoladichev.findich.api.service.FundamentalsService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{symbol}")
@RequiredArgsConstructor
public class StatementsController {
  private final FundamentalsService service;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public StockData getStockData (@PathVariable String symbol){
    return service.getStockData(symbol);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/company-profile")
  public CompanyProfile companyProfile(@PathVariable String symbol) {
    return service.getCompanyProfile(symbol);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/statements/income")
  public Set<IncomeStatement> incomeStatements(
      @PathVariable String symbol,
      @RequestParam(required = false, defaultValue = "ANNUAL") Period period) {
    return service.getIncomeStatements(symbol, period);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/statements/balance-sheet")
  public Set<BalanceSheetStatement> balanceSheetStatements(
          @PathVariable String symbol,
          @RequestParam(required = false, defaultValue = "ANNUAL") Period period) {
    return service.getBalanceSheetStatements(symbol, period);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/statements/cash-flow")
  public Set<CashFlowStatement> cashFlowStatements(
      @PathVariable String symbol,
      @RequestParam(required = false, defaultValue = "ANNUAL") Period period) {
    return service.getCashFlowStatements(symbol, period);
  }
}
