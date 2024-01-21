package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.persistence.entity.IncomeStatementEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IncomeStatementCrudRepository extends CrudRepository<IncomeStatementEntity, String> {
    List<IncomeStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<IncomeStatementEntity> findAllBySymbol(String symbol);
}