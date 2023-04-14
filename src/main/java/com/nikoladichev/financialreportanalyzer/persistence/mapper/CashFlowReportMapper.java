package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportItemEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CashFlowReportMapper {
    CashFlowReport entityToDto(CashFlowReportEntity entity);

    CashFlowReport mergeEntityToDto(CashFlowReportEntity entity, @MappingTarget CashFlowReport dto);

    CashFlowReportEntity dtoToEntity(CashFlowReport dto);

    CashFlowReportEntity mergeDtoToEntity(CashFlowReport dto, @MappingTarget CashFlowReportEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget CashFlowReportEntity entity, CashFlowReport dto) {
        List<CashFlowReportItemEntity> annualReports = entity.getAnnualReports();
        List<CashFlowReportItemEntity> quarterlyReports = entity.getQuarterlyReports();

        for (CashFlowReportItemEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (CashFlowReportItemEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
