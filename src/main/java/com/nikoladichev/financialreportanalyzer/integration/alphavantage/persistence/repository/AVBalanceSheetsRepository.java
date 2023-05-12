package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVBalanceSheets;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVBalanceSheetsEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper.AVBalanceSheetsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AVBalanceSheetsRepository {
    private final AVBalanceSheetsCrudRepository crudRepository;
    private final AVBalanceSheetsMapper mapper;

    public Optional<AVBalanceSheets> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public AVBalanceSheets saveOrUpdate(AVBalanceSheets dto) {
        Optional<AVBalanceSheetsEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        AVBalanceSheetsEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
