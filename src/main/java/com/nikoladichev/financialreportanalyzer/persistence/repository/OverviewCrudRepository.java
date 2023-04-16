package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportEntity;

import java.util.List;
import java.util.Optional;

import com.nikoladichev.financialreportanalyzer.persistence.OverviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OverviewCrudRepository extends CrudRepository<OverviewEntity, String> {
    Optional<OverviewEntity> findBySymbol(String symbol);

    List<OverviewEntity> findAllBySector(String sector);

    List<OverviewEntity> findAllByIndustry(String industry);

    List<OverviewEntity> findAllBySectorAndIndustry(String sector, String industry);
}
