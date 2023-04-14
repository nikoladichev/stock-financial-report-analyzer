package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.persistence.BalanceSheetReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BalanceSheetReportCrudRepository extends CrudRepository<BalanceSheetReportEntity, String> {
    Optional<BalanceSheetReportEntity> findBySymbol(String symbol);
}
