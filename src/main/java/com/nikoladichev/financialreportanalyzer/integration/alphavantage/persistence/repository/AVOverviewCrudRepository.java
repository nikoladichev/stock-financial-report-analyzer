package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVOverviewEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AVOverviewCrudRepository extends CrudRepository<AVOverviewEntity, String> {
    Optional<AVOverviewEntity> findBySymbol(String symbol);

    List<AVOverviewEntity> findAllBySector(String sector);

    List<AVOverviewEntity> findAllByIndustry(String industry);

    List<AVOverviewEntity> findAllBySectorAndIndustry(String sector, String industry);
}
