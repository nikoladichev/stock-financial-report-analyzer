package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReportItem;
import com.nikoladichev.financialreportanalyzer.persistence.BalanceSheetReportItemEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BalanceSheetReportItemMapper {
    @Mapping(target = "fiscalDateEnding")
    BalanceSheetReportItem entityToDto(BalanceSheetReportItemEntity entity);

    BalanceSheetReportItem mergeEntityToDto(BalanceSheetReportItemEntity entity, @MappingTarget BalanceSheetReportItem dto);

    BalanceSheetReportItemEntity dtoToEntity(BalanceSheetReportItem dto, String symbol);

    BalanceSheetReportItemEntity mergeDtoToEntity(BalanceSheetReportItem dto, String symbol, @MappingTarget BalanceSheetReportItemEntity entity);
}
