package com.nikoladichev.findich.api.model.persistence.repository;

import com.nikoladichev.findich.api.model.common.DateFormatter;
import com.nikoladichev.findich.api.model.fundamentals.CompanyPeers;
import com.nikoladichev.findich.api.model.fundamentals.CompanyProfile;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyPeersEntity;
import com.nikoladichev.findich.api.model.persistence.entity.CompanyProfileEntity;
import com.nikoladichev.findich.api.model.persistence.mapper.CompanyPeersMapper;
import com.nikoladichev.findich.api.model.persistence.mapper.CompanyProfileMapper;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyPeersRepository {
  private final CompanyPeersCrudRepository crudRepository;
  private final CompanyPeersMapper mapper;

  public CompanyPeers findBySymbol(String symbol) {
    Optional<CompanyPeersEntity> entity = crudRepository.findBySymbol(symbol);
    return entity.map(mapper::entityToDto).orElse(null);
  }

  public CompanyPeers save(CompanyPeers companyPeers) {
    var entity = mapper.dtoToEntity(companyPeers);
    return mapper.entityToDto(crudRepository.save(entity));
  }
}
