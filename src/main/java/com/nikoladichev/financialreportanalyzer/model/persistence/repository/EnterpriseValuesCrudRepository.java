package com.nikoladichev.financialreportanalyzer.model.persistence.repository;

import com.nikoladichev.financialreportanalyzer.model.persistence.entity.EnterpriseValuesEntity;
import com.nikoladichev.financialreportanalyzer.model.persistence.entity.RatiosEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseValuesCrudRepository extends JpaRepository<EnterpriseValuesEntity, String> {
    List<EnterpriseValuesEntity> findAllBySymbol(String symbol);
}