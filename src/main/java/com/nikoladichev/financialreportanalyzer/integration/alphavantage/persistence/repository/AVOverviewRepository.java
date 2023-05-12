package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.AVOverview;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVOverviewEntity;
import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.mapper.AVOverviewMapper;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AVOverviewRepository {
    private final AVOverviewCrudRepository crudRepository;
    private final AVOverviewMapper mapper;

    public Optional<AVOverview> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public AVOverview saveOrUpdate(AVOverview dto) {
        Optional<AVOverviewEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        AVOverviewEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }

    public List<AVOverview> findAllBySectorAndIndustry(String sector, String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllBySectorAndIndustry(sector, industry));
    }

    public List<AVOverview> findAllBySector(String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllBySector(industry));
    }

    public List<AVOverview> findAllByIndustry(String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllByIndustry(industry));
    }
}
