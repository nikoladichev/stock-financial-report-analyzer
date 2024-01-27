package com.nikoladichev.findich.api.controller;

import com.nikoladichev.findich.api.service.ExcelManipulationService;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{symbol}/valuation")
@RequiredArgsConstructor
public class ValuationController {
  private final ExcelManipulationService service;

  private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public ResponseEntity<Resource> getStockData(@PathVariable String symbol) {
    return ResponseEntity.ok()
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=" + "FINDich_" + symbol + "_" + sdf.format(new Date()) + ".xlsx")
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
        .body(new InputStreamResource(service.fillTemplateWithData(symbol)));
  }
}
