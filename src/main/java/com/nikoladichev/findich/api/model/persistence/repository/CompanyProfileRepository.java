package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.common.DateFormatter;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyProfileEntity;
import com.nikoladichev.findich.api.model.persistence.mapper.CompanyProfileMapper;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyProfileRepository {
  private final CompanyProfileCrudRepository crudRepository;
  private final CompanyProfileMapper mapper;

  public CompanyProfile findBySymbol(String symbol) {
    Optional<CompanyProfileEntity> entity = crudRepository.findById(symbol);
    if (entity.isPresent()
        && !Objects.equals(entity.get().getDate(), DateFormatter.format(LocalDate.now()))) {
      return mapper.entityToDto(entity.get());
    }

    return null;
  }

  public CompanyProfile save(CompanyProfile companyProfile) {
   crudRepository.findById(companyProfile.getSymbol()).ifPresent(crudRepository::delete);

    var companyProfileEntity = mapper.dtoToEntity(companyProfile, DateFormatter.format(LocalDate.now()));
    return mapper.entityToDto(crudRepository.save(companyProfileEntity));
  }
}
