package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.CashFlowStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CashFlowStatementMapper {
  CashFlowStatementEntity dtoToEntity(CashFlowStatement dto);

  CashFlowStatement entityToDto(CashFlowStatementEntity entity);
}
