package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVIncomeStatementsEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVIncomeStatementEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVIncomeStatementsMapper {
    AVIncomeStatements entityToDto(AVIncomeStatementsEntity entity);

    AVIncomeStatements mergeEntityToDto(AVIncomeStatementsEntity entity, @MappingTarget AVIncomeStatements dto);

    AVIncomeStatementsEntity dtoToEntity(AVIncomeStatements dto);

    AVIncomeStatementsEntity mergeDtoToEntity(AVIncomeStatements dto, @MappingTarget AVIncomeStatementsEntity entity);

    @AfterMapping
    default void afterMapping(@MappingTarget AVIncomeStatementsEntity entity, AVIncomeStatements dto) {
        List<AVIncomeStatementEntity> annualReports = entity.getAnnualReports();
        List<AVIncomeStatementEntity> quarterlyReports = entity.getQuarterlyReports();

        for (AVIncomeStatementEntity report : annualReports) {
            report.setSymbol(dto.getSymbol());
        }

        for (AVIncomeStatementEntity report: quarterlyReports) {
            report.setSymbol(dto.getSymbol());
        }
    }
}
