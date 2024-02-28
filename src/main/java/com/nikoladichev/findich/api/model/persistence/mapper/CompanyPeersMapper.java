package com.nikoladichev.findich.api.model.persistence.mapper;

import com.nikoladichev.findich.api.model.fundamentals.CompanyPeers;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyPeersEntity;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyProfileEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyPeersMapper {

  CompanyPeersEntity dtoToEntity(CompanyPeers dto);

  CompanyPeers entityToDto(CompanyPeersEntity entity);
}
