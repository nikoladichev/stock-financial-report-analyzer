package com.nikoladichev.financialreportanalyzer.persistence.repository;

import com.nikoladichev.financialreportanalyzer.persistence.CashFlowReportEntity;
import com.nikoladichev.financialreportanalyzer.persistence.IncomeStatementReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface IncomeStatementReportCrudRepository extends CrudRepository<IncomeStatementReportEntity, String> {
    Optional<IncomeStatementReportEntity> findBySymbol(String symbol);
}
