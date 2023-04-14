package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.CashFlowReport;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.IncomeStatementReport;
import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.mapper.IncomeStatementReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IncomeStatementReportRepository {
    private final IncomeStatementReportCrudRepository crudRepository;
    private final IncomeStatementReportMapper mapper;

    public Optional<IncomeStatementReport> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public IncomeStatementReport saveOrUpdate(IncomeStatementReport dto) {
        Optional<IncomeStatementReportEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        IncomeStatementReportEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
