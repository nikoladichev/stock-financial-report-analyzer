package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import java.util.List;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.CashFlowStatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashFlowStatementCrudRepository extends JpaRepository<CashFlowStatementEntity, String> {
    List<CashFlowStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<CashFlowStatementEntity> findAllBySymbol(String symbol);
}