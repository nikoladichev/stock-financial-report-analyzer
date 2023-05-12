package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVOverview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVOverviewEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AVOverviewMapper {

    List<AVOverview> entityListToDtoList(List<AVOverviewEntity> entityList);

    AVOverview entityToDto(AVOverviewEntity entity);

    AVOverview mergeEntityToDto(AVOverviewEntity entity, @MappingTarget AVOverview dto);

    AVOverviewEntity dtoToEntity(AVOverview dto);

    AVOverviewEntity mergeDtoToEntity(AVOverview dto, @MappingTarget AVOverviewEntity entity);
}
