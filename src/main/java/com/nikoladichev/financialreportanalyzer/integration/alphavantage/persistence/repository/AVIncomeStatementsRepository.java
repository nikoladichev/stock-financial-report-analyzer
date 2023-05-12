package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVIncomeStatements;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVIncomeStatementsEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper.AVIncomeStatementsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AVIncomeStatementsRepository {
    private final AVIncomeStatementsCrudRepository crudRepository;
    private final AVIncomeStatementsMapper mapper;

    public Optional<AVIncomeStatements> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public AVIncomeStatements saveOrUpdate(AVIncomeStatements dto) {
        Optional<AVIncomeStatementsEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        AVIncomeStatementsEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
