package com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.repository;

import com.nikoladichev.financialreportanalyzer.integration.alphavantage.persistence.AVCashFlowsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface AVCashFlowsCrudRepository extends CrudRepository<AVCashFlowsEntity, String> {
    Optional<AVCashFlowsEntity> findBySymbol(String symbol);
}
