package com.nikoladichev.financialreportanalyzer.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.Overview;
import com.nikoladichev.financialreportanalyzer.persistence.OverviewEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OverviewMapper {

    List<Overview> entityListToDtoList(List<OverviewEntity> entityList);

    Overview entityToDto(OverviewEntity entity);

    Overview mergeEntityToDto(OverviewEntity entity, @MappingTarget Overview dto);

    OverviewEntity dtoToEntity(Overview dto);

    OverviewEntity mergeDtoToEntity(Overview dto, @MappingTarget OverviewEntity entity);
}
