package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.persistence.entity.BalanceSheetStatementEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BalanceSheetStatementCrudRepository extends CrudRepository<BalanceSheetStatementEntity, String> {
    List<BalanceSheetStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<BalanceSheetStatementEntity> findAllBySymbol(String symbol);
}