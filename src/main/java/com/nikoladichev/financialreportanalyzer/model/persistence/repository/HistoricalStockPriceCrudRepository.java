package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.HistoricalStockPriceEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalStockPriceCrudRepository extends JpaRepository<HistoricalStockPriceEntity, String> {
    List<HistoricalStockPriceEntity> findAllBySymbol(String symbol);

    // TODO - should be able to group by date!
}