package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlow;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVCashFlowReportMapper {
    @Mapping(target = "fiscalDateEnding", source = "fiscalDateEnding")
    AVCashFlow entityToDto(AVCashFlowEntity entity);

    AVCashFlow mergeEntityToDto(AVCashFlowEntity entity, @MappingTarget AVCashFlow dto);

    AVCashFlowEntity dtoToEntity(AVCashFlow dto, String symbol);

    AVCashFlowEntity mergeDtoToEntity(AVCashFlow dto, String symbol, @MappingTarget AVCashFlowEntity entity);
}
