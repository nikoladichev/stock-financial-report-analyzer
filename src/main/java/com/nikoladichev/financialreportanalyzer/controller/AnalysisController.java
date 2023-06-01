package com.nikoladichev.financialreportanalyzer.controller;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.analysis.FundamentalAnalysis;
import com.nikoladichev.financialreportanalyzer.service.StockAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{symbol}")
@RequiredArgsConstructor
public class AnalysisController {

  private final StockAnalysisService service;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/analysis")
  public FundamentalAnalysis analyze(@PathVariable String symbol) {
    return service.executeAnalysis(symbol);
  }
}
