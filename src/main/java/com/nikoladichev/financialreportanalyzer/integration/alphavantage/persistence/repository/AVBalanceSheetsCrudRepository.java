package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVBalanceSheetsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface AVBalanceSheetsCrudRepository extends CrudRepository<AVBalanceSheetsEntity, String> {
    Optional<AVBalanceSheetsEntity> findBySymbol(String symbol);
}
