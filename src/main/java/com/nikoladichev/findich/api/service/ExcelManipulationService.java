package com.nikoladichev.findich.api.service;

import com.nikoladichev.findich.api.excel.*;
import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
import java.io.*;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ExcelManipulationService {

  @Value("classpath:templates/FINDich.xlsx")
  private Resource templateResource;

  private final FundamentalsService fundamentalsService;
  private final InfoSheetProcessor infoSheetProcessor;
  private final IncomeStatementSheetProcessor incomeStatementSheetProcessor;
  private final BalanceSheetStatementSheetProcessor balanceSheetStatementSheetProcessor;
  private final CashFlowStatementSheetProcessor cashFlowStatementSheetProcessor;
  private final AnalysisSheetProcessor analysisSheetProcessor;

  @Transactional
  public ByteArrayInputStream fillTemplateWithData(String symbol) {
    try (var in = new FileInputStream(templateResource.getFile());
        var workbook = new XSSFWorkbook(in);
        var out = new ByteArrayOutputStream()) {

      var formulaEvaluator = new XSSFFormulaEvaluator(workbook);
      formulaEvaluator.clearAllCachedResultValues();

      fillRevenueBuildSheetData(symbol, workbook);
      fillAnalysisSheetData(symbol, workbook);
      fillInfoSheetData(symbol, workbook);
      fillBalanceSheetData(symbol, workbook);
      fillCashFlowData(symbol, workbook);
      fillIncomeStatementData(symbol, workbook);

      // refresh all formulas
      XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (FileNotFoundException e) {
      log.error("Can't load template", e);
    } catch (IOException e) {
      log.error("Error when loading template", e);
      throw new RuntimeException(e);
    }

    return null;
  }

  private void fillInfoSheetData(String symbol, Workbook workbook) {
    var stockData = fundamentalsService.getStockData(symbol);
    var treasury = fundamentalsService.getTreasury();
    infoSheetProcessor.process(stockData.getCompanyProfile(), treasury, workbook);
  }

  private void fillIncomeStatementData(String symbol, Workbook workbook) {
    var statements = new ArrayList<IncomeStatement>();
    statements.addAll(fundamentalsService.getIncomeStatements(symbol, Period.ANNUAL));
    statements.addAll(fundamentalsService.getIncomeStatements(symbol, Period.LTM));
    incomeStatementSheetProcessor.process(workbook, statements);
  }

  private void fillCashFlowData(String symbol, Workbook workbook) {
    var statements = new ArrayList<CashFlowStatement>();
    statements.addAll(fundamentalsService.getCashFlowStatements(symbol, Period.ANNUAL));
    statements.addAll(fundamentalsService.getCashFlowStatements(symbol, Period.LTM));
    cashFlowStatementSheetProcessor.process(workbook, statements);
  }

  private void fillBalanceSheetData(String symbol, Workbook workbook) {
    var statements = new ArrayList<BalanceSheetStatement>();
    statements.addAll(fundamentalsService.getBalanceSheetStatements(symbol, Period.ANNUAL));
    statements.addAll(fundamentalsService.getBalanceSheetStatements(symbol, Period.LTM));
    balanceSheetStatementSheetProcessor.process(workbook, statements);
  }

  private void fillAnalysisSheetData(String symbol, Workbook workbook) {
    var analysis = fundamentalsService.getAnalysis(symbol);
    analysisSheetProcessor.process(workbook, analysis);
  }

  private void fillRevenueBuildSheetData(String symbol, Workbook workbook) {
    var revenueBuild = fundamentalsService.getRevenueBuild(symbol);

    System.out.println(
        "RevenueBuild sheet processor is not ready. RevenueBuild: " + revenueBuild.toString());
  }
}
