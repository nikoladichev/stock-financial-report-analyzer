package com.nikoladichev.findich.api.controller;

import com.nikoladichev.findich.api.model.fundamentals.CompanyPeers;
import com.nikoladichev.findich.api.service.CompanyPeersService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{symbol}/peers")
@RequiredArgsConstructor
public class PeersController {

  private final CompanyPeersService service;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public Set<CompanyPeers> getPeers(@PathVariable String symbol) {
    return service.getCompanyPeers(symbol);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping
  public void addPeers(@PathVariable String symbol, @RequestBody Set<String> peers) {
    service.addCompanyPeers(symbol, peers);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping
  public void removePeers(@PathVariable String symbol, @RequestBody Set<String> peers) {
    service.removeCompanyPeers(symbol, peers);
  }
}
