package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.BalanceSheetStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BalanceSheetStatementMapper {
  BalanceSheetStatementEntity dtoToEntity(BalanceSheetStatement dto);

  BalanceSheetStatement entityToDto(BalanceSheetStatementEntity entity);
}
