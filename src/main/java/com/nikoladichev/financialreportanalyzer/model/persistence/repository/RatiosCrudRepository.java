package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import java.util.List;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatiosCrudRepository extends JpaRepository<RatiosEntity, String> {
    List<RatiosEntity> findAllBySymbolAndPeriod(String symbol, String period);

    List<RatiosEntity> findAllBySymbol(String symbol);
}