package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.BalanceSheetStatementEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceSheetStatementCrudRepository extends JpaRepository<BalanceSheetStatementEntity, String> {
    List<BalanceSheetStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<BalanceSheetStatementEntity> findAllBySymbol(String symbol);
}