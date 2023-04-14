package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReportItem;
import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IncomeStatementReportItemMapper {
    IncomeStatementReportItem entityToDto(IncomeStatementReportItemEntity entity);

    IncomeStatementReportItem mergeEntityToDto(IncomeStatementReportItemEntity entity, @MappingTarget IncomeStatementReportItem dto);

    IncomeStatementReportItemEntity dtoToEntity(IncomeStatementReportItem dto, String symbol);

    IncomeStatementReportItemEntity mergeDtoToEntity(IncomeStatementReportItem dto, String symbol, @MappingTarget IncomeStatementReportItemEntity entity);
}
