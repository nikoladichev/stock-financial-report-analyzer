package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowsEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVCashFlowsMapper {
    AVCashFlows entityToDto(AVCashFlowsEntity entity);

    AVCashFlows mergeEntityToDto(AVCashFlowsEntity entity, @MappingTarget AVCashFlows dto);

    AVCashFlowsEntity dtoToEntity(AVCashFlows dto);

    AVCashFlowsEntity mergeDtoToEntity(AVCashFlows dto, @MappingTarget AVCashFlowsEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget AVCashFlowsEntity entity, AVCashFlows dto) {
        List<AVCashFlowEntity> annualReports = entity.getAnnualReports();
        List<AVCashFlowEntity> quarterlyReports = entity.getQuarterlyReports();

        for (AVCashFlowEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (AVCashFlowEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
