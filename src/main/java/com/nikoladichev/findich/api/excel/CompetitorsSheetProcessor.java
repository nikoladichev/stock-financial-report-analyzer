package com.nikoladichev.findich.api.excel;

import static com.nikoladichev.findich.api.excel.SheetUtils.setCellValue;

import com.nikoladichev.findich.api.integration.scraper.response.Analysis;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.nikoladichev.findich.api.model.common.Constants;
import com.nikoladichev.findich.api.model.fundamentals.CompanyPeersComparisonData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompetitorsSheetProcessor {

  public static final BigInteger ONE_MILLION = BigInteger.valueOf(1000000);

  private static class ColConstants {
    private static final int COMPANY_NAME = 1;
    private static final int SYMBOL = 2;
    private static final int SHARE_PRICE = 3;
    private static final int SHARES_OUTSTANDING = 4;
    private static final int EQUITY_VALUE = 5;
    private static final int CASH_AND_EQUIVALENTS = 6;
    private static final int NET_DEBT = 7;
    private static final int ENTERPRISE_VALUE = 9;

    private static final int REVENUE = 10;
    private static final int EBITDA = 11;
    private static final int NET_INCOME = 12;
  }

  private Sheet getSheet(Workbook workbook) {
    return workbook.getSheet("COMPETITORS");
  }

  public void process(Workbook workbook, List<CompanyPeersComparisonData> source) {
    var sheet = getSheet(workbook);

    processEarningEstimates(source, sheet);
  }

  private void processEarningEstimates(
      List<CompanyPeersComparisonData> comparisonData, Sheet sheet) {
    int rowIdx = 10;
    for (int i = 0; i < comparisonData.size(); i++) {
      var data = comparisonData.get(i);

      // Values
      setCellValue(sheet, rowIdx, ColConstants.COMPANY_NAME, data.getCompanyName());
      setCellValue(sheet, rowIdx, ColConstants.SYMBOL, data.getSymbol());
      setCellValue(sheet, rowIdx, ColConstants.SHARE_PRICE, data.getSharePrice());
      setCellValue(sheet, rowIdx, ColConstants.SHARES_OUTSTANDING, data.getSharesOutstanding().divide(ONE_MILLION));
      setCellValue(sheet, rowIdx, ColConstants.EQUITY_VALUE, data.getMarketCap().divide(ONE_MILLION));
      setCellValue(sheet, rowIdx, ColConstants.CASH_AND_EQUIVALENTS, data.getCashAndEquivalents().divide(ONE_MILLION));
      setCellValue(sheet, rowIdx, ColConstants.NET_DEBT, data.getNetDebt().divide(ONE_MILLION));
      // setCellValue(sheet, rowIdx, ColConstants.ENTERPRISE_VALUE, data.getEnterpriseValue());
      setCellValue(sheet, rowIdx, ColConstants.REVENUE, data.getRevenue().divide(ONE_MILLION));
      setCellValue(sheet, rowIdx, ColConstants.EBITDA, data.getEbitda().divide(ONE_MILLION));
      setCellValue(sheet, rowIdx, ColConstants.NET_INCOME, data.getNetIncome().divide(ONE_MILLION));

      if (i == 0) {
        // skip one extra line
        rowIdx += 2;
      } else {
        rowIdx += 1;
      }
    }
  }
}
