package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.persistence.entity.CompanyProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyProfileCrudRepository extends CrudRepository<CompanyProfileEntity, String> {
}