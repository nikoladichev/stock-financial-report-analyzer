package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.persistence.entity.CashFlowStatementEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CashFlowStatementCrudRepository extends CrudRepository<CashFlowStatementEntity, String> {
    List<CashFlowStatementEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<CashFlowStatementEntity> findAllBySymbol(String symbol);
}