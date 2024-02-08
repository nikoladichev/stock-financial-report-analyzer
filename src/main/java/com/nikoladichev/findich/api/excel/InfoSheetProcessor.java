package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.model.common.DateFormatter;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.fundamentals.Treasury;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class InfoSheetProcessor {

  private static class RowConstants {

    // Company Info
    private static final int SYMBOL = 2;
    private static final int COMPANY_NAME = 3;
    private static final int COUNTRY = 4;
    private static final int SECTOR = 5;
    private static final int INDUSTRY = 6;
    private static final int EXCHANGE_SHORT_NAME = 7;
    private static final int IPO_DATE = 8;
    private static final int FULL_TIME_EMPLOYEES = 9;
    private static final int WEBSITE = 10;
    private static final int ANALYSIS_DATE = 11;

    // Description
    private static final int DESCRIPTION = 2;

    // Assumptions

    private static final int PRICE = 14;
    private static final int MARKET_CAP = 15;
    private static final int BETA = 16;
    private static final int SHARES_OUTSTANDING = 17;
    private static final int PRICE_EARNINGS = 18;
    private static final int RISK_FREE_RATE = 19;
  }

  private static class ColConstants {
    private static final int COMPANY_INFO = 2;
    private static final int DESCRIPTION = 3;
    private static final int MODEL_ASSUMPTIONS = 2;
  }

  public void process(CompanyProfile companyProfile, Treasury treasury, Workbook workbook) {
    var sheet = workbook.getSheet("INFO");
    processData(companyProfile, treasury, sheet);
  }

  private void processData(CompanyProfile info, Treasury treasury, Sheet sheet) {
    // Info Section
    getCell(sheet, RowConstants.SYMBOL, ColConstants.COMPANY_INFO).setCellValue(info.getSymbol());
    getCell(sheet, RowConstants.COMPANY_NAME, ColConstants.COMPANY_INFO)
        .setCellValue(info.getCompanyName());
    getCell(sheet, RowConstants.COUNTRY, ColConstants.COMPANY_INFO)
            .setCellValue(info.getCountry());
    getCell(sheet, RowConstants.SECTOR, ColConstants.COMPANY_INFO).setCellValue(info.getSector());
    getCell(sheet, RowConstants.INDUSTRY, ColConstants.COMPANY_INFO)
        .setCellValue(info.getIndustry());
    getCell(sheet, RowConstants.EXCHANGE_SHORT_NAME, ColConstants.COMPANY_INFO)
        .setCellValue(info.getExchangeShortName());
    getCell(sheet, RowConstants.IPO_DATE, ColConstants.COMPANY_INFO)
        .setCellValue(info.getIpoDate());
    getCell(sheet, RowConstants.FULL_TIME_EMPLOYEES, ColConstants.COMPANY_INFO)
        .setCellValue(info.getFullTimeEmployees());
    getCell(sheet, RowConstants.WEBSITE, ColConstants.COMPANY_INFO)
        .setCellValue(info.getWebsite());
    getCell(sheet, RowConstants.ANALYSIS_DATE, ColConstants.COMPANY_INFO)
        .setCellValue(DateFormatter.format(LocalDate.now()));

    // Description
    getCell(sheet, RowConstants.DESCRIPTION, ColConstants.DESCRIPTION).setCellValue(info.getDescription());

    // Assumptions
    getCell(sheet, RowConstants.PRICE, ColConstants.MODEL_ASSUMPTIONS)
            .setCellValue(info.getPrice());
    getCell(sheet, RowConstants.MARKET_CAP, ColConstants.MODEL_ASSUMPTIONS)
            .setCellValue(info.getMktCap().doubleValue());
    getCell(sheet, RowConstants.BETA, ColConstants.MODEL_ASSUMPTIONS)
            .setCellValue(info.getBeta());
    getCell(sheet, RowConstants.RISK_FREE_RATE, ColConstants.MODEL_ASSUMPTIONS)
            .setCellValue(treasury.getYear10());
  }

  protected static Cell getCell(Sheet sheet, int row, int col) {
    return sheet.getRow(row).getCell(col);
  }
}
