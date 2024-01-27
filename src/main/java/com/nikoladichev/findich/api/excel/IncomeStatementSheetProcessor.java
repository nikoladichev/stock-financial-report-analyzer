package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IncomeStatementSheetProcessor extends SheetProcessor<IncomeStatement> {

  private static class RowConstants {
    private static final int FISCAL_YEAR = 1;
    private static final int FILLING_DATE = 2;
    private static final int REVENUE = 3;
    private static final int COST_OF_REVENUE = 5;
    private static final int GROSS_PROFIT = 6;
    private static final int GROSS_PROFIT_RATIO = 7;
    private static final int RESEARCH_AND_DEVELOPMENT = 9;
    private static final int GENERAL_AND_ADMINISTRATIVE = 10;
    private static final int SELLING_AND_MARKETING = 11;
    private static final int OTHER_OPERATING_EXPENSES = 12;
    private static final int OPERATING_EXPENSES_TOTAL = 13;
    private static final int OPERATING_INCOME = 15;
    private static final int OPERATING_INCOME_RATIO = 16;
    private static final int INTEREST_EXPENSE = 18;
    private static final int INTEREST_INCOME = 19;
    private static final int NET_INTEREST_EXPENSE = 20;
    private static final int OTHER_INCOME_EXPENSE = 22;
    private static final int EARNINGS_BEFORE_TAX = 23;
    private static final int EARNINGS_BEFORE_TAX_RATIO = 24;
    private static final int INCOME_TAX_EXPENSE = 26;
    private static final int INCOME_LOSS_NON_CONTROLLING = 27;
    private static final int NET_INCOME = 28;
    private static final int NET_INCOME_RATIO = 29;
    private static final int DEPRECIATION_AND_AMORTIZATION = 31;
    private static final int EPS = 34;
    private static final int WEIGHTED_AVERAGE_SHARES_OUTSTANDING = 35;
    private static final int DILUTED_EPS = 37;
    private static final int DILUTED_WEIGHTED_AVERAGE_SHARES_OUTSTANDING = 38;
    private static final int EBITDA = 41;
    private static final int EBIT = 44;
  }

  @Override
  protected Sheet getSheet(Workbook workbook) {
    return workbook.getSheet("IS");
  }

  @Override
  protected void processData(IncomeStatement source, Sheet sheet, int col) {
    // Header
    getCell(sheet, RowConstants.FISCAL_YEAR, col)
        .setCellValue(source.getPeriod() + "_" + source.getCalendarYear());
    getCell(sheet, RowConstants.FILLING_DATE, col).setCellValue(source.getDate());

    // Revenue & Gross Profit
    getCell(sheet, RowConstants.REVENUE, col).setCellValue(source.getRevenue());
    getCell(sheet, RowConstants.COST_OF_REVENUE, col).setCellValue(source.getCostOfRevenue());
    getCell(sheet, RowConstants.GROSS_PROFIT, col).setCellValue(source.getGrossProfit());
    getCell(sheet, RowConstants.GROSS_PROFIT_RATIO, col).setCellValue(source.getGrossProfitRatio());

    // Operating expenses
    getCell(sheet, RowConstants.RESEARCH_AND_DEVELOPMENT, col)
        .setCellValue(source.getResearchAndDevelopmentExpenses());
    getCell(sheet, RowConstants.GENERAL_AND_ADMINISTRATIVE, col)
        .setCellValue(source.getGeneralAndAdministrativeExpenses());
    getCell(sheet, RowConstants.SELLING_AND_MARKETING, col)
        .setCellValue(source.getSellingAndMarketingExpenses());
    getCell(sheet, RowConstants.OTHER_OPERATING_EXPENSES, col)
        .setCellValue(source.getCalculatedOtherExpenses());
    getCell(sheet, RowConstants.OPERATING_EXPENSES_TOTAL, col)
        .setCellValue(source.getCalculatedOperatingExpenses());

    // Operating Income
    getCell(sheet, RowConstants.OPERATING_INCOME, col).setCellValue(source.getOperatingIncome());
    getCell(sheet, RowConstants.OPERATING_INCOME_RATIO, col)
        .setCellValue(source.getOperatingIncomeRatio());

    // Operating Income
    getCell(sheet, RowConstants.INTEREST_EXPENSE, col).setCellValue(source.getInterestExpense());
    getCell(sheet, RowConstants.INTEREST_INCOME, col).setCellValue(source.getInterestIncome());
    getCell(sheet, RowConstants.NET_INTEREST_EXPENSE, col)
        .setCellValue(source.getCalculatedNetInterest());

    // Other Income/Expense
    getCell(sheet, RowConstants.OTHER_INCOME_EXPENSE, col)
        .setCellValue(source.getCalculatedNetInterest());

    // Earnings Before Tax (EBT) (a.k.a Income Before Tax)
    getCell(sheet, RowConstants.EARNINGS_BEFORE_TAX, col).setCellValue(source.getIncomeBeforeTax());
    getCell(sheet, RowConstants.EARNINGS_BEFORE_TAX_RATIO, col)
        .setCellValue(source.getIncomeBeforeTaxRatio());

    // Income Tax Expense
    getCell(sheet, RowConstants.INCOME_TAX_EXPENSE, col).setCellValue(source.getIncomeTaxExpense());

    // Income(Loss) Attributable to Non-Controlling Interest
    getCell(sheet, RowConstants.INCOME_LOSS_NON_CONTROLLING, col)
        .setCellValue(source.getCalculatedIncomeNonControlling());

    // Net Income
    getCell(sheet, RowConstants.NET_INCOME, col).setCellValue(source.getNetIncome());
    getCell(sheet, RowConstants.NET_INCOME_RATIO, col).setCellValue(source.getNetIncomeRatio());

    // Depreciation and Amortization
    getCell(sheet, RowConstants.DEPRECIATION_AND_AMORTIZATION, col)
        .setCellValue(source.getDepreciationAndAmortization());

    // Per share items
    getCell(sheet, RowConstants.EPS, col).setCellValue(source.getEps());
    getCell(sheet, RowConstants.WEIGHTED_AVERAGE_SHARES_OUTSTANDING, col)
        .setCellValue(source.getWeightedAverageShsOut());
    getCell(sheet, RowConstants.DILUTED_EPS, col).setCellValue(source.getEpsdiluted());
    getCell(sheet, RowConstants.DILUTED_WEIGHTED_AVERAGE_SHARES_OUTSTANDING, col)
        .setCellValue(source.getWeightedAverageShsOutDil());

    // EBIT and EBITDA
    getCell(sheet, RowConstants.EBITDA, col).setCellValue(source.getCalculatedEbitda());
    getCell(sheet, RowConstants.EBIT, col)
        .setCellValue(source.getCalculatedEbitda() + source.getDepreciationAndAmortization());
  }
}
