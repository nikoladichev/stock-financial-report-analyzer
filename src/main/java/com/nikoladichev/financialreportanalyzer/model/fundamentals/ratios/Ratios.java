package com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nikoladichev.financialreportanalyzer.model.common.Constants;
import com.nikoladichev.financialreportanalyzer.model.common.DateFormatter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ratios data based on the financial statements of a company")
public class Ratios {

  @Schema(title = "The symbol of the company")
  private String symbol;

  @Schema(title = "The date of the financial data")
  private String date;

  @Schema(title = "The period of the financial data")
  private String period;

  /**
   * The current ratio measures a company's ability to cover its short-term liabilities with its
   * short-term assets. Formula: Current Ratio = Current Assets / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/currentratio.asp">Investopedia - Current
   *     Ratio</a>
   */
  @Schema(title = "The current ratio", example = "0.8793560286267226")
  private BigDecimal currentRatio;

  /**
   * The quick ratio (acid-test ratio) measures a company's ability to cover its short-term
   * liabilities with its most liquid assets. Formula: Quick Ratio = (Cash + Cash Equivalents +
   * Marketable Securities + Accounts Receivable) / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/q/quickratio.asp">Investopedia - Quick
   *     Ratio</a>
   */
  @Schema(title = "The quick ratio", example = "0.7094075930952969")
  private BigDecimal quickRatio;

  /**
   * The cash ratio represents the proportion of a company's current assets held in cash or cash
   * equivalents. Formula: Cash Ratio = Cash and Cash Equivalents / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashratio.asp">Investopedia - Cash Ratio</a>
   */
  @Schema(title = "The cash ratio", example = "0.15356340351469652")
  private BigDecimal cashRatio;

  /**
   * The days of sales outstanding (DSO) measures the average number of days it takes for a company
   * to collect payment after a sale is made. Formula: DSO = (Accounts Receivable / Total Credit
   * Sales) * Number of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/dayssalesout.asp">Investopedia - Days Sales
   *     Outstanding (DSO)</a>
   */
  @Schema(title = "The days of sales outstanding (DSO)", example = "56.400204905560855")
  private BigDecimal daysOfSalesOutstanding;

  /**
   * The days of inventory outstanding (DIO) measures the average number of days it takes for a
   * company to sell its inventory. Formula: DIO = (Average Inventory / Cost of Goods Sold) * Number
   * of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofinventoryout.asp">Investopedia - Days
   *     of Inventory Outstanding (DIO)</a>
   */
  @Schema(title = "The days of inventory outstanding (DIO)", example = "8.07569806661716")
  private BigDecimal daysOfInventoryOutstanding;

  /**
   * The operating cycle measures the average time it takes for a company to convert its inventory
   * into cash. Formula: Operating Cycle = DIO + DSO
   */
  @Schema(title = "The operating cycle", example = "64.47590297217802")
  private BigDecimal operatingCycle;

  /**
   * The days of payables outstanding (DPO) measures the average number of days it takes for a
   * company to pay its suppliers. Formula: DPO = (Accounts Payable / Total Credit Purchases) *
   * Number of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofpayableout.asp">Investopedia - Days of
   *     Payables Outstanding (DPO)</a>
   */
  @Schema(title = "The days of payables outstanding (DPO)", example = "104.6852773031054")
  private BigDecimal daysOfPayablesOutstanding;

  /**
   * The cash conversion cycle (CCC) measures the time it takes for a company to convert its
   * resources into cash flows. Formula: CCC = Operating Cycle - DPO
   */
  @Schema(title = "The cash conversion cycle (CCC)", example = "-40.209374330927375")
  private BigDecimal cashConversionCycle;

  /**
   * The gross profit margin represents the percentage of revenue that exceeds the cost of goods
   * sold. Formula: Gross Profit Margin = (Revenue - Cost of Goods Sold) / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/g/gross_profit_margin.asp">Investopedia -
   *     Gross Profit Margin</a>
   */
  @Schema(title = "The gross profit margin", example = "0.43309630561360085")
  private BigDecimal grossProfitMargin;

  /**
   * The operating profit margin indicates the percentage of revenue remaining after deducting
   * operating expenses. Formula: Operating Profit Margin = Operating Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/o/operating_margin.asp">Investopedia -
   *     Operating Profit Margin</a>
   */
  @Schema(title = "The operating profit margin", example = "0.30288744395528594")
  private BigDecimal operatingProfitMargin;

  /**
   * The pretax profit margin represents the percentage of revenue remaining after deducting all
   * operating expenses and before income tax. Formula: Pretax Profit Margin = Pre-tax Income /
   * Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/p/pretax-profit-margin.asp">Investopedia -
   *     Pretax Profit Margin</a>
   */
  @Schema(title = "The pretax profit margin", example = "0.30204043334482966")
  private BigDecimal pretaxProfitMargin;

  /**
   * The net profit margin shows the percentage of revenue that represents a company's net income.
   * Formula: Net Profit Margin = Net Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/n/net_profit_margin.asp">Investopedia - Net
   *     Profit Margin</a>
   */
  @Schema(title = "The net profit margin", example = "0.2530964070519973")
  private BigDecimal netProfitMargin;

  /**
   * The effective tax rate represents the percentage of pre-tax income that a company pays in
   * taxes. Formula: Effective Tax Rate = Income Tax Expense / Pre-tax Income
   *
   * @see <a href="https://www.investopedia.com/terms/e/effectivetaxrate.asp">Investopedia -
   *     Effective Tax Rate</a>
   */
  @Schema(title = "The effective tax rate", example = "0.16204461684424407")
  private BigDecimal effectiveTaxRate;

  /**
   * The return on assets (ROA) measures how effectively a company uses its assets to generate
   * profit. Formula: Return on Assets (ROA) = Net Income / Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonassets.asp">Investopedia - Return on
   *     Assets (ROA)</a>
   */
  @Schema(title = "The return on assets (ROA)", example = "0.2829244092925685")
  private BigDecimal returnOnAssets;

  /**
   * The return on equity (ROE) indicates the return generated on shareholders' equity investment.
   * Formula: Return on Equity (ROE) = Net Income / Shareholders' Equity
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonequity.asp">Investopedia - Return on
   *     Equity (ROE)</a>
   */
  @Schema(title = "The return on equity (ROE)", example = "1.9695887275023682")
  private BigDecimal returnOnEquity;

  /**
   * The return on capital employed (ROCE) measures the return generated from the capital employed
   * in the business. Formula: Return on Capital Employed (ROCE) = EBIT / (Total Assets - Current
   * Liabilities)
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnoncapital.asp">Investopedia - Return
   *     on Capital Employed (ROCE)</a>
   */
  @Schema(title = "The return on capital employed (ROCE)", example = "0.6008713457059057")
  private BigDecimal returnOnCapitalEmployed;

  /**
   * The net income per EBT measures the proportion of net income to earnings before taxes (EBT).
   * Formula: Net Income per EBT = Net Income / EBT
   */
  @Schema(title = "The net income per EBT", example = "0.8379553831557559")
  private BigDecimal netIncomePerEBT;

  /**
   * The EBT per EBIT measures the proportion of earnings before taxes (EBT) to earnings before
   * interest and taxes (EBIT). Formula: EBT per EBIT = EBT / EBIT
   */
  @Schema(title = "The EBT per EBIT", example = "0.997203546639651")
  private BigDecimal ebtPerEbit;

  /**
   * The EBIT per revenue measures the proportion of earnings before interest and taxes (EBIT) to
   * revenue. Formula: EBIT per Revenue = EBIT / Revenue
   */
  @Schema(title = "The EBIT per revenue", example = "0.30288744395528594")
  private BigDecimal ebitPerRevenue;

  /**
   * The debt ratio measures the proportion of a company's assets that are financed by debt.
   * Formula: Debt Ratio = Total Debt / Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtratio.asp">Investopedia - Debt Ratio</a>
   */
  @Schema(title = "The debt ratio", example = "0.8563535598361469")
  private BigDecimal debtRatio;

  /**
   * The debt-to-equity ratio compares a company's total debt to its shareholders' equity. Formula:
   * Debt-to-Equity Ratio = Total Debt / Shareholders' Equity
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtequityratio.asp">Investopedia -
   *     Debt-to-Equity Ratio</a>
   */
  @Schema(title = "The debt-to-equity ratio", example = "2.3695334701610355")
  private BigDecimal debtEquityRatio;

  /**
   * The long-term debt to capitalization ratio compares a company's long-term debt to its total
   * capitalization (equity and debt). Formula: Long-term Debt to Capitalization Ratio = Long-term
   * Debt / (Long-term Debt + Shareholders' Equity)
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/l/long-term-debt-to-capitalization.asp">Investopedia
   *     - Long-term Debt to Capitalization Ratio</a>
   */
  @Schema(title = "The long-term debt to capitalization ratio", example = "0.6613535965140913")
  private BigDecimal longTermDebtToCapitalization;

  /**
   * The total debt to capitalization ratio compares a company's total debt to its total
   * capitalization (equity and debt). Formula: Total Debt to Capitalization Ratio = Total Debt /
   * (Total Debt + Shareholders' Equity)
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/t/total-debt-to-capitalization.asp">Investopedia -
   *     Total Debt to Capitalization Ratio</a>
   */
  @Schema(title = "The total debt to capitalization ratio", example = "0.7032230102904399")
  private BigDecimal totalDebtToCapitalization;

  /**
   * The interest coverage ratio measures a company's ability to cover its interest payments with
   * its operating income. Formula: Interest Coverage Ratio = EBIT / Interest Expense
   *
   * @see <a href="https://www.investopedia.com/terms/i/interestcoverageratio.asp">Investopedia -
   *     Interest Coverage Ratio</a>
   */
  @Schema(title = "The interest coverage ratio", example = "40.74957352439441")
  private BigDecimal interestCoverage;

  /**
   * The cash flow to debt ratio compares a company's cash flow from operations to its total debt.
   * Formula: Cash Flow to Debt Ratio = Cash Flow from Operations / Total Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cash_flow_to_debt_ratio.asp">Investopedia -
   *     Cash Flow to Debt Ratio</a>
   */
  @Schema(title = "The cash flow to debt ratio", example = "1.0173400294830472")
  private BigDecimal cashFlowToDebtRatio;

  /**
   * The company equity multiplier represents the degree of financial leverage used by a company.
   * Formula: Company Equity Multiplier = Total Assets / Shareholders' Equity
   */
  @Schema(title = "The company equity multiplier", example = "6.961536943479634")
  private BigDecimal companyEquityMultiplier;

  /**
   * The receivables turnover indicates how many times a company can turn its accounts receivable
   * into cash during a period. Formula: Receivables Turnover = Revenue / Average Accounts
   * Receivable
   *
   * @see <a href="https://www.investopedia.com/terms/r/receivablesturnover.asp">Investopedia -
   *     Receivables Turnover</a>
   */
  @Schema(title = "The receivables turnover", example = "6.471607693822622")
  private BigDecimal receivablesTurnover;

  /**
   * The payables turnover measures how many times a company pays its average accounts payable
   * during a period. Formula: Payables Turnover = Purchases / Average Accounts Payable
   *
   * @see <a href="https://www.investopedia.com/terms/p/payablesturnover.asp">Investopedia -
   *     Payables Turnover</a>
   */
  @Schema(title = "The payables turnover", example = "3.486641191608828")
  private BigDecimal payablesTurnover;

  /**
   * The inventory turnover shows how efficiently a company can convert its inventory into sales
   * over a period. Formula: Inventory Turnover = Cost of Goods Sold / Average Inventory
   *
   * @see <a href="https://www.investopedia.com/terms/i/inventoryturnover.asp">Investopedia -
   *     Inventory Turnover</a>
   */
  @Schema(title = "The inventory turnover", example = "45.19733117670845")
  private BigDecimal inventoryTurnover;

  /**
   * The fixed asset turnover measures a company's ability to generate sales from its fixed assets.
   * Formula: Fixed Asset Turnover = Revenue / Average Fixed Assets
   *
   * @see <a href="https://www.investopedia.com/terms/f/fixed-asset-turnover.asp">Investopedia -
   *     Fixed Asset Turnover</a>
   */
  @Schema(title = "The fixed asset turnover", example = "9.362680152907377")
  private BigDecimal fixedAssetTurnover;

  /**
   * The asset turnover measures how effectively a company utilizes its assets to generate revenue.
   * Formula: Asset Turnover = Revenue / Average Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/a/assetturnover.asp">Investopedia - Asset
   *     Turnover</a>
   */
  @Schema(title = "The asset turnover", example = "1.1178523337727317")
  private BigDecimal assetTurnover;

  /**
   * The operating cash flow per share represents the cash generated by a company's operations per
   * outstanding share. Formula: Operating Cash Flow per Share = Operating Cash Flow / Number of
   * Shares Outstanding
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/o/operating_cash_flow_per_share.asp">Investopedia
   *     - Operating Cash Flow per Share</a>
   */
  @Schema(title = "The operating cash flow per share", example = "7.532762624088375")
  private BigDecimal operatingCashFlowPerShare;

  /**
   * The free cash flow per share represents the cash remaining after subtracting capital
   * expenditures per outstanding share. Formula: Free Cash Flow per Share = Free Cash Flow / Number
   * of Shares Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowpershare.asp">Investopedia -
   *     Free Cash Flow per Share</a>
   */
  @Schema(title = "The free cash flow per share", example = "6.872425646259799")
  private BigDecimal freeCashFlowPerShare;

  /**
   * The cash per share represents the cash and cash equivalents per outstanding share. Formula:
   * Cash per Share = Cash and Cash Equivalents / Number of Shares Outstanding
   */
  @Schema(title = "The cash per share", example = "2.9787931805221803")
  private BigDecimal cashPerShare;

  /**
   * The payout ratio represents the proportion of earnings paid out as dividends to shareholders.
   * Formula: Payout Ratio = Dividends per Share / Earnings per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/payoutratio.asp">Investopedia - Payout
   *     Ratio</a>
   */
  @Schema(title = "The payout ratio", example = "0.14870294480125848")
  private BigDecimal payoutRatio;

  /**
   * The operating cash flow to sales ratio measures the percentage of sales converted into cash
   * from operating activities. Formula: Operating Cash Flow to Sales Ratio = Operating Cash Flow /
   * Revenue
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/o/operating-cash-flow-to-sales-ratio.asp">Investopedia
   *     - Operating Cash Flow to Sales Ratio</a>
   */
  @Schema(title = "The operating cash flow to sales ratio", example = "0.30977003915522106")
  private BigDecimal operatingCashFlowSalesRatio;

  /**
   * The free cash flow to operating cash flow ratio indicates the proportion of operating cash flow
   * that is available for discretionary purposes. Formula: Free Cash Flow to Operating Cash Flow
   * Ratio = Free Cash Flow / Operating Cash Flow
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowratio.asp">Investopedia - Free
   *     Cash Flow to Operating Cash Flow Ratio</a>
   */
  @Schema(title = "The free cash flow to operating cash flow ratio", example = "0.9123380078754983")
  private BigDecimal freeCashFlowOperatingCashFlowRatio;

  /**
   * The cash flow coverage ratios measure a company's ability to cover its debt obligations with
   * its cash flow. Formula: Cash Flow Coverage Ratios = Cash Flow from Operations / Total Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashflowcoverageratios.asp">Investopedia -
   *     Cash Flow Coverage Ratios</a>
   */
  @Schema(title = "The cash flow coverage ratios", example = "1.0173400294830472")
  private BigDecimal cashFlowCoverageRatios;

  /**
   * The short-term coverage ratios measure a company's ability to cover its short-term obligations
   * with its cash flow. Formula: Short-term Coverage Ratios = Cash Flow from Operations /
   * Short-term Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/s/short-term-coverage-ratios.asp">Investopedia
   *     - Short-term Coverage Ratios</a>
   */
  @Schema(title = "The short-term coverage ratios", example = "5.786404547607769")
  private BigDecimal shortTermCoverageRatios;

  /**
   * The capital expenditure coverage ratio measures a company's ability to cover its capital
   * expenditures with its cash flow. Formula: Capital Expenditure Coverage Ratio = Operating Cash
   * Flow / Capital Expenditures
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/c/capitalexpenditurecoverageratio.asp">Investopedia
   *     - Capital Expenditure Coverage Ratio</a>
   */
  @Schema(title = "The capital expenditure coverage ratio", example = "-11.407452372058275")
  private BigDecimal capitalExpenditureCoverageRatio;

  /**
   * The dividend paid and capex coverage ratio measures a company's ability to cover its dividends
   * and capital expenditures with its cash flow. Formula: Dividend Paid and Capex Coverage Ratio =
   * Operating Cash Flow / (Dividends + Capital Expenditures)
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/d/dividend-and-capex-coverage-ratio.asp">Investopedia
   *     - Dividend Paid and Capex Coverage Ratio</a>
   */
  @Schema(title = "The dividend paid and capex coverage ratio", example = "29.555044761674328")
  private BigDecimal dividendPaidAndCapexCoverageRatio;

  /**
   * The dividend payout ratio represents the proportion of earnings paid out as dividends to
   * shareholders. Formula: Dividend Payout Ratio = Dividends / Net Income
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendpayoutratio.asp">Investopedia -
   *     Dividend Payout Ratio</a>
   */
  @Schema(title = "The dividend payout ratio", example = "0.14870294480125848")
  private BigDecimal dividendPayoutRatio;

  /**
   * The price-to-book value ratio compares a company's market price per share to its book value per
   * share. Formula: Price-to-Book Value Ratio = Market Price per Share / Book Value per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-bookratio.asp">Investopedia -
   *     Price-to-Book Value Ratio</a>
   */
  @Schema(title = "The price-to-book value ratio", example = "48.14034011071204")
  private BigDecimal priceToBookRatio;

  /**
   * The price-to-sales ratio compares a company's market price per share to its revenue per share.
   * Formula: Price-to-Sales Ratio = Market Price per Share / Revenue per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-salesratio.asp">Investopedia -
   *     Price-to-Sales Ratio</a>
   */
  @Schema(title = "The price-to-sales ratio", example = "6.186137718067193")
  private BigDecimal priceToSalesRatio;

  /**
   * The price-to-earnings ratio compares a company's market price per share to its earnings per
   * share. Formula: Price-to-Earnings Ratio = Market Price per Share / Earnings per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-earningsratio.asp">Investopedia -
   *     Price-to-Earnings Ratio</a>
   */
  @Schema(title = "The price-to-earnings ratio", example = "24.441823533260525")
  private BigDecimal priceEarningsRatio;

  /**
   * The price-to-free cash flows ratio compares a company's market price per share to its free cash
   * flow per share. Formula: Price-to-Free Cash Flows Ratio = Market Price per Share / Free Cash
   * Flow per Share
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/p/price-to-free-cash-flows-ratio.asp">Investopedia
   *     - Price-to-Free Cash Flows Ratio</a>
   */
  @Schema(title = "The price-to-free cash flows ratio", example = "21.888923611981014")
  private BigDecimal priceToFreeCashFlowsRatio;

  /**
   * The price-to-operating cash flows ratio compares a company's market price per share to its
   * operating cash flow per share. Formula: Price-to-Operating Cash Flows Ratio = Market Price per
   * Share / Operating Cash Flow per Share
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/p/price-to-operating-cash-flows-ratio.asp">Investopedia
   *     - Price-to-Operating Cash Flows Ratio</a>
   */
  @Schema(title = "The price-to-operating cash flows ratio", example = "19.970096962693717")
  private BigDecimal priceToOperatingCashFlowsRatio;

  /**
   * The price-cash flow ratio compares a company's market price per share to its cash flow per
   * share. Formula: Price-Cash Flow Ratio = Market Price per Share / Cash Flow per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-cash-flow-ratio.asp">Investopedia -
   *     Price-Cash Flow Ratio</a>
   */
  @Schema(title = "The price-cash flow ratio", example = "19.970096962693717")
  private BigDecimal priceCashFlowRatio;

  /**
   * The price-earnings to growth ratio (PEG ratio) compares a company's price-to-earnings ratio to
   * its earnings growth rate. Formula: Price-Earnings to Growth Ratio = Price-to-Earnings Ratio /
   * Earnings Growth Rate
   *
   * @see <a href="https://www.investopedia.com/terms/p/peg-ratio.asp">Investopedia - Price-Earnings
   *     to Growth Ratio (PEG Ratio)</a>
   */
  @Schema(title = "The price-earnings to growth ratio (PEG ratio)", example = "2.8871904048663968")
  private BigDecimal priceEarningsToGrowthRatio;

  /**
   * The dividend yield represents the annual dividend payment as a percentage of the stock price.
   * Formula: Dividend Yield = Dividends per Share / Market Price per Share
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendyield.asp">Investopedia - Dividend
   *     Yield</a>
   */
  @Schema(title = "The dividend yield", example = "0.006083954603424043")
  private BigDecimal dividendYield;

  /**
   * The enterprise value multiple compares a company's enterprise value to its earnings or cash
   * flow. Formula: Enterprise Value Multiple = Enterprise Value / Earnings or Cash Flow
   *
   * @see <a href="https://www.investopedia.com/terms/e/enterprise-value-multiple.asp">Investopedia
   *     - Enterprise Value Multiple</a>
   */
  @Schema(title = "The enterprise value multiple", example = "19.42524045388039")
  private BigDecimal enterpriseValueMultiple;

  /** The price fair value represents the estimated fair value of a company's stock price. */
  @Schema(title = "The price fair value", example = "48.14034011071204")
  private BigDecimal priceFairValue;
  /**
   * Determines whether these ratios are for the trailing twelve months or based on the financial
   * report date.
   */
  private boolean isTTM;

  public void setIsTTM(boolean ttm) {
    isTTM = ttm;
  }

  public boolean getIsTTM() {
    return isTTM;
  }

  /**
   * Represents the activity ratios, which measure a company's efficiency in managing its assets and
   * resources. Learn more: {@link <a
   * href="https://www.investopedia.com/terms/#activity-ratios">Activity Ratios</a>}
   */
  @Data
  @AllArgsConstructor
  public static class ActivityRatios {
    private BigDecimal receivablesTurnover;
    private BigDecimal payablesTurnover;
    private BigDecimal inventoryTurnover;
  }

  /**
   * Represents the profitability ratios, which assess a company's ability to generate profit
   * relative to its revenue, costs, and investments. Learn more: {@link <a
   * href="https://www.investopedia.com/terms/#profitability-ratios">Profitability Ratios</a>}
   */
  @Data
  @AllArgsConstructor
  public static class ProfitabilityRatios {
    private BigDecimal grossProfitMargin;
    private BigDecimal operatingProfitMargin;
    private BigDecimal netProfitMargin;
  }

  /**
   * Represents the liquidity ratios, which assess a company's ability to meet short-term
   * obligations. Learn more: {@link <a
   * href="https://www.investopedia.com/terms/#liquidity-ratios">Liquidity Ratios</a>}
   */
  @Data
  @AllArgsConstructor
  public static class LiquidityRatios {
    private BigDecimal currentRatio;
    private BigDecimal quickRatio;
    private BigDecimal cashRatio;
  }

  /**
   * Represents the solvency ratios, which assess a company's long-term financial stability and its
   * ability to meet long-term obligations. Learn more: {@link <a
   * href="https://www.investopedia.com/terms/#solvency-ratios">Solvency Ratios</a>}
   */
  @Data
  @AllArgsConstructor
  public static class SolvencyRatios {
    private BigDecimal debtRatio;
    private BigDecimal debtEquityRatio;
    private BigDecimal interestCoverage;
  }

  /**
   * Represents the cash flow ratios, which measure a company's ability to generate cash flow and
   * manage its financial resources. Learn more: {@link <a
   * href="https://www.investopedia.com/terms/#cash-flow-ratios">Cash Flow Ratios</a>}
   */
  @Data
  @AllArgsConstructor
  public static class CashFlowRatios {
    private BigDecimal operatingCashFlowPerShare;
    private BigDecimal freeCashFlowPerShare;
    private BigDecimal cashFlowToDebtRatio;
  }

  /**
   * Groups all the ratio fields into a single object that contains instances of the semantic
   * projection inner classes.
   *
   * @return A map object containing instances of the semantic projection inner classes with the
   *     ratio fields, or null if any of the fields are null.
   */
  public Pair<Date, RatiosGroup> groupRatios() {
    if (Objects.isNull(date)
        || Objects.isNull(receivablesTurnover)
        || Objects.isNull(payablesTurnover)
        || Objects.isNull(inventoryTurnover)
        || Objects.isNull(grossProfitMargin)
        || Objects.isNull(operatingProfitMargin)
        || Objects.isNull(netProfitMargin)
        || Objects.isNull(currentRatio)
        || Objects.isNull(quickRatio)
        || Objects.isNull(cashRatio)
        || Objects.isNull(debtRatio)
        || Objects.isNull(debtEquityRatio)
        || Objects.isNull(interestCoverage)
        || Objects.isNull(operatingCashFlowPerShare)
        || Objects.isNull(freeCashFlowPerShare)
        || Objects.isNull(cashFlowToDebtRatio)
    // Add checks for other ratio fields...
    ) {
      return null;
    }

    RatiosGroup ratiosGroup = new RatiosGroup();
    ratiosGroup.setActivityRatios(
        new ActivityRatios(receivablesTurnover, payablesTurnover, inventoryTurnover));
    ratiosGroup.setProfitabilityRatios(
        new ProfitabilityRatios(grossProfitMargin, operatingProfitMargin, netProfitMargin));
    ratiosGroup.setLiquidityRatios(new LiquidityRatios(currentRatio, quickRatio, cashRatio));
    ratiosGroup.setSolvencyRatios(new SolvencyRatios(debtRatio, debtEquityRatio, interestCoverage));
    ratiosGroup.setCashFlowRatios(
        new CashFlowRatios(operatingCashFlowPerShare, freeCashFlowPerShare, cashFlowToDebtRatio));
    // Set other semantic projection inner classes with their respective fields...

    return Pair.of(Objects.requireNonNull(DateFormatter.parse(date)), ratiosGroup);
  }

  /** Represents a group of semantic projection inner classes containing the ratio fields. */
  @Data
  public static class RatiosGroup {
    private ActivityRatios activityRatios;
    private ProfitabilityRatios profitabilityRatios;
    private LiquidityRatios liquidityRatios;
    private SolvencyRatios solvencyRatios;
    private CashFlowRatios cashFlowRatios;
    private boolean ttm;
  }
}
