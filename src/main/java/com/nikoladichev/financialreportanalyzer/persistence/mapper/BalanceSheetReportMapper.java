package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.persistence.BalanceSheetReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.BalanceSheetReportItemEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BalanceSheetReportMapper {
    BalanceSheetReport entityToDto(BalanceSheetReportEntity entity);

    BalanceSheetReport mergeEntityToDto(BalanceSheetReportEntity entity, @MappingTarget BalanceSheetReport dto);

    BalanceSheetReportEntity dtoToEntity(BalanceSheetReport dto);

    BalanceSheetReportEntity mergeDtoToEntity(BalanceSheetReport dto, @MappingTarget BalanceSheetReportEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget BalanceSheetReportEntity entity, BalanceSheetReport dto) {
        List<BalanceSheetReportItemEntity> annualReports = entity.getAnnualReports();
        List<BalanceSheetReportItemEntity> quarterlyReports = entity.getQuarterlyReports();

        for (BalanceSheetReportItemEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (BalanceSheetReportItemEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
