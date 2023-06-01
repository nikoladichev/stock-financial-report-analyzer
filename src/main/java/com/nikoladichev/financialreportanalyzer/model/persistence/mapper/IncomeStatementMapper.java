package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.IncomeStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeStatementMapper {
  IncomeStatementEntity dtoToEntity(IncomeStatement dto);

  IncomeStatement entityToDto(IncomeStatementEntity entity);
}
