package com.nikoladichev.findich.api.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class SheetUtils {

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, LocalDate value) {
    var cell = SheetUtils.getCell(sheet, rowPosition, colPosition);

    if (value != null) {
      cell.setCellValue(value);
    } else {
      cell.setCellValue("-");
    }
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, String value) {
    var cell = SheetUtils.getCell(sheet, rowPosition, colPosition);

    if (value != null) {
      cell.setCellValue(value);
    } else {
      cell.setCellValue("-");
    }
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, BigDecimal value) {
    setCellValue(sheet, rowPosition, colPosition, value.doubleValue());
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, Double value) {
    var cell = SheetUtils.getCell(sheet, rowPosition, colPosition);

    if (value != null) {
      cell.setCellValue(value);
    } else {
      cell.setCellValue("-");
    }
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, BigInteger value) {
    setCellValue(sheet, rowPosition, colPosition, value.longValue());
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, Long value) {
    var cell = SheetUtils.getCell(sheet, rowPosition, colPosition);

    if (value != null) {
      cell.setCellValue(value);
    } else {
      cell.setCellValue("-");
    }
  }

  public static void setCellValue(Sheet sheet, int rowPosition, int colPosition, Integer value) {
    var cell = SheetUtils.getCell(sheet, rowPosition, colPosition);

    if (value != null) {
      cell.setCellValue(value);
    } else {
      cell.setCellValue("-");
    }
  }

  public static Cell getCell(Sheet sheet, int row, int col) {
    return sheet.getRow(row).getCell(col);
  }
}
