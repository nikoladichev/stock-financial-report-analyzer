package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheet;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVBalanceSheetEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVBalanceSheetMapper {
    @Mapping(target = "fiscalDateEnding")
    AVBalanceSheet entityToDto(AVBalanceSheetEntity entity);

    AVBalanceSheet mergeEntityToDto(AVBalanceSheetEntity entity, @MappingTarget AVBalanceSheet dto);

    AVBalanceSheetEntity dtoToEntity(AVBalanceSheet dto, String symbol);

    AVBalanceSheetEntity mergeDtoToEntity(AVBalanceSheet dto, String symbol, @MappingTarget AVBalanceSheetEntity entity);
}
