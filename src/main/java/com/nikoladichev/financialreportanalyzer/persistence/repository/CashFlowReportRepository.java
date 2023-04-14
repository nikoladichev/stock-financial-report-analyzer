package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.mapper.CashFlowReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CashFlowReportRepository {
    private final CashFlowReportCrudRepository crudRepository;
    private final CashFlowReportMapper mapper;

    public Optional<CashFlowReport> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public CashFlowReport saveOrUpdate(CashFlowReport dto) {
        Optional<CashFlowReportEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        CashFlowReportEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
