package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVCashFlows;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowsEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper.AVCashFlowsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AVCashFlowsRepository {
    private final AVCashFlowsCrudRepository crudRepository;
    private final AVCashFlowsMapper mapper;

    public Optional<AVCashFlows> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public AVCashFlows saveOrUpdate(AVCashFlows dto) {
        Optional<AVCashFlowsEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        AVCashFlowsEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
