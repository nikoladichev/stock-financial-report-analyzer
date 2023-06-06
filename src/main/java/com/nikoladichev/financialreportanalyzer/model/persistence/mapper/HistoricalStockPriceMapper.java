package com.nikoladichev.financialreportanalyzer.model.persistence.mapper;

import com.nikoladichev.financialreportanalyzer.model.fundamentals.HistoricalStockPrice;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.ratios.Ratios;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.HistoricalStockPriceEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HistoricalStockPriceMapper {

  HistoricalStockPriceEntity dtoToEntity(String symbol, HistoricalStockPrice.HistoricalData dto);

  HistoricalStockPrice.HistoricalData entityToDto(HistoricalStockPriceEntity entity);

  default List<HistoricalStockPriceEntity> dtoToEntityList(HistoricalStockPrice dto) {
    List<HistoricalStockPriceEntity> entities = new ArrayList<>();

    for (HistoricalStockPrice.HistoricalData historicalData : dto.getHistorical()) {
      entities.add(this.dtoToEntity(dto.getSymbol(), historicalData));
    }

    return entities;
  }

  default HistoricalStockPrice entityListToDto(List<HistoricalStockPriceEntity> entities) {
    if (entities.size() == 0) {
      return null;
    }

    String symbol = entities.get(0).getSymbol();
    List<HistoricalStockPrice.HistoricalData> historicalData = new ArrayList<>();

    for (var entity : entities) {
      if (!Objects.equals(symbol, entity.getSymbol())) {
        // TODO - this exception should be a MappingException which extends RuntimeException
        throw new RuntimeException(
            "Can't create HistoricalStockPrice from entities because they belong to different symbols!");
      }
      historicalData.add(entityToDto(entity));
    }

    return HistoricalStockPrice.builder().symbol(symbol).historical(historicalData).build();
  }
}
