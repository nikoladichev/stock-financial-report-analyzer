package com.nikoladichev.financialreportanalyzer.controller;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheets;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVOverview;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatement;
import com.nikoladichev.financialreportanalyzer.model.common.FinancialStatementType;
import com.nikoladichev.financialreportanalyzer.model.common.IncomeStatementCollection;
import com.nikoladichev.financialreportanalyzer.service.StockAnalyzerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StockAnalyzerController {

    private final StockAnalyzerService service;

//    TODO - enable this when using normalized data!
//    @Operation(summary = "Get the financial statements of the company by its ticket symbol")
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "Found the financial statement",
//                    content = {
//                            @Content(mediaType = "application/json",
//                                    schema = @Schema(implementation = FinancialStatement.class)) }),
//            @ApiResponse(responseCode = "400",
//                    description = "Invalid symbol supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404",
//                    description = "Financial statement not found",
//                    content = @Content)
//    })
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{symbol}/quarterly")
//    public FinancialStatement getQuarterlyFinancialStatement(@PathVariable("symbol") String symbol) {
//        return service.getFinancialStatement(symbol, FinancialStatementType.QUARTERLY);
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{symbol}/annual")
//    public FinancialStatement getAnnualFinancialStatement(@PathVariable("symbol") String symbol) {
//        return service.getFinancialStatement(symbol, FinancialStatementType.ANNUAL);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{symbol}/income-statement")
    public IncomeStatementCollection incomeStatement(@PathVariable("symbol") String symbol) {
        return service.getIncomeStatementCollection(symbol);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{symbol}/balance-sheet")
    public AVBalanceSheets balanceSheet(@PathVariable("symbol") String symbol) {
        return service.getBalanceSheetReport(symbol);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{symbol}/cash-flow")
    public AVCashFlows cashFlow(@PathVariable("symbol") String symbol) {
        return service.getCashFlowReport(symbol);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{symbol}/overview")
    public AVOverview overview(@PathVariable("symbol") String symbol) {
        return service.getOverview(symbol);
    }
}
