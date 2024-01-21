package com.nikoladichev.findich.api.model.persistence.mapper;

import com.nikoladichev.findich.api.model.fundamentals.statements.IncomeStatement;
import com.nikoladichev.findich.api.model.persistence.entity.IncomeStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeStatementMapper {

  // TODO - revise this - for now ok, but when adding new ones might be problematic
//  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
  IncomeStatementEntity dtoToEntity(IncomeStatement dto);

  IncomeStatement entityToDto(IncomeStatementEntity entity);
}
