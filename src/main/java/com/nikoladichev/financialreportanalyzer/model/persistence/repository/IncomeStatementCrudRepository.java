package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.IncomeStatementEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeStatementCrudRepository extends JpaRepository<IncomeStatementEntity, String> {
    List<IncomeStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<IncomeStatementEntity> findAllBySymbol(String symbol);
}