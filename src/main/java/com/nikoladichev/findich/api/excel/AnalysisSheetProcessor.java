package com.nikoladichev.findich.api.excel;

import com.nikoladichev.findich.api.integration.yahoofinance.response.Analysis;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import static com.nikoladichev.findich.api.excel.SheetUtils.setCellValue;

@Slf4j
@Component
public class AnalysisSheetProcessor {

  public static final DateTimeFormatter yfAnalysisDateFormatter =
      DateTimeFormatter.ofPattern("M/d/yyyy");

  private static class RowConstants {
    private static final int EARNINGS_ESTIMATE_HEADER = 4;
    private static final int EARNINGS_NO_OF_ANALYSTS = 5;
    private static final int EARNINGS_AVG_ESTIMATE = 6;
    private static final int EARNINGS_LOW_ESTIMATE = 7;
    private static final int EARNINGS_HIGH_ESTIMATE = 8;
    private static final int EARNINGS_YEAR_AGO_EPS = 9;

    private static final int REVENUE_ESTIMATES_HEADER = 12;
    private static final int REVENUE_NO_OF_ANALYSTS = 13;
    private static final int REVENUE_AVG_ESTIMATE = 14;
    private static final int REVENUE_LOW_ESTIMATE = 15;
    private static final int REVENUE_HIGH_ESTIMATE = 16;
    private static final int REVENUE_YEAR_AGO_SALES = 17;
    private static final int REVENUE_SALES_GROWTH_YEAR_OVER_ESTIMATE = 18;

    public static final int GROWTH_ESTIMATES_HEADER = 20;
    public static final int GROWTH_ESTIMATES_CURRENT_QUARTER = 21;
    public static final int GROWTH_ESTIMATES_NEXT_QUARTER = 22;
    public static final int GROWTH_ESTIMATES_CURRENT_YEAR = 23;
    public static final int GROWTH_ESTIMATES_NEXT_YEAR = 24;
    public static final int GROWTH_ESTIMATES_NEXT_5_YEARS_PER_ANNUM = 25;
    public static final int GROWTH_ESTIMATES_PAST_5_YEARS_PER_ANNUM = 26;

    public static final int EPS_TREND_HEADER = 29;
    public static final int EPS_TREND_CURRENT_ESTIMATE = 30;
    public static final int EPS_TREND_7_DAYS_AGO = 31;
    public static final int EPS_TREND_30_DAYS_AGO = 32;
    public static final int EPS_TREND_60_DAYS_AGO = 33;
    public static final int EPS_TREND_90_DAYS_AGO = 34;

    public static final int EARNINGS_HISTORY_HEADER = 36;
    public static final int EARNINGS_HISTORY_EPS_ESTIMATED = 37;
    public static final int EARNINGS_HISTORY_EPS_ACTUAL = 38;
    public static final int EARNINGS_HISTORY_DIFFERENCE = 39;
    public static final int EARNINGS_HISTORY_SURPRISE_PERCENT = 40;

    public static final int EPS_REVISIONS_HEADER = 43;
    public static final int EPS_REVISIONS_UP_LAST_7_DAYS = 44;
    public static final int EPS_REVISIONS_UP_LAST_30_DAYS = 45;
    public static final int EPS_REVISIONS_DOWN_LAST_7_DAYS = 46;
    public static final int EPS_REVISIONS_DOWN_LAST_30_DAYS = 47;
  }

  private static class ColConstants {
    private static final int CURRENT_QUARTER_SYMBOL = 2;
    private static final int CURRENT_QUARTER_YEAR = 3;
    private static final int NEXT_QUARTER_SYMBOL = 4;
    private static final int NEXT_QUARTER_YEAR = 5;
    private static final int CURRENT_YEAR = 6;
    private static final int NEXT_YEAR = 7;
  }

  private Sheet getSheet(Workbook workbook) {
    return workbook.getSheet("RESEARCH");
  }

  public void process(Workbook workbook, Analysis source) {
    var sheet = getSheet(workbook);

    processEarningEstimates(source, sheet);
    processRevenueEstimates(source, sheet);
    processGrowthEstimates(source, sheet);
    processEpsTrend(source, sheet);
    processEarningsHistory(source, sheet);
    processEpsRevisions(source, sheet);
  }

  private void processEarningEstimates(Analysis source, Sheet sheet) {
    var earningsEstimateMap = source.getEarningsEstimate();
    for (String key : earningsEstimateMap.keySet()) {
      var period = splitPeriod(key);
      var isQuarterPeriod = period.getCellPeriodColPosition() != null;

      processHeaders(sheet, RowConstants.EARNINGS_ESTIMATE_HEADER, period, isQuarterPeriod);

      var earningsEstimate = earningsEstimateMap.get(key);
      var colPosition =
          isQuarterPeriod ? period.getCellPeriodColPosition() : period.getCellYearColPosition();

      // Values
      setCellValue(
          sheet,
          RowConstants.EARNINGS_NO_OF_ANALYSTS,
          colPosition,
          earningsEstimate.getNoOfAnlysts());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_AVG_ESTIMATE,
          colPosition,
          earningsEstimate.getAvgEstimate());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_LOW_ESTIMATE,
          colPosition,
          earningsEstimate.getLowEstimate());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_HIGH_ESTIMATE,
          colPosition,
          earningsEstimate.getHighEstimate());
      setCellValue(
          sheet, RowConstants.EARNINGS_YEAR_AGO_EPS, colPosition, earningsEstimate.getYearAgoEps());
    }
  }

  private void processRevenueEstimates(Analysis source, Sheet sheet) {
    var revenueEstimateMap = source.getRevenueEstimate();
    for (String key : revenueEstimateMap.keySet()) {
      var period = splitPeriod(key);
      var isQuarterPeriod = period.getCellPeriodColPosition() != null;

      // Header
      processHeaders(sheet, RowConstants.REVENUE_ESTIMATES_HEADER, period, isQuarterPeriod);

      var revenueEstimate = revenueEstimateMap.get(key);
      var colPosition =
          isQuarterPeriod ? period.getCellPeriodColPosition() : period.getCellYearColPosition();

      // Values
      var val = revenueEstimate.getNoOfAnlysts();
      var rowPosition = RowConstants.REVENUE_NO_OF_ANALYSTS;
      setCellValue(sheet, rowPosition, colPosition, val);
      setCellValue(
          sheet, RowConstants.REVENUE_AVG_ESTIMATE, colPosition, revenueEstimate.getAvgEstimate());
      setCellValue(
          sheet, RowConstants.REVENUE_LOW_ESTIMATE, colPosition, revenueEstimate.getLowEstimate());
      setCellValue(
          sheet,
          RowConstants.REVENUE_HIGH_ESTIMATE,
          colPosition,
          revenueEstimate.getHighEstimate());
      setCellValue(
          sheet,
          RowConstants.REVENUE_YEAR_AGO_SALES,
          colPosition,
          revenueEstimate.getYearAgoSales());
      setCellValue(
          sheet,
          RowConstants.REVENUE_SALES_GROWTH_YEAR_OVER_ESTIMATE,
          colPosition,
          revenueEstimate.getSalesGrowthYearOverEst());
    }
  }

  private void processGrowthEstimates(Analysis source, Sheet sheet) {
    var growthEstimateMap = source.getGrowthEstimates();
    var keys = new LinkedList<>(List.of("s&p_500", "industry", "sectors"));
    keys.addFirst(
        growthEstimateMap.keySet().stream()
            .filter(Predicate.not(keys::contains))
            .findFirst()
            .orElse(""));
    var positions = new int[] {2, 4, 6, 7};
    int colIdx = 0;

    for (String key : keys) {
      int colPosition = positions[colIdx];
      var earningsHistory = growthEstimateMap.get(key);
      // Header
      setCellValue(sheet, RowConstants.GROWTH_ESTIMATES_HEADER, colPosition, key);

      // Values
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_CURRENT_QUARTER,
          colPosition,
          earningsHistory.getCurrentQtr());
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_NEXT_QUARTER,
          colPosition,
          earningsHistory.getNextQtr());
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_CURRENT_YEAR,
          colPosition,
          earningsHistory.getCurrentYear());
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_NEXT_YEAR,
          colPosition,
          earningsHistory.getNextYear());
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_NEXT_5_YEARS_PER_ANNUM,
          colPosition,
          earningsHistory.getNext5YearsPerAnnum());
      setCellValue(
          sheet,
          RowConstants.GROWTH_ESTIMATES_PAST_5_YEARS_PER_ANNUM,
          colPosition,
          earningsHistory.getPast5YearsPerAnnum());

      colIdx++;
    }
  }

  private void processEpsTrend(Analysis source, Sheet sheet) {
    var epsTrendMap = source.getEpsTrend();
    for (String key : epsTrendMap.keySet()) {
      var period = splitPeriod(key);
      var isQuarterPeriod = period.getCellPeriodColPosition() != null;

      // Header
      processHeaders(sheet, RowConstants.EPS_TREND_HEADER, period, isQuarterPeriod);

      var epsTrend = epsTrendMap.get(key);
      var colPosition =
          isQuarterPeriod ? period.getCellPeriodColPosition() : period.getCellYearColPosition();

      // Values
      setCellValue(
          sheet,
          RowConstants.EPS_TREND_CURRENT_ESTIMATE,
          colPosition,
          epsTrend.getCurrentEstimate());
      setCellValue(
          sheet, RowConstants.EPS_TREND_7_DAYS_AGO, colPosition, epsTrend.getSevenDaysAgo());
      setCellValue(
          sheet, RowConstants.EPS_TREND_30_DAYS_AGO, colPosition, epsTrend.getThirtyDaysAgo());
      setCellValue(
          sheet, RowConstants.EPS_TREND_60_DAYS_AGO, colPosition, epsTrend.getSixtyDaysAgo());
      setCellValue(
          sheet, RowConstants.EPS_TREND_90_DAYS_AGO, colPosition, epsTrend.getNinetyDaysAgo());
    }
  }

  private void processEarningsHistory(Analysis source, Sheet sheet) {
    var earningsHistoryMap =
        source.getEarningsHistory().entrySet().stream()
            .collect(
                Collectors.toMap(
                    entry -> LocalDate.parse(entry.getKey(), yfAnalysisDateFormatter),
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue,
                    TreeMap::new));

    var positions = new int[] {2, 4, 6, 7};
    int colIdx = 0;

    for (LocalDate key : earningsHistoryMap.keySet()) {
      var colPosition = positions[colIdx];
      var earningsHistory = earningsHistoryMap.get(key);
      // Header
      setCellValue(sheet, RowConstants.EARNINGS_HISTORY_HEADER, colPosition, key);

      // Values
      setCellValue(
          sheet,
          RowConstants.EARNINGS_HISTORY_EPS_ESTIMATED,
          colPosition,
          earningsHistory.getEpsEst());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_HISTORY_EPS_ACTUAL,
          colPosition,
          earningsHistory.getEpsActual());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_HISTORY_DIFFERENCE,
          colPosition,
          earningsHistory.getDifference());
      setCellValue(
          sheet,
          RowConstants.EARNINGS_HISTORY_SURPRISE_PERCENT,
          colPosition,
          earningsHistory.getSurprisePercent());

      colIdx++;
    }
  }

  private void processEpsRevisions(Analysis source, Sheet sheet) {
    var epsRevisionMap = source.getEpsRevisions();
    for (String key : epsRevisionMap.keySet()) {
      var period = splitPeriod(key);
      var isQuarterPeriod = period.getCellPeriodColPosition() != null;

      // Header
      processHeaders(sheet, RowConstants.EPS_REVISIONS_HEADER, period, isQuarterPeriod);

      var epsRevision = epsRevisionMap.get(key);
      var colPosition =
          isQuarterPeriod ? period.getCellPeriodColPosition() : period.getCellYearColPosition();

      // Values
      setCellValue(
          sheet,
          RowConstants.EPS_REVISIONS_UP_LAST_7_DAYS,
          colPosition,
          epsRevision.getUpLast7Days());
      setCellValue(
          sheet,
          RowConstants.EPS_REVISIONS_UP_LAST_30_DAYS,
          colPosition,
          epsRevision.getUpLast30Days());
      setCellValue(
          sheet,
          RowConstants.EPS_REVISIONS_DOWN_LAST_7_DAYS,
          colPosition,
          epsRevision.getDownLast7Days());
      setCellValue(
          sheet,
          RowConstants.EPS_REVISIONS_DOWN_LAST_30_DAYS,
          colPosition,
          epsRevision.getDownLast30Days());
    }
  }

  private PeriodCellInfo splitPeriod(String period) {
    var yearStartIdx = period.lastIndexOf("_");
    var year = period.substring(yearStartIdx + 1);
    var periodCellInfo = new PeriodCellInfo();

    if (period.contains("current_qtr") || period.contains("next_qtr")) {
      var monthIdx = period.substring(0, yearStartIdx).lastIndexOf("_");
      var month = period.substring(monthIdx + 1, yearStartIdx);

      if (period.contains("current_qtr")) {
        periodCellInfo.setCellPeriodColPosition(ColConstants.CURRENT_QUARTER_SYMBOL);
        periodCellInfo.setCellYearColPosition(ColConstants.CURRENT_QUARTER_YEAR);
      } else {
        periodCellInfo.setCellPeriodColPosition(ColConstants.NEXT_QUARTER_SYMBOL);
        periodCellInfo.setCellYearColPosition(ColConstants.NEXT_QUARTER_YEAR);
      }

      if ("Mar".equalsIgnoreCase(month)) {
        periodCellInfo.setCellPeriod("Q1");
      } else if ("Jun".equalsIgnoreCase(month)) {
        periodCellInfo.setCellPeriod("Q2");
      } else if ("Sep".equalsIgnoreCase(month)) {
        periodCellInfo.setCellPeriod("Q3");
      } else if ("Dec".equalsIgnoreCase(month)) {
        periodCellInfo.setCellPeriod("Q4");
      }
    } else {
      periodCellInfo.setCellYearColPosition(
          period.contains("current_year") ? ColConstants.CURRENT_YEAR : ColConstants.NEXT_YEAR);
    }

    periodCellInfo.setYear(Integer.parseInt(year));

    return periodCellInfo;
  }

  private static void processHeaders(
      Sheet sheet, int earningsEstimateHeader, PeriodCellInfo period, boolean isQuarterPeriod) {
    // Header
    setCellValue(sheet, earningsEstimateHeader, period.getCellYearColPosition(), period.getYear());

    if (isQuarterPeriod) {
      setCellValue(
          sheet, earningsEstimateHeader, period.getCellPeriodColPosition(), period.getCellPeriod());
    }
  }

  @Data
  private static class PeriodCellInfo {
    private Integer cellPeriodColPosition;
    private int cellYearColPosition;
    private String cellPeriod;
    private int year;
  }
}
