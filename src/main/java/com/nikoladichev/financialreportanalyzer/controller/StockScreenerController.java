package com.nikoladichev.financialreportanalyzer.controller;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.Stock;
import com.nikoladichev.financialreportanalyzer.service.StockScreenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screener")
@RequiredArgsConstructor
public class StockScreenerController {

    private final StockScreenerService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/stock-screener")
    public List<Stock> stockScreener() {
        return service.getStocks();
    }
}
