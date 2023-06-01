package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.integration.fmp.Stock;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.StockEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockMapper {
  StockEntity dtoToEntity(Stock dto);

  @Mapping(target = "symbol", ignore = true)
  @Mapping(target = "companyName", ignore = true)
  @Mapping(target = "sector", ignore = true)
  @Mapping(target = "industry", ignore = true)
  @Mapping(target = "exchange", ignore = true)
  @Mapping(target = "exchangeShortName", ignore = true)
  @Mapping(target = "country", ignore = true)
  @Mapping(target = "isEtf", ignore = true)
  void updateEntityFromDto(Stock dto, @MappingTarget StockEntity entity);

  Stock entityToDto(StockEntity stockEntity);
}
