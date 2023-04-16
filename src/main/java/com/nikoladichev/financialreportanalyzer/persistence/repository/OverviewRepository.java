package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.dto.fundamentals.Overview;
import com.nikoladichev.financialreportanalyzer.persistence.OverviewEntity;
import com.nikoladichev.financialreportanalyzer.persistence.mapper.OverviewMapper;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OverviewRepository {
    private final OverviewCrudRepository crudRepository;
    private final OverviewMapper mapper;

    public Optional<Overview> findBySymbol(String symbol) {
        return crudRepository.findBySymbol(symbol).map(mapper::entityToDto);
    }

    public Overview saveOrUpdate(Overview dto) {
        Optional<OverviewEntity> entityOptional = crudRepository.findById(dto.getSymbol());
        OverviewEntity entity;
        if (entityOptional.isPresent()) {
            entity = mapper.mergeDtoToEntity(dto, entityOptional.get());
        } else {
            entity = mapper.dtoToEntity(dto);
        }

        entity = crudRepository.save(entity);

        return mapper.entityToDto(entity);
    }

    public List<Overview> findAllBySectorAndIndustry(String sector, String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllBySectorAndIndustry(sector, industry));
    }

    public List<Overview> findAllBySector(String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllBySector(industry));
    }

    public List<Overview> findAllByIndustry(String industry) {
        return mapper.entityListToDtoList(crudRepository.findAllByIndustry(industry));
    }
}
