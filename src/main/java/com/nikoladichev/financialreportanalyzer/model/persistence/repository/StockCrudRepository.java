package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockCrudRepository extends JpaRepository<StockEntity, String> {
    List<StockEntity> findByIsEtf(boolean isEtf);

    StockEntity findBySymbol(String symbol);

    List<StockEntity> findBySector(String sector);

    List<StockEntity> findByIndustry(String industry);

    List<StockEntity> findByExchange(String exchange);

    List<StockEntity> findBySectorAndIndustry(String sector, String industry);
}