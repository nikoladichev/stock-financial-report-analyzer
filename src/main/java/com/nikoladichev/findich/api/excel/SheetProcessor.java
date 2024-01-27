package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.model.fundamentals.statements.FinancialStatement;
import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

import static com.nikoladichev.findich.api.model.common.Comparators.statementDateComparator;
import static com.nikoladichev.findich.api.model.common.Constants.LAST_10_YEARS_PLUS_LTM;

public abstract class SheetProcessor<T extends FinancialStatement> {

  private static final int COL_OFFSET = 2;

  protected abstract Sheet getSheet(Workbook workbook);

  protected abstract void processData(T source, Sheet sheet, int col);

  public void process(Workbook workbook, List<T> data) {
    var sheet = getSheet(workbook);

    var sortedData = data.stream().sorted(statementDateComparator).toList();
    var offset =
        sortedData.size() < LAST_10_YEARS_PLUS_LTM ? LAST_10_YEARS_PLUS_LTM - sortedData.size() : 0;

    // take only the last 10 fillings
    if (sortedData.size() > LAST_10_YEARS_PLUS_LTM) {
      sortedData =
          sortedData.subList(
              Math.max(sortedData.size() - LAST_10_YEARS_PLUS_LTM, 0), sortedData.size());
    }

    for (int col = 0; col < sortedData.size(); col++) {
      processData(sortedData.get(col), sheet, col + offset);
    }
  }

  protected static Cell getCell(Sheet sheet, int row, int col) {
    return sheet.getRow(row).getCell(COL_OFFSET + col);
  }
}
