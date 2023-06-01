package com.nikoladichev.financialreportanalyzer.integration.fmp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * This class represents financial ratios and metrics. For more information about each field, refer
 * to the corresponding Investopedia article.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatiosTTM {
  /**
   * Dividend Yield Percentage (TTM) - Represents the dividend income earned per share as a
   * percentage of the stock's price. Formula: Dividend Yield Percentage = Dividend Yield * 100
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendyield.asp">Investopedia - Dividend
   *     Yield</a>
   */
  private BigDecimal dividenYieldPercentageTTM; // this should be fixed on FMP side

  /**
   * Price-to-Earnings Ratio (TTM) - Measures the valuation of a company's stock relative to its
   * earnings. Formula: PE Ratio = Stock Price / Earnings per Share (EPS)
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-earningsratio.asp">Investopedia -
   *     Price-to-Earnings Ratio (P/E Ratio)</a>
   */
  private BigDecimal peRatioTTM;

  /**
   * Price/Earnings-to-Growth Ratio (TTM) - Evaluates the price of a stock relative to its earnings
   * growth. Formula: PEG Ratio = PE Ratio / Earnings Growth Rate
   *
   * @see <a href="https://www.investopedia.com/terms/p/pegratio.asp">Investopedia -
   *     Price/Earnings-to-Growth Ratio (PEG Ratio)</a>
   */
  private BigDecimal pegRatioTTM;

  /**
   * Payout Ratio (TTM) - Represents the proportion of earnings distributed to shareholders as
   * dividends. Formula: Payout Ratio = Dividends per Share / Earnings per Share (EPS)
   *
   * @see <a href="https://www.investopedia.com/terms/p/payoutratio.asp">Investopedia - Payout
   *     Ratio</a>
   */
  private BigDecimal payoutRatioTTM;

  /**
   * Current Ratio (TTM) - Measures a company's ability to pay short-term obligations using its
   * short-term assets. Formula: Current Ratio = Current Assets / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/currentratio.asp">Investopedia - Current
   *     Ratio</a>
   */
  private BigDecimal currentRatioTTM;

  /**
   * Quick Ratio (TTM) - Evaluates a company's ability to cover short-term liabilities with its most
   * liquid assets. Formula: Quick Ratio = (Current Assets - Inventory) / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/q/quickratio.asp">Investopedia - Quick
   *     Ratio</a>
   */
  private BigDecimal quickRatioTTM;

  /**
   * Cash Ratio (TTM) - Represents a company's ability to cover its short-term liabilities with its
   * most liquid asset, cash. Formula: Cash Ratio = Cash / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashratio.asp">Investopedia - Cash Ratio</a>
   */
  private BigDecimal cashRatioTTM;

  /**
   * Days of Sales Outstanding (TTM) - Measures the average number of days it takes to collect
   * revenue from customers. Formula: Days of Sales Outstanding = (Accounts Receivable / Revenue) *
   * Number of Days in Period
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofsalesoutstanding.asp">Investopedia -
   *     Days of Sales Outstanding</a>
   */
  private BigDecimal daysOfSalesOutstandingTTM;

  /**
   * Days of Inventory Outstanding (TTM) - Represents the average number of days it takes to sell
   * inventory. Formula: Days of Inventory Outstanding = (Inventory / Cost of Goods Sold) * Number
   * of Days in Period
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofinventoryoutstanding.asp">Investopedia
   *     - Days of Inventory Outstanding</a>
   */
  private BigDecimal daysOfInventoryOutstandingTTM;

  /**
   * Operating Cycle (TTM) - Measures the average number of days it takes to convert inventory into
   * cash. Formula: Operating Cycle = Days of Sales Outstanding + Days of Inventory Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/o/operatingcycle.asp">Investopedia - Operating
   *     Cycle</a>
   */
  private BigDecimal operatingCycleTTM;

  /**
   * Days of Payables Outstanding (TTM) - Represents the average number of days it takes to pay
   * suppliers. Formula: Days of Payables Outstanding = (Accounts Payable / Cost of Goods Sold) *
   * Number of Days in Period
   *
   * @see <a href="https://www.investopedia.com/terms/d/daysofpayablesoutstanding.asp">Investopedia
   *     - Days of Payables Outstanding</a>
   */
  private BigDecimal daysOfPayablesOutstandingTTM;

  /**
   * Cash Conversion Cycle (TTM) - Measures the time it takes for a company to convert its
   * investments in inventory and other resources into cash flows from sales. Formula: Cash
   * Conversion Cycle = Operating Cycle - Days of Payables Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashconversioncycle.asp">Investopedia - Cash
   *     Conversion Cycle</a>
   */
  private BigDecimal cashConversionCycleTTM;

  /**
   * Gross Profit Margin (TTM) - Evaluates a company's profitability by measuring the percentage of
   * revenue remaining after deducting the cost of goods sold. Formula: Gross Profit Margin =
   * (Revenue - Cost of Goods Sold) / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/g/gross_profit_margin.asp">Investopedia -
   *     Gross Profit Margin</a>
   */
  private BigDecimal grossProfitMarginTTM;

  /**
   * Operating Profit Margin (TTM) - Measures the profitability of a company's core operations.
   * Formula: Operating Profit Margin = Operating Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/o/operating_margin.asp">Investopedia -
   *     Operating Profit Margin</a>
   */
  private BigDecimal operatingProfitMarginTTM;

  /**
   * Pretax Profit Margin (TTM) - Indicates the percentage of revenue that is converted into profits
   * before taxes are deducted. Formula: Pretax Profit Margin = Pretax Profit / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/p/pretaxprofitmargin.asp">Investopedia -
   *     Pretax Profit Margin</a>
   */
  private BigDecimal pretaxProfitMarginTTM;

  /**
   * Net Profit Margin (TTM) - Measures the percentage of revenue that remains as net income after
   * all expenses, including taxes, are deducted. Formula: Net Profit Margin = Net Income / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/n/net-profit-margin.asp">Investopedia - Net
   *     Profit Margin</a>
   */
  private BigDecimal netProfitMarginTTM;

  /**
   * Effective Tax Rate (TTM) - Represents the average rate at which a company is taxed on its
   * taxable income. Formula: Effective Tax Rate = Income Tax Expense / Pretax Profit
   *
   * @see <a href="https://www.investopedia.com/terms/t/taxrate.asp">Investopedia - Effective Tax
   *     Rate</a>
   */
  private BigDecimal effectiveTaxRateTTM;

  /**
   * Return on Assets (TTM) - Measures the profitability of a company's assets. Formula: Return on
   * Assets = Net Income / Average Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonassets.asp">Investopedia - Return on
   *     Assets (ROA)</a>
   */
  private BigDecimal returnOnAssetsTTM;

  /**
   * Return on Equity (TTM) - Measures the profitability of a company's shareholders' equity.
   * Formula: Return on Equity = Net Income / Average Shareholders' Equity
   *
   * @see <a href="https://www.investopedia.com/terms/r/returnonequity.asp">Investopedia - Return on
   *     Equity (ROE)</a>
   */
  private BigDecimal returnOnEquityTTM;

  /**
   * Return on Capital Employed (TTM) - Evaluates the profitability of a company's capital
   * investments. Formula: Return on Capital Employed = Operating Income / (Total Assets - Current
   * Liabilities)
   *
   * @see <a href="https://www.investopedia.com/terms/r/return-on-capital-employed.asp">Investopedia
   *     - Return on Capital Employed (ROCE)</a>
   */
  private BigDecimal returnOnCapitalEmployedTTM;

  /**
   * Net Income per Earnings Before Taxes (EBT) (TTM) - Represents the net income earned per dollar
   * of earnings before taxes. Formula: Net Income per EBT = Net Income / Earnings Before Taxes
   *
   * @see <a href="https://www.investopedia.com/terms/n/netincometotalrevenue.asp">Investopedia -
   *     Net Income to Total Revenue</a>
   */
  private BigDecimal netIncomePerEBTTTM;

  /**
   * Earnings Before Interest and Taxes (EBIT) per Earnings Before Interest and Taxes (EBIT) (TTM) -
   * Measures the efficiency of a company's operations by comparing EBIT to EBIT. Formula: EBIT per
   * EBIT = EBIT / EBIT
   *
   * @see <a href="https://www.investopedia.com/terms/e/ebitmargin.asp">Investopedia - EBIT
   *     Margin</a>
   */
  private BigDecimal ebtPerEbitTTM;

  /**
   * Earnings Before Interest and Taxes (EBIT) per Revenue (TTM) - Measures a company's ability to
   * generate operating income relative to its revenue. Formula: EBIT per Revenue = EBIT / Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/e/ebitmargin.asp">Investopedia - EBIT
   *     Margin</a>
   */
  private BigDecimal ebitPerRevenueTTM;

  /**
   * Debt Ratio (TTM) - Evaluates the proportion of a company's assets that are financed by debt.
   * Formula: Debt Ratio = Total Debt / Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtratio.asp">Investopedia - Debt Ratio</a>
   */
  private BigDecimal debtRatioTTM;

  /**
   * Debt-to-Equity Ratio (TTM) - Measures the proportion of a company's financing that comes from
   * debt relative to equity. Formula: Debt-to-Equity Ratio = Total Debt / Total Equity
   *
   * @see <a href="https://www.investopedia.com/terms/d/debtequityratio.asp">Investopedia -
   *     Debt-to-Equity Ratio</a>
   */
  private BigDecimal debtEquityRatioTTM;

  /**
   * Long-Term Debt to Capitalization Ratio (TTM) - Represents the proportion of a company's
   * long-term debt to its total capitalization. Formula: Long-Term Debt to Capitalization Ratio =
   * Long-Term Debt / (Long-Term Debt + Shareholders' Equity)
   *
   * @see <a href="https://www.investopedia.com/terms/l/longtermdebttoequityratio.asp">Investopedia
   *     - Long-Term Debt to Capitalization Ratio</a>
   */
  private BigDecimal longTermDebtToCapitalizationTTM;

  /**
   * Total Debt to Capitalization Ratio (TTM) - Measures the proportion of a company's total debt to
   * its total capitalization. Formula: Total Debt to Capitalization Ratio = Total Debt / (Total
   * Debt + Shareholders' Equity)
   *
   * @see <a href="https://www.investopedia.com/terms/t/totaldebttoequityratio.asp">Investopedia -
   *     Total Debt to Capitalization Ratio</a>
   */
  private BigDecimal totalDebtToCapitalizationTTM;

  /**
   * Interest Coverage Ratio (TTM) - Evaluates a company's ability to cover its interest expenses
   * with its operating income. Formula: Interest Coverage Ratio = EBIT / Interest Expense
   *
   * @see <a href="https://www.investopedia.com/terms/i/interestcoverageratio.asp">Investopedia -
   *     Interest Coverage Ratio</a>
   */
  private BigDecimal interestCoverageTTM;

  /**
   * Cash Flow to Debt Ratio (TTM) - Measures a company's ability to generate cash flow from its
   * operations relative to its debt. Formula: Cash Flow to Debt Ratio = Operating Cash Flow / Total
   * Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashflowratio.asp">Investopedia - Cash Flow
   *     to Debt Ratio</a>
   */
  private BigDecimal cashFlowToDebtRatioTTM;

  /**
   * Company Equity Multiplier (TTM) - Measures the proportion of a company's assets that are
   * financed by its shareholders' equity. Formula: Company Equity Multiplier = Total Assets / Total
   * Equity
   *
   * @see <a href="https://www.investopedia.com/terms/e/equitymultiplier.asp">Investopedia - Equity
   *     Multiplier</a>
   */
  private BigDecimal companyEquityMultiplierTTM;

  /**
   * Receivables Turnover (TTM) - Evaluates a company's efficiency in collecting payment from its
   * customers. Formula: Receivables Turnover = Revenue / Average Accounts Receivable
   *
   * @see <a href="https://www.investopedia.com/terms/r/receivablesturnover.asp">Investopedia -
   *     Receivables Turnover</a>
   */
  private BigDecimal receivablesTurnoverTTM;

  /**
   * Payables Turnover (TTM) - Measures a company's efficiency in paying its suppliers. Formula:
   * Payables Turnover = Purchases / Average Accounts Payable
   *
   * @see <a href="https://www.investopedia.com/terms/p/payablesturnover.asp">Investopedia -
   *     Payables Turnover</a>
   */
  private BigDecimal payablesTurnoverTTM;

  /**
   * Inventory Turnover (TTM) - Measures the efficiency of a company's inventory management.
   * Formula: Inventory Turnover = Cost of Goods Sold / Average Inventory
   *
   * @see <a href="https://www.investopedia.com/terms/i/inventoryturnover.asp">Investopedia -
   *     Inventory Turnover</a>
   */
  private BigDecimal inventoryTurnoverTTM;

  /**
   * Fixed Asset Turnover (TTM) - Evaluates a company's efficiency in generating sales from its
   * fixed assets. Formula: Fixed Asset Turnover = Revenue / Average Fixed Assets
   *
   * @see <a href="https://www.investopedia.com/terms/f/fixed-asset-turnover.asp">Investopedia -
   *     Fixed Asset Turnover</a>
   */
  private BigDecimal fixedAssetTurnoverTTM;

  /**
   * Asset Turnover (TTM) - Measures a company's efficiency in using its assets to generate revenue.
   * Formula: Asset Turnover = Revenue / Average Total Assets
   *
   * @see <a href="https://www.investopedia.com/terms/a/assetturnover.asp">Investopedia - Asset
   *     Turnover</a>
   */
  private BigDecimal assetTurnoverTTM;

  /**
   * Operating Cash Flow per Share (TTM) - Represents the cash generated by a company's operations
   * per share. Formula: Operating Cash Flow per Share = Operating Cash Flow / Weighted Average
   * Shares Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/o/operatingcashflowpershare.asp">Investopedia
   *     - Operating Cash Flow per Share</a>
   */
  private BigDecimal operatingCashFlowPerShareTTM;

  /**
   * Free Cash Flow per Share (TTM) - Measures the cash generated by a company's operations after
   * accounting for capital expenditures per share. Formula: Free Cash Flow per Share = Free Cash
   * Flow / Weighted Average Shares Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowpershare.asp">Investopedia -
   *     Free Cash Flow per Share</a>
   */
  private BigDecimal freeCashFlowPerShareTTM;

  /**
   * Cash per Share (TTM) - Represents the cash available to shareholders per share. Formula: Cash
   * per Share = Cash / Weighted Average Shares Outstanding
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashpershare.asp">Investopedia - Cash per
   *     Share</a>
   */
  private BigDecimal cashPerShareTTM;

  /**
   * Operating Cash Flow to Sales Ratio (TTM) - Measures the percentage of sales that is converted
   * into operating cash flow. Formula: Operating Cash Flow to Sales Ratio = Operating Cash Flow /
   * Revenue
   *
   * @see <a href="https://www.investopedia.com/terms/o/operatingcashflowratio.asp">Investopedia -
   *     Operating Cash Flow to Sales Ratio</a>
   */
  private BigDecimal operatingCashFlowSalesRatioTTM;

  /**
   * Free Cash Flow to Operating Cash Flow Ratio (TTM) - Evaluates the proportion of operating cash
   * flow that is available as free cash flow. Formula: Free Cash Flow to Operating Cash Flow Ratio
   * = Free Cash Flow / Operating Cash Flow
   *
   * @see <a href="https://www.investopedia.com/terms/f/freecashflowratio.asp">Investopedia - Free
   *     Cash Flow to Operating Cash Flow Ratio</a>
   */
  private BigDecimal freeCashFlowOperatingCashFlowRatioTTM;

  /**
   * Cash Flow Coverage Ratios (TTM) - Measures a company's ability to cover its obligations using
   * its cash flow. Formula: Cash Flow Coverage Ratios = Operating Cash Flow / Total Debt
   *
   * @see <a href="https://www.investopedia.com/terms/c/cashflowcoverage.asp">Investopedia - Cash
   *     Flow Coverage Ratios</a>
   */
  private BigDecimal cashFlowCoverageRatiosTTM;

  /**
   * Short-Term Coverage Ratios (TTM) - Evaluates a company's ability to cover its short-term
   * obligations using its cash flow. Formula: Short-Term Coverage Ratios = (Operating Cash Flow +
   * Short-Term Investments) / Current Liabilities
   *
   * @see <a href="https://www.investopedia.com/terms/s/shorttermcoverage.asp">Investopedia -
   *     Short-Term Coverage Ratios</a>
   */
  private BigDecimal shortTermCoverageRatiosTTM;

  /**
   * Capital Expenditure Coverage Ratio (TTM) - Measures a company's ability to cover its capital
   * expenditures with its cash flow. Formula: Capital Expenditure Coverage Ratio = Operating Cash
   * Flow / Capital Expenditures
   *
   * @see <a href="https://www.investopedia.com/terms/c/capexcoverage.asp">Investopedia - Capital
   *     Expenditure Coverage Ratio</a>
   */
  private BigDecimal capitalExpenditureCoverageRatioTTM;

  /**
   * Dividend Paid and Capex Coverage Ratio (TTM) - Evaluates a company's ability to cover its
   * dividend payments and capital expenditures with its cash flow. Formula: Dividend Paid and Capex
   * Coverage Ratio = Operating Cash Flow / (Dividends Paid + Capital Expenditures)
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendcoverage.asp">Investopedia -
   *     Dividend Paid and Capex Coverage Ratio</a>
   */
  private BigDecimal dividendPaidAndCapexCoverageRatioTTM;

  /**
   * Price-to-Book Value Ratio (TTM) - Measures the market value of a company relative to its book
   * value. Formula: Price-to-Book Value Ratio = Stock Price / Book Value per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-bookratio.asp">Investopedia -
   *     Price-to-Book Value Ratio</a>
   */
  private BigDecimal priceBookValueRatioTTM;

  /**
   * Price-to-Book Ratio (TTM) - Evaluates the market value of a company relative to its book value.
   * Formula: Price-to-Book Ratio = Stock Price / Book Value per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-bookratio.asp">Investopedia -
   *     Price-to-Book Ratio</a>
   */
  private BigDecimal priceToBookRatioTTM;

  /**
   * Price-to-Sales Ratio (TTM) - Measures the market value of a company relative to its revenue.
   * Formula: Price-to-Sales Ratio = Stock Price / Revenue per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-salesratio.asp">Investopedia -
   *     Price-to-Sales Ratio</a>
   */
  private BigDecimal priceToSalesRatioTTM;

  /**
   * Price/Earnings Ratio (TTM) - Evaluates the market value of a company relative to its earnings.
   * Formula: Price/Earnings Ratio = Stock Price / Earnings per Share (EPS)
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-earningsratio.asp">Investopedia -
   *     Price/Earnings Ratio (P/E Ratio)</a>
   */
  private BigDecimal priceEarningsRatioTTM;

  /**
   * Price-to-Free Cash Flows Ratio (TTM) - Measures the market value of a company relative to its
   * free cash flows. Formula: Price-to-Free Cash Flows Ratio = Stock Price / Free Cash Flow per
   * Share
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/p/price-to-freecashflowsratio.asp">Investopedia -
   *     Price-to-Free Cash Flows Ratio</a>
   */
  private BigDecimal priceToFreeCashFlowsRatioTTM;

  /**
   * Price-to-Operating Cash Flows Ratio (TTM) - Evaluates the market value of a company relative to
   * its operating cash flows. Formula: Price-to-Operating Cash Flows Ratio = Stock Price /
   * Operating Cash Flow per Share
   *
   * @see <a
   *     href="https://www.investopedia.com/terms/p/price-to-operatingcashflowsratio.asp">Investopedia
   *     - Price-to-Operating Cash Flows Ratio</a>
   */
  private BigDecimal priceToOperatingCashFlowsRatioTTM;

  /**
   * Price/Cash Flow Ratio (TTM) - Measures the market value of a company relative to its cash
   * flows. Formula: Price/Cash Flow Ratio = Stock Price / Cash Flow per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-cash-flowratio.asp">Investopedia -
   *     Price/Cash Flow Ratio</a>
   */
  private BigDecimal priceCashFlowRatioTTM;

  /**
   * Price/Earnings-to-Growth Ratio (TTM) - Evaluates the market value of a company relative to its
   * earnings growth. Formula: Price/Earnings-to-Growth Ratio = Price/Earnings Ratio / Earnings
   * Growth Rate
   *
   * @see <a href="https://www.investopedia.com/terms/p/pegratio.asp">Investopedia -
   *     Price/Earnings-to-Growth Ratio (PEG Ratio)</a>
   */
  private BigDecimal priceEarningsToGrowthRatioTTM;

  /**
   * Price/Sales Ratio (TTM) - Measures the market value of a company relative to its sales.
   * Formula: Price/Sales Ratio = Stock Price / Revenue per Share
   *
   * @see <a href="https://www.investopedia.com/terms/p/price-to-salesratio.asp">Investopedia -
   *     Price/Sales Ratio</a>
   */
  private BigDecimal priceSalesRatioTTM;

  /**
   * Dividend Yield (TTM) - Represents the dividend income earned per share relative to the stock's
   * price. Formula: Dividend Yield = Dividends per Share / Stock Price
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividendyield.asp">Investopedia - Dividend
   *     Yield</a>
   */
  private BigDecimal dividendYieldTTM;

  /**
   * Enterprise Value Multiple (TTM) - Measures the total value of a company's operations relative
   * to its earnings. Formula: Enterprise Value Multiple = Enterprise Value / EBITDA
   *
   * @see <a href="https://www.investopedia.com/terms/e/enterprisevalue.asp">Investopedia -
   *     Enterprise Value</a>
   */
  private BigDecimal enterpriseValueMultipleTTM;

  /**
   * Price/Fair Value Ratio (TTM) - Evaluates the market value of a company relative to its fair
   * value. Formula: Price/Fair Value Ratio = Stock Price / Fair Value per Share
   *
   * @see <a href="https://www.investopedia.com/terms/f/fairvalue.asp">Investopedia - Fair Value</a>
   */
  private BigDecimal priceFairValueTTM;

  /**
   * Dividend per Share (TTM) - Represents the amount of dividends paid per share.
   *
   * @see <a href="https://www.investopedia.com/terms/d/dividends.asp">Investopedia - Dividends</a>
   */
  private BigDecimal dividendPerShareTTM;

  @Override
  public String toString() {
    return "RatiosTTM {"
        + "dividendYieldPercentageTTM="
        + dividenYieldPercentageTTM
        + ", peRatioTTM="
        + peRatioTTM
        + ", pegRatioTTM="
        + pegRatioTTM
        + ", payoutRatioTTM="
        + payoutRatioTTM
        + ", currentRatioTTM="
        + currentRatioTTM
        + ", quickRatioTTM="
        + quickRatioTTM
        + ", cashRatioTTM="
        + cashRatioTTM
        + ", daysOfSalesOutstandingTTM="
        + daysOfSalesOutstandingTTM
        + ", daysOfInventoryOutstandingTTM="
        + daysOfInventoryOutstandingTTM
        + ", operatingCycleTTM="
        + operatingCycleTTM
        + ", daysOfPayablesOutstandingTTM="
        + daysOfPayablesOutstandingTTM
        + ", cashConversionCycleTTM="
        + cashConversionCycleTTM
        + ", grossProfitMarginTTM="
        + grossProfitMarginTTM
        + ", operatingProfitMarginTTM="
        + operatingProfitMarginTTM
        + ", pretaxProfitMarginTTM="
        + pretaxProfitMarginTTM
        + ", netProfitMarginTTM="
        + netProfitMarginTTM
        + ", effectiveTaxRateTTM="
        + effectiveTaxRateTTM
        + ", returnOnAssetsTTM="
        + returnOnAssetsTTM
        + ", returnOnEquityTTM="
        + returnOnEquityTTM
        + ", returnOnCapitalEmployedTTM="
        + returnOnCapitalEmployedTTM
        + ", netIncomePerEBTTTM="
        + netIncomePerEBTTTM
        + ", ebtPerEbitTTM="
        + ebtPerEbitTTM
        + ", ebitPerRevenueTTM="
        + ebitPerRevenueTTM
        + ", debtRatioTTM="
        + debtRatioTTM
        + ", debtEquityRatioTTM="
        + debtEquityRatioTTM
        + ", longTermDebtToCapitalizationTTM="
        + longTermDebtToCapitalizationTTM
        + ", totalDebtToCapitalizationTTM="
        + totalDebtToCapitalizationTTM
        + ", interestCoverageTTM="
        + interestCoverageTTM
        + ", cashFlowToDebtRatioTTM="
        + cashFlowToDebtRatioTTM
        + ", companyEquityMultiplierTTM="
        + companyEquityMultiplierTTM
        + ", receivablesTurnoverTTM="
        + receivablesTurnoverTTM
        + ", payablesTurnoverTTM="
        + payablesTurnoverTTM
        + ", inventoryTurnoverTTM="
        + inventoryTurnoverTTM
        + ", fixedAssetTurnoverTTM="
        + fixedAssetTurnoverTTM
        + ", assetTurnoverTTM="
        + assetTurnoverTTM
        + ", operatingCashFlowPerShareTTM="
        + operatingCashFlowPerShareTTM
        + ", freeCashFlowPerShareTTM="
        + freeCashFlowPerShareTTM
        + ", cashPerShareTTM="
        + cashPerShareTTM
        + ", operatingCashFlowSalesRatioTTM="
        + operatingCashFlowSalesRatioTTM
        + ", freeCashFlowOperatingCashFlowRatioTTM="
        + freeCashFlowOperatingCashFlowRatioTTM
        + ", cashFlowCoverageRatiosTTM="
        + cashFlowCoverageRatiosTTM
        + ", shortTermCoverageRatiosTTM="
        + shortTermCoverageRatiosTTM
        + ", capitalExpenditureCoverageRatioTTM="
        + capitalExpenditureCoverageRatioTTM
        + ", dividendPaidAndCapexCoverageRatioTTM="
        + dividendPaidAndCapexCoverageRatioTTM
        + ", priceBookValueRatioTTM="
        + priceBookValueRatioTTM
        + ", priceToBookRatioTTM="
        + priceToBookRatioTTM
        + ", priceToSalesRatioTTM="
        + priceToSalesRatioTTM
        + ", priceEarningsRatioTTM="
        + priceEarningsRatioTTM
        + ", priceToFreeCashFlowsRatioTTM="
        + priceToFreeCashFlowsRatioTTM
        + ", priceToOperatingCashFlowsRatioTTM="
        + priceToOperatingCashFlowsRatioTTM
        + ", priceCashFlowRatioTTM="
        + priceCashFlowRatioTTM
        + ", priceEarningsToGrowthRatioTTM="
        + priceEarningsToGrowthRatioTTM
        + ", priceSalesRatioTTM="
        + priceSalesRatioTTM
        + ", dividendYieldTTM="
        + dividendYieldTTM
        + ", enterpriseValueMultipleTTM="
        + enterpriseValueMultipleTTM
        + ", priceFairValueTTM="
        + priceFairValueTTM
        + ", dividendPerShareTTM="
        + dividendPerShareTTM
        + '}';
  }
}
