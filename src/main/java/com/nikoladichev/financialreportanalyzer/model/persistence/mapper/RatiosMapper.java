package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.IncomeStatementEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RatiosMapper {
  RatiosEntity dtoToEntity(Ratios dto);

  Ratios entityToDto(RatiosEntity entity);
}
