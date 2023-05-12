package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheets;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVBalanceSheetEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVBalanceSheetsEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVBalanceSheetsMapper {
    AVBalanceSheets entityToDto(AVBalanceSheetsEntity entity);

    AVBalanceSheets mergeEntityToDto(AVBalanceSheetsEntity entity, @MappingTarget AVBalanceSheets dto);

    AVBalanceSheetsEntity dtoToEntity(AVBalanceSheets dto);

    AVBalanceSheetsEntity mergeDtoToEntity(AVBalanceSheets dto, @MappingTarget AVBalanceSheetsEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget AVBalanceSheetsEntity entity, AVBalanceSheets dto) {
        List<AVBalanceSheetEntity> annualReports = entity.getAnnualReports();
        List<AVBalanceSheetEntity> quarterlyReports = entity.getQuarterlyReports();

        for (AVBalanceSheetEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (AVBalanceSheetEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
