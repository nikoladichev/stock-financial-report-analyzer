package com.nikoladichev.findich.api.model.persistence.mapper;

import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyProfileEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyProfileMapper {

  CompanyProfileEntity dtoToEntity(CompanyProfile dto, String date);

  @Mapping(target = "range", expression = "java(entity.getRangeMin() + \"-\" + entity.getRangeMax())")
  CompanyProfile entityToDto(CompanyProfileEntity entity);
}
