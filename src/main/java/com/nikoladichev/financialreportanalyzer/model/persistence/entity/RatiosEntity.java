package com.nikoladichev.financialreportanalyzer.model.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(StatementId.class)
public class RatiosEntity {

  private @Id String symbol;

  private @Id String date;

  private @Id String period;

  /**
   * The current ratio measures a company's ability to cover its short-term liabilities with its
   * short-term assets. Formula: Current Ratio = Current Assets / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/currentratio.asp">Investopedia - Current
   *     Ratio</a>
   */
  private BigDecimal currentRatio;

  /**
   * The quick ratio (acid-test ratio) measures a company's ability to cover its short-term
   * liabilities with its most liquid assets. Formula: Quick Ratio = (Cash + Cash Equivalents +
   * Marketable Securities + Accounts Receivable) / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/q/quickratio.asp">Investopedia - Quick
   *     Ratio</a>
   */
  private BigDecimal quickRatio;

  /**
   * The cash ratio represents the proportion of a company's current assets held in cash or cash
   * equivalents. Formula: Cash Ratio = Cash and Cash Equivalents / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashratio.asp">Investopedia - Cash Ratio</a>
   */
  private BigDecimal cashRatio;

  /**
   * The days of sales outstanding (DSO) measures the average number of days it takes for a company
   * to collect payment after a sale is made. Formula: DSO = (Accounts Receivable / Total Credit
   * Sales) * Number of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/dayssalesout.asp">Investopedia - Days Sales
   *     Outstanding (DSO)</a>
   */
  private BigDecimal daysOfSalesOutstanding;

  /**
   * The days of inventory outstanding (DIO) measures the average number of days it takes for a
   * company to sell its inventory. Formula: DIO = (Average Inventory / Cost of Goods Sold) * Number
   * of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofinventoryout.asp">Investopedia - Days
   *     of Inventory Outstanding (DIO)</a>
   */
  private BigDecimal daysOfInventoryOutstanding;

  /**
   * The operating cycle measures the average time it takes for a company to convert its inventory
   * into cash. Formula: Operating Cycle = DIO + DSO
   */
  private BigDecimal operatingCycle;

  /**
   * The days of payables outstanding (DPO) measures the average number of days it takes for a
   * company to pay its suppliers. Formula: DPO = (Accounts Payable / Total Credit Purchases) *
   * Number of Days
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofpayableout.asp">Investopedia - Days of
   *     Payables Outstanding (DPO)</a>
   */
  private BigDecimal daysOfPayablesOutstanding;

  /**
   * The cash conversion cycle (CCC) measures the time it takes for a company to convert its
   * resources into cash flows. Formula: CCC = Operating Cycle - DPO
   */
  private BigDecimal cashConversionCycle;

  /**
   * The gross profit margin represents the percentage of revenue that exceeds the cost of goods
   * sold. Formula: Gross Profit Margin = (Revenue - Cost of Goods Sold) / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/g/gross_profit_margin.asp">Investopedia -
   *     Gross Profit Margin</a>
   */
  private BigDecimal grossProfitMargin;

  /**
   * The operating profit margin indicates the percentage of revenue remaining after deducting
   * operating expenses. Formula: Operating Profit Margin = Operating Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/o/operating_margin.asp">Investopedia -
   *     Operating Profit Margin</a>
   */
  private BigDecimal operatingProfitMargin;

  /**
   * The pretax profit margin represents the percentage of revenue remaining after deducting all
   * operating expenses and before income tax. Formula: Pretax Profit Margin = Pre-tax Income /
   * Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/p/pretax-profit-margin.asp">Investopedia -
   *     Pretax Profit Margin</a>
   */
  private BigDecimal pretaxProfitMargin;

  /**
   * The net profit margin shows the percentage of revenue that represents a company's net income.
   * Formula: Net Profit Margin = Net Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/n/net_profit_margin.asp">Investopedia - Net
   *     Profit Margin</a>
   */
  private BigDecimal netProfitMargin;

  /**
   * The effective tax rate represents the percentage of pre-tax income that a company pays in
   * taxes. Formula: Effective Tax Rate = Income Tax Expense / Pre-tax Income
   *
   * @see <a href="https://www.investopedia.com/terms/e/effectivetaxrate.asp">Investopedia -
   *     Effective Tax Rate</a>
   */
  private BigDecimal effectiveTaxRate;

  /**
   * The return on assets (ROA) measures how effectively a company uses its assets to generate
   * profit. Formula: Return on Assets (ROA) = Net Income / Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonassets.asp">Investopedia - Return on
   *     Assets (ROA)</a>
   */
  private BigDecimal returnOnAssets;

  /**
   * The return on equity (ROE) indicates the return generated on shareholders' equity investment.
   * Formula: Return on Equity (ROE) = Net Income / Shareholders' Equity
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonequity.asp">Investopedia - Return on
   *     Equity (ROE)</a>
   */
  private BigDecimal returnOnEquity;

  /**
   * The return on capital employed (ROCE) measures the return generated from the capital employed
   * in the business. Formula: Return on Capital Employed (ROCE) = EBIT / (Total Assets - Current
   * Liabilities)
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnoncapital.asp">Investopedia - Return
   *     on Capital Employed (ROCE)</a>
   */
  private BigDecimal returnOnCapitalEmployed;

  /**
   * The net income per EBT measures the proportion of net income to earnings before taxes (EBT).
   * Formula: Net Income per EBT = Net Income / EBT
   */
  private BigDecimal netIncomePerEBT;

  /**
   * The EBT per EBIT measures the proportion of earnings before taxes (EBT) to earnings before
   * interest and taxes (EBIT). Formula: EBT per EBIT = EBT / EBIT
   */
  private BigDecimal ebtPerEbit;

  /**
   * The EBIT per revenue measures the proportion of earnings before interest and taxes (EBIT) to
   * revenue. Formula: EBIT per Revenue = EBIT / Revenue
   */
  private BigDecimal ebitPerRevenue;

  /**
   * The debt ratio measures the proportion of a company's assets that are financed by debt.
   * Formula: Debt Ratio = Total Debt / Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtratio.asp">Investopedia - Debt Ratio</a>
   */
  private BigDecimal debtRatio;

  /**
   * The debt-to-equity ratio compares a company's total debt to its shareholders' equity. Formula:
   * Debt-to-Equity Ratio = Total Debt / Shareholders' Equity
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtequityratio.asp">Investopedia -
   *     Debt-to-Equity Ratio</a>
   */
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
  private BigDecimal totalDebtToCapitalization;

  /**
   * The interest coverage ratio measures a company's ability to cover its interest payments with
   * its operating income. Formula: Interest Coverage Ratio = EBIT / Interest Expense
   *
   * @see <a href="https://www.investopedia.com/terms/i/interestcoverageratio.asp">Investopedia -
   *     Interest Coverage Ratio</a>
   */
  private BigDecimal interestCoverage;

  /**
   * The cash flow to debt ratio compares a company's cash flow from operations to its total debt.
   * Formula: Cash Flow to Debt Ratio = Cash Flow from Operations / Total Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cash_flow_to_debt_ratio.asp">Investopedia -
   *     Cash Flow to Debt Ratio</a>
   */
  private BigDecimal cashFlowToDebtRatio;

  /**
   * The company equity multiplier represents the degree of financial leverage used by a company.
   * Formula: Company Equity Multiplier = Total Assets / Shareholders' Equity
   */
  private BigDecimal companyEquityMultiplier;

  /**
   * The receivables turnover indicates how many times a company can turn its accounts receivable
   * into cash during a period. Formula: Receivables Turnover = Revenue / Average Accounts
   * Receivable
   *
   * @see <a href="https://www.investopedia.com/terms/r/receivablesturnover.asp">Investopedia -
   *     Receivables Turnover</a>
   */
  private BigDecimal receivablesTurnover;

  /**
   * The payables turnover measures how many times a company pays its average accounts payable
   * during a period. Formula: Payables Turnover = Purchases / Average Accounts Payable
   *
   * @see <a href="https://www.investopedia.com/terms/p/payablesturnover.asp">Investopedia -
   *     Payables Turnover</a>
   */
  private BigDecimal payablesTurnover;

  /**
   * The inventory turnover shows how efficiently a company can convert its inventory into sales
   * over a period. Formula: Inventory Turnover = Cost of Goods Sold / Average Inventory
   *
   * @see <a href="https://www.investopedia.com/terms/i/inventoryturnover.asp">Investopedia -
   *     Inventory Turnover</a>
   */
  private BigDecimal inventoryTurnover;

  /**
   * The fixed asset turnover measures a company's ability to generate sales from its fixed assets.
   * Formula: Fixed Asset Turnover = Revenue / Average Fixed Assets
   *
   * @see <a href="https://www.investopedia.com/terms/f/fixed-asset-turnover.asp">Investopedia -
   *     Fixed Asset Turnover</a>
   */
  private BigDecimal fixedAssetTurnover;

  /**
   * The asset turnover measures how effectively a company utilizes its assets to generate revenue.
   * Formula: Asset Turnover = Revenue / Average Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/a/assetturnover.asp">Investopedia - Asset
   *     Turnover</a>
   */
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
  private BigDecimal operatingCashFlowPerShare;

  /**
   * The free cash flow per share represents the cash remaining after subtracting capital
   * expenditures per outstanding share. Formula: Free Cash Flow per Share = Free Cash Flow / Number
   * of Shares Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowpershare.asp">Investopedia -
   *     Free Cash Flow per Share</a>
   */
  private BigDecimal freeCashFlowPerShare;

  /**
   * The cash per share represents the cash and cash equivalents per outstanding share. Formula:
   * Cash per Share = Cash and Cash Equivalents / Number of Shares Outstanding
   */
  private BigDecimal cashPerShare;

  /**
   * The payout ratio represents the proportion of earnings paid out as dividends to shareholders.
   * Formula: Payout Ratio = Dividends per Share / Earnings per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/payoutratio.asp">Investopedia - Payout
   *     Ratio</a>
   */
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
  private BigDecimal operatingCashFlowSalesRatio;

  /**
   * The free cash flow to operating cash flow ratio indicates the proportion of operating cash flow
   * that is available for discretionary purposes. Formula: Free Cash Flow to Operating Cash Flow
   * Ratio = Free Cash Flow / Operating Cash Flow
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowratio.asp">Investopedia - Free
   *     Cash Flow to Operating Cash Flow Ratio</a>
   */
  private BigDecimal freeCashFlowOperatingCashFlowRatio;

  /**
   * The cash flow coverage ratios measure a company's ability to cover its debt obligations with
   * its cash flow. Formula: Cash Flow Coverage Ratios = Cash Flow from Operations / Total Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashflowcoverageratios.asp">Investopedia -
   *     Cash Flow Coverage Ratios</a>
   */
  private BigDecimal cashFlowCoverageRatios;

  /**
   * The short-term coverage ratios measure a company's ability to cover its short-term obligations
   * with its cash flow. Formula: Short-term Coverage Ratios = Cash Flow from Operations /
   * Short-term Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/s/short-term-coverage-ratios.asp">Investopedia
   *     - Short-term Coverage Ratios</a>
   */
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
  private BigDecimal dividendPaidAndCapexCoverageRatio;

  /**
   * The dividend payout ratio represents the proportion of earnings paid out as dividends to
   * shareholders. Formula: Dividend Payout Ratio = Dividends / Net Income
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendpayoutratio.asp">Investopedia -
   *     Dividend Payout Ratio</a>
   */
  private BigDecimal dividendPayoutRatio;

  /**
   * The price-to-book value ratio compares a company's market price per share to its book value per
   * share. Formula: Price-to-Book Value Ratio = Market Price per Share / Book Value per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-bookratio.asp">Investopedia -
   *     Price-to-Book Value Ratio</a>
   */
  private BigDecimal priceToBookRatio;

  /**
   * The price-to-sales ratio compares a company's market price per share to its revenue per share.
   * Formula: Price-to-Sales Ratio = Market Price per Share / Revenue per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-salesratio.asp">Investopedia -
   *     Price-to-Sales Ratio</a>
   */
  private BigDecimal priceToSalesRatio;

  /**
   * The price-to-earnings ratio compares a company's market price per share to its earnings per
   * share. Formula: Price-to-Earnings Ratio = Market Price per Share / Earnings per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-earningsratio.asp">Investopedia -
   *     Price-to-Earnings Ratio</a>
   */
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
  private BigDecimal priceToOperatingCashFlowsRatio;

  /**
   * The price-cash flow ratio compares a company's market price per share to its cash flow per
   * share. Formula: Price-Cash Flow Ratio = Market Price per Share / Cash Flow per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-cash-flow-ratio.asp">Investopedia -
   *     Price-Cash Flow Ratio</a>
   */
  private BigDecimal priceCashFlowRatio;

  /**
   * The price-earnings to growth ratio (PEG ratio) compares a company's price-to-earnings ratio to
   * its earnings growth rate. Formula: Price-Earnings to Growth Ratio = Price-to-Earnings Ratio /
   * Earnings Growth Rate
   *
   * @see <a href="https://www.investopedia.com/terms/p/peg-ratio.asp">Investopedia - Price-Earnings
   *     to Growth Ratio (PEG Ratio)</a>
   */
  private BigDecimal priceEarningsToGrowthRatio;

  /**
   * The dividend yield represents the annual dividend payment as a percentage of the stock price.
   * Formula: Dividend Yield = Dividends per Share / Market Price per Share
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendyield.asp">Investopedia - Dividend
   *     Yield</a>
   */
  private BigDecimal dividendYield;

  /**
   * The enterprise value multiple compares a company's enterprise value to its earnings or cash
   * flow. Formula: Enterprise Value Multiple = Enterprise Value / Earnings or Cash Flow
   *
   * @see <a href="https://www.investopedia.com/terms/e/enterprise-value-multiple.asp">Investopedia
   *     - Enterprise Value Multiple</a>
   */
  private BigDecimal enterpriseValueMultiple;

  /** The price fair value represents the estimated fair value of a company's stock price. */
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
}
