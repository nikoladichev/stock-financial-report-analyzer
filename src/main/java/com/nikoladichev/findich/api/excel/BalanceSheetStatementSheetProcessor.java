package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BalanceSheetStatementSheetProcessor extends SheetProcessor<BalanceSheetStatement> {

  private static class RowConstants {
    private static final int FISCAL_YEAR = 1;
    private static final int FILLING_DATE = 2;
    private static final int CASH_AND_EQUIVALENTS = 4;
    private static final int SHORT_TERM_INVESTMENTS = 5;
    private static final int TOTAL_CASH_AND_SHORT_TERM_INVESTMENTS = 6;
    private static final int RECEIVABLES = 8;
    private static final int INVENTORIES = 10;
    private static final int OTHER_CURRENT_ASSETS = 11;
    private static final int TOTAL_CURRENT_ASSETS = 12;
    private static final int NET_PROPERTY_PLANT_AND_EQUIPMENT = 14;
    private static final int GOODWILL = 16;
    private static final int INTANGIBLE_ASSETS = 17;
    private static final int TOTAL_GOODWILL_AND_INTANGIBLE_ASSETS = 18;
    private static final int LONG_TERM_INVESTMENTS = 20;
    private static final int OTHER_LONG_TERM_ASSETS = 21;
    private static final int TOTAL_NON_CURRENT_ASSETS = 22;
    private static final int TOTAL_ASSETS = 24;
    private static final int ACCOUNTS_PAYABLE = 27;
    private static final int SHORT_TERM_DEBT = 28;
    private static final int TAX_PAYABLES = 29;
    private static final int DEFFERED_REVENUE = 30;
    private static final int OTHER_CURRENT_LIABILITIES = 31;
    private static final int TOTAL_CURRENT_LIABILITIES = 32;
    private static final int LONG_TERM_DEBT = 34;
    private static final int DEFERRED_TAX_LIABILITIES = 35;
    private static final int OTHER_NON_CURRENT_LIABILITIES = 36;
    private static final int TOTAL_NON_CURRENT_LIABILITIES = 37;
    private static final int TOTAL_LIABILITIES = 39;
    private static final int COMMON_STOCK = 41;
    private static final int RETAINED_EARNINGS = 42;
    private static final int ACCUMULATED_OTHER_COMPREHENSIVE_INCOME_LOSS = 43;
    private static final int TOTAL_EQUITY = 44;
    private static final int TOTAL_LIABILITIES_AND_EQUITY = 46;
    private static final int TOTAL_DEBT = 49;
    private static final int NET_DEBT = 50;
    private static final int TOTAL_INVESTMENTS = 51;
  }

  @Override
  protected Sheet getSheet(Workbook workbook) {
    return workbook.getSheet("BS");
  }

  @Override
  protected void processData(BalanceSheetStatement source, Sheet sheet, int col) {
    // Header
    getCell(sheet, RowConstants.FISCAL_YEAR, col)
        .setCellValue(source.getPeriod() + "_" + source.getCalendarYear());
    getCell(sheet, RowConstants.FILLING_DATE, col).setCellValue(source.getDate());

    // ASSETS
    // Total Current Assets
    getCell(sheet, RowConstants.CASH_AND_EQUIVALENTS, col)
        .setCellValue(source.getCashAndCashEquivalents());
    getCell(sheet, RowConstants.SHORT_TERM_INVESTMENTS, col)
        .setCellValue(source.getShortTermInvestments());
    getCell(sheet, RowConstants.TOTAL_CASH_AND_SHORT_TERM_INVESTMENTS, col)
        .setCellValue(source.getCashAndShortTermInvestments());

    getCell(sheet, RowConstants.RECEIVABLES, col).setCellValue(source.getNetReceivables());

    getCell(sheet, RowConstants.INVENTORIES, col).setCellValue(source.getInventory());
    getCell(sheet, RowConstants.OTHER_CURRENT_ASSETS, col)
        .setCellValue(source.getCalculatedOtherCurrentAssets());
    getCell(sheet, RowConstants.TOTAL_CURRENT_ASSETS, col)
        .setCellValue(source.getTotalCurrentAssets());

    // Total Non-current Assets
    getCell(sheet, RowConstants.NET_PROPERTY_PLANT_AND_EQUIPMENT, col)
        .setCellValue(source.getPropertyPlantEquipmentNet());

    getCell(sheet, RowConstants.GOODWILL, col).setCellValue(source.getGoodwill());
    getCell(sheet, RowConstants.INTANGIBLE_ASSETS, col).setCellValue(source.getIntangibleAssets());
    getCell(sheet, RowConstants.TOTAL_GOODWILL_AND_INTANGIBLE_ASSETS, col)
        .setCellValue(source.getGoodwillAndIntangibleAssets());

    getCell(sheet, RowConstants.LONG_TERM_INVESTMENTS, col)
        .setCellValue(source.getLongTermInvestments());
    getCell(sheet, RowConstants.OTHER_LONG_TERM_ASSETS, col)
        .setCellValue(source.getCalculatedOtherNonCurrentAssets());
    getCell(sheet, RowConstants.TOTAL_NON_CURRENT_ASSETS, col)
        .setCellValue(source.getTotalNonCurrentAssets());

    // Total Assets
    getCell(sheet, RowConstants.TOTAL_ASSETS, col).setCellValue(source.getTotalAssets());

    // LIABILITIES
    // Total Current Liabilities
    getCell(sheet, RowConstants.ACCOUNTS_PAYABLE, col).setCellValue(source.getAccountPayables());
    getCell(sheet, RowConstants.SHORT_TERM_DEBT, col).setCellValue(source.getShortTermDebt());
    getCell(sheet, RowConstants.TAX_PAYABLES, col).setCellValue(source.getTaxPayables());
    getCell(sheet, RowConstants.DEFFERED_REVENUE, col).setCellValue(source.getDeferredRevenue());
    getCell(sheet, RowConstants.OTHER_CURRENT_LIABILITIES, col)
        .setCellValue(source.getCalculatedOtherCurrentLiabilities());
    getCell(sheet, RowConstants.TOTAL_CURRENT_LIABILITIES, col)
        .setCellValue(source.getTotalCurrentLiabilities());

    // Total Non-current Liabilities
    getCell(sheet, RowConstants.LONG_TERM_DEBT, col).setCellValue(source.getLongTermDebt());
    getCell(sheet, RowConstants.DEFERRED_TAX_LIABILITIES, col)
        .setCellValue(source.getDeferredTaxLiabilitiesNonCurrent());
    getCell(sheet, RowConstants.OTHER_NON_CURRENT_LIABILITIES, col)
        .setCellValue(source.getCalculatedOtherNonCurrentLiabilities());
    getCell(sheet, RowConstants.TOTAL_NON_CURRENT_LIABILITIES, col)
        .setCellValue(source.getTotalNonCurrentLiabilities());

    // Total Liabilities
    getCell(sheet, RowConstants.TOTAL_LIABILITIES, col).setCellValue(source.getTotalLiabilities());

    // TOTAL EQUITY
    getCell(sheet, RowConstants.COMMON_STOCK, col).setCellValue(source.getCommonStock());
    getCell(sheet, RowConstants.RETAINED_EARNINGS, col).setCellValue(source.getRetainedEarnings());
    getCell(sheet, RowConstants.ACCUMULATED_OTHER_COMPREHENSIVE_INCOME_LOSS, col).setCellValue(source.getAccumulatedOtherComprehensiveIncomeLoss());
    getCell(sheet, RowConstants.TOTAL_EQUITY, col).setCellValue(source.getTotalEquity());

    // TOTAL LIABILITIES AND EQUITY
    getCell(sheet, RowConstants.TOTAL_LIABILITIES_AND_EQUITY, col).setCellValue(source.getTotalLiabilitiesAndTotalEquity());

    // Supplemental Items
    getCell(sheet, RowConstants.TOTAL_DEBT, col).setCellValue(source.getTotalDebt());
    getCell(sheet, RowConstants.NET_DEBT, col).setCellValue(source.getNetDebt());
    getCell(sheet, RowConstants.TOTAL_INVESTMENTS, col).setCellValue(source.getTotalInvestments());
  }
}
