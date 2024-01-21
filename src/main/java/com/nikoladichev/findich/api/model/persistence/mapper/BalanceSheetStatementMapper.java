package com.nikoladichev.findich.api.model.persistence.mapper;

import com.nikoladichev.findich.api.model.fundamentals.statements.BalanceSheetStatement;
import com.nikoladichev.findich.api.model.persistence.entity.BalanceSheetStatementEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BalanceSheetStatementMapper {

//  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
  BalanceSheetStatementEntity dtoToEntity(BalanceSheetStatement dto);

  BalanceSheetStatement entityToDto(BalanceSheetStatementEntity entity);
}
