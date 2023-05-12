package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatement;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVIncomeStatementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVIncomeStatementMapper {
    AVIncomeStatement entityToDto(AVIncomeStatementEntity entity);

    AVIncomeStatement mergeEntityToDto(AVIncomeStatementEntity entity, @MappingTarget AVIncomeStatement dto);

    AVIncomeStatementEntity dtoToEntity(AVIncomeStatement dto, String symbol);

    AVIncomeStatementEntity mergeDtoToEntity(AVIncomeStatement dto, String symbol, @MappingTarget AVIncomeStatementEntity entity);
}
