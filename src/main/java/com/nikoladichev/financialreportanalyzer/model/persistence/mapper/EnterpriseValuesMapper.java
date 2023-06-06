package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.EnterpriseValues;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.EnterpriseValuesEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnterpriseValuesMapper {
  EnterpriseValuesEntity dtoToEntity(EnterpriseValues dto);

  EnterpriseValues entityToDto(EnterpriseValuesEntity entity);
}
