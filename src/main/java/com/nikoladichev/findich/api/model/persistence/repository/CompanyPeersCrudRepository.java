package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.persistence.entity.CompanyPeersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyPeersCrudRepository extends CrudRepository<CompanyPeersEntity, String> {
    Optional<CompanyPeersEntity> findBySymbol(String symbol);
}