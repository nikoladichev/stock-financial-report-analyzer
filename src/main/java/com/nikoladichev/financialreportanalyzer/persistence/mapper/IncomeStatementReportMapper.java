package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportItemEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IncomeStatementReportMapper {
    IncomeStatementReport entityToDto(IncomeStatementReportEntity entity);

    IncomeStatementReport mergeEntityToDto(IncomeStatementReportEntity entity, @MappingTarget IncomeStatementReport dto);

    IncomeStatementReportEntity dtoToEntity(IncomeStatementReport dto);

    IncomeStatementReportEntity mergeDtoToEntity(IncomeStatementReport dto, @MappingTarget IncomeStatementReportEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget IncomeStatementReportEntity entity, IncomeStatementReport dto) {
        List<IncomeStatementReportItemEntity> annualReports = entity.getAnnualReports();
        List<IncomeStatementReportItemEntity> quarterlyReports = entity.getQuarterlyReports();

        for (IncomeStatementReportItemEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (IncomeStatementReportItemEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
