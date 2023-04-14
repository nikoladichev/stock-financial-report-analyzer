package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.BalanceSheetReport;
import com.nikoladichev.financialreportanalyzer.persistence.BalanceSheetReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.mapper.BalanceSheetReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BalanceSheetReportRepository {
    private final BalanceSheetReportCrudRepository crudRepository;
    private final BalanceSheetReportMapper mapper;

    public Optional<BalanceSheetReport> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public BalanceSheetReport saveOrUpdate(BalanceSheetReport dto) {
        Optional<BalanceSheetReportEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        BalanceSheetReportEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }
}
