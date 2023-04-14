package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface CashFlowReportCrudRepository extends CrudRepository<CashFlowReportEntity, String> {
    Optional<CashFlowReportEntity> findBySymbol(String symbol);
}
