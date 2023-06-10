package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.HistoricalStockPriceEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalStockPriceCrudRepository extends JpaRepository<HistoricalStockPriceEntity, String> {
    List<HistoricalStockPriceEntity> findAllBySymbol(String symbol);

    @Query("SELECT MAX(hsp.date) FROM HistoricalStockPriceEntity hsp where hsp.symbol = :symbol")
    Optional<LocalDate> findLastDateFilling(String symbol);

    // TODO - should be able to group by date!
}