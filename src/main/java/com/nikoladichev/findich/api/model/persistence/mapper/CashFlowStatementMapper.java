package com.nikoladichev.findich.api.model.persistence.mapper;

import com.nikoladichev.findich.api.model.fundamentals.statements.CashFlowStatement;
import com.nikoladichev.findich.api.model.persistence.entity.CashFlowStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CashFlowStatementMapper {

//  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
  CashFlowStatementEntity dtoToEntity(CashFlowStatement dto);

  CashFlowStatement entityToDto(CashFlowStatementEntity entity);
}
