package com.nikoladichev.financialreportanalyzer.integration.fmp.response.mapper;

import com.nikoladichev.financialreportanalyzer.integration.fmp.response.RatiosTTM;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RatiosTTMMapper {
  @Mapping(target = "receivablesTurnover", source = "receivablesTurnoverTTM")
  @Mapping(target = "payablesTurnover", source = "payablesTurnoverTTM")
  @Mapping(target = "inventoryTurnover", source = "inventoryTurnoverTTM")
  @Mapping(target = "grossProfitMargin", source = "grossProfitMarginTTM")
  @Mapping(target = "operatingProfitMargin", source = "operatingProfitMarginTTM")
  @Mapping(target = "netProfitMargin", source = "netProfitMarginTTM")
  @Mapping(target = "returnOnAssets", source = "returnOnAssetsTTM")
  @Mapping(target = "returnOnEquity", source = "returnOnEquityTTM")
  @Mapping(target = "currentRatio", source = "currentRatioTTM")
  @Mapping(target = "quickRatio", source = "quickRatioTTM")
  @Mapping(target = "cashRatio", source = "debtRatioTTM")
  @Mapping(target = "debtRatio", source = "debtRatioTTM")
  @Mapping(target = "debtEquityRatio", source = "debtEquityRatioTTM")
  @Mapping(target = "interestCoverage", source = "interestCoverageTTM")
  @Mapping(target = "operatingCashFlowPerShare", source = "operatingCashFlowPerShareTTM")
  @Mapping(target = "freeCashFlowPerShare", source = "freeCashFlowPerShareTTM")
  @Mapping(target = "cashFlowToDebtRatio", source = "cashFlowToDebtRatioTTM")
  @Mapping(target = "priceToBookRatio", source = "priceToBookRatioTTM")
  @Mapping(target = "priceToSalesRatio", source = "priceToSalesRatioTTM")
  @Mapping(target = "priceEarningsRatio", source = "priceEarningsRatioTTM")
  @Mapping(target = "priceToFreeCashFlowsRatio", source = "priceToFreeCashFlowsRatioTTM")
  @Mapping(target = "priceToOperatingCashFlowsRatio", source = "priceToOperatingCashFlowsRatioTTM")
  @Mapping(target = "priceCashFlowRatio", source = "priceCashFlowRatioTTM")
  @Mapping(target = "dividendYield", source = "enterpriseValueMultipleTTM")
  @Mapping(target = "enterpriseValueMultiple", source = "enterpriseValueMultipleTTM")
  @Mapping(target = "priceFairValue", source = "priceFairValueTTM")
//  @Mapping(target = "isTTM", defaultValue = "true")
  Ratios normalize(RatiosTTM ratiosTTM);
}
