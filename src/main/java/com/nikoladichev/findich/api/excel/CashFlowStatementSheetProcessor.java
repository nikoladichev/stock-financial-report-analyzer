package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CashFlowStatementSheetProcessor extends SheetProcessor<CashFlowStatement> {

  private static class RowConstants {
    private static final int FISCAL_YEAR = 1;
    private static final int FILLING_DATE = 2;
    private static final int NET_INCOME = 3;
    private static final int DEPRECIATION_AND_AMORTIZATION = 5;
    private static final int ACCOUNTS_RECEIVABLE = 7;
    private static final int INVENTORY = 8;
    private static final int ACCOUNTS_PAYABLE = 9;
    private static final int DEFERRED_REVENUE = 10;
    private static final int OTHER_WORKING_CAPITAL = 11;
    private static final int CHANGES_IN_WORKING_CAPITAL = 12;
    private static final int DEFERRED_INCOME_TAX = 14;
    private static final int STOCK_BASED_COMPENSATION = 15;
    private static final int OTHER_NON_CASH_ITEMS = 16;
    private static final int CASH_FROM_OPERATIONS = 17;
    private static final int INVESTMENTS_IN_PROPERTY = 19;
    private static final int PAYMENTS_FOR_ACQUISITIONS = 20;
    private static final int PURCHASE_OF_SECURITIES = 21;
    private static final int SALES_AND_MATURITIES_OF_SECURITIES = 22;
    private static final int OTHER_INVESTING_ACTIVITIES = 23;
    private static final int CASH_FROM_INVESTING = 24;
    private static final int DEBT_REPAYMENT = 26;
    private static final int DIVIDENDS_PAID = 27;
    private static final int COMMON_STOCK_ISSUED = 28;
    private static final int COMMON_STOCK_REPURCHASED = 29;
    private static final int OTHER_FINANCING_ACTIVITIES = 30;
    private static final int CASH_FROM_FINANCING_ACTIVITIES = 31;
    private static final int EFFECT_ON_FOREX = 33;
    private static final int NET_CHANGE_IN_CASH = 35;
    private static final int OPERATING_CASH_FLOW = 37;
    private static final int CAPEX = 38;
    private static final int FREE_CASH_FLOW = 39;
    private static final int CASH_AT_BEGINNING_OF_PERIOD = 42;
    private static final int CASH_AT_END_OF_PERIOD = 43;
  }

  @Override
  protected Sheet getSheet(Workbook workbook) {
    return workbook.getSheet("CF");
  }

  @Override
  protected void processData(CashFlowStatement source, Sheet sheet, int col) {
    // Header
    getCell(sheet, RowConstants.FISCAL_YEAR, col)
        .setCellValue(source.getPeriod() + "_" + source.getCalendarYear());
    getCell(sheet, RowConstants.FILLING_DATE, col).setCellValue(source.getDate());

    // Cash from operations
    getCell(sheet, RowConstants.NET_INCOME, col).setCellValue(source.getNetIncome());

    getCell(sheet, RowConstants.DEPRECIATION_AND_AMORTIZATION, col).setCellValue(source.getDepreciationAndAmortization());

    getCell(sheet, RowConstants.ACCOUNTS_RECEIVABLE, col).setCellValue(source.getAccountsReceivables());
    getCell(sheet, RowConstants.INVENTORY, col).setCellValue(source.getInventory());
    getCell(sheet, RowConstants.ACCOUNTS_PAYABLE, col).setCellValue(source.getAccountsPayables());
    getCell(sheet, RowConstants.DEFERRED_REVENUE, col).setCellValue(source.getOtherWorkingCapital());
    getCell(sheet, RowConstants.OTHER_WORKING_CAPITAL, col).setCellValue(source.getCalculatedOtherWorkingCapital());
    getCell(sheet, RowConstants.CHANGES_IN_WORKING_CAPITAL, col).setCellValue(source.getChangeInWorkingCapital());

    getCell(sheet, RowConstants.DEFERRED_INCOME_TAX, col).setCellValue(source.getDeferredIncomeTax());
    getCell(sheet, RowConstants.STOCK_BASED_COMPENSATION, col).setCellValue(source.getStockBasedCompensation());
    getCell(sheet, RowConstants.OTHER_NON_CASH_ITEMS, col).setCellValue(source.getOtherNonCashItems());
    getCell(sheet, RowConstants.CASH_FROM_OPERATIONS, col).setCellValue(source.getNetCashProvidedByOperatingActivities());

    // Cash from Investing
    getCell(sheet, RowConstants.INVESTMENTS_IN_PROPERTY, col).setCellValue(source.getInvestmentsInPropertyPlantAndEquipment());
    getCell(sheet, RowConstants.PAYMENTS_FOR_ACQUISITIONS, col).setCellValue(source.getAcquisitionsNet());
    getCell(sheet, RowConstants.PURCHASE_OF_SECURITIES, col).setCellValue(source.getPurchasesOfInvestments());
    getCell(sheet, RowConstants.SALES_AND_MATURITIES_OF_SECURITIES, col).setCellValue(source.getSalesMaturitiesOfInvestments());
    getCell(sheet, RowConstants.OTHER_INVESTING_ACTIVITIES, col).setCellValue(source.getOtherInvestingActivites());
    getCell(sheet, RowConstants.CASH_FROM_INVESTING, col).setCellValue(source.getNetCashUsedForInvestingActivites());

    // Cash from Financing Activities
    getCell(sheet, RowConstants.DEBT_REPAYMENT, col).setCellValue(source.getDebtRepayment());
    getCell(sheet, RowConstants.DIVIDENDS_PAID, col).setCellValue(source.getDividendsPaid());
    getCell(sheet, RowConstants.COMMON_STOCK_ISSUED, col).setCellValue(source.getCommonStockIssued());
    getCell(sheet, RowConstants.COMMON_STOCK_REPURCHASED, col).setCellValue(source.getCommonStockRepurchased());
    getCell(sheet, RowConstants.OTHER_FINANCING_ACTIVITIES, col).setCellValue(source.getOtherFinancingActivites());
    getCell(sheet, RowConstants.CASH_FROM_FINANCING_ACTIVITIES, col).setCellValue(source.getNetCashUsedProvidedByFinancingActivities());

    // Effect of Forex Changes on Cash
    getCell(sheet, RowConstants.EFFECT_ON_FOREX, col).setCellValue(source.getEffectOfForexChangesOnCash());

    // Net Change in Cash
    getCell(sheet, RowConstants.NET_CHANGE_IN_CASH, col).setCellValue(source.getNetChangeInCash());

    // Free Cash Flow
    getCell(sheet, RowConstants.OPERATING_CASH_FLOW, col).setCellValue(source.getOperatingCashFlow());
    getCell(sheet, RowConstants.CAPEX, col).setCellValue(source.getCapitalExpenditure());
    getCell(sheet, RowConstants.FREE_CASH_FLOW, col).setCellValue(source.getFreeCashFlow());

    // Supplemental Items
    getCell(sheet, RowConstants.CASH_AT_BEGINNING_OF_PERIOD, col).setCellValue(source.getCashAtBeginningOfPeriod());
    getCell(sheet, RowConstants.CASH_AT_END_OF_PERIOD, col).setCellValue(source.getCashAtEndOfPeriod());
  }
}
