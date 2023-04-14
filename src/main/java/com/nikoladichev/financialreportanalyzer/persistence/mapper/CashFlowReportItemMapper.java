package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReportItem;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportItemEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CashFlowReportItemMapper {
    CashFlowReportItem entityToDto(CashFlowReportItemEntity entity);

    CashFlowReportItem mergeEntityToDto(CashFlowReportItemEntity entity, @MappingTarget CashFlowReportItem dto);

    CashFlowReportItemEntity dtoToEntity(CashFlowReportItem dto, String symbol);

    CashFlowReportItemEntity mergeDtoToEntity(CashFlowReportItem dto, String symbol, @MappingTarget CashFlowReportItemEntity entity);
}
