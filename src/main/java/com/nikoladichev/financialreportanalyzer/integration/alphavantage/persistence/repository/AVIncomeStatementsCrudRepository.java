package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVIncomeStatementsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface AVIncomeStatementsCrudRepository extends CrudRepository<AVIncomeStatementsEntity, String> {
    Optional<AVIncomeStatementsEntity> findBySymbol(String symbol);
}
