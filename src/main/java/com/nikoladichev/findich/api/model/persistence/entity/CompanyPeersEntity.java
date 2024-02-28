package com.nikoladichev.findich.api.model.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "peers")
public class CompanyPeersEntity {
  @Id
  private String symbol;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "company_peers",
      joinColumns = @JoinColumn(name = "symbol_id"),
      inverseJoinColumns = @JoinColumn(name = "peer_symbol_id"))
  private Set<CompanyPeersEntity> peers = new HashSet<>();
}
