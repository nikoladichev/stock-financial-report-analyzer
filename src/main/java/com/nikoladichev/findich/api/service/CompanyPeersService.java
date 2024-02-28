package com.nikoladichev.findich.api.service;

import com.nikoladichev.findich.api.model.fundamentals.CompanyPeers;
import com.nikoladichev.findich.api.model.fundamentals.CompanyPeersComparisonData;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
import com.nikoladichev.findich.api.model.persistence.repository.CompanyPeersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyPeersService {

  private final CompanyPeersRepository repository;
  private final FundamentalsService fundamentalsService;

  public Set<CompanyPeers> getCompanyPeers(String symbol) {
    var companyPeers = repository.findBySymbol(symbol);

    if (companyPeers == null) {
      return Collections.emptySet();
    }

    return companyPeers.getPeers();
  }

  public void addCompanyPeers(String symbol, Set<String> symbols) {
    var companyPeers = repository.findBySymbol(symbol);

    if (companyPeers == null) {
      companyPeers = new CompanyPeers(symbol, new HashSet<>());
    }

    for (var s : symbols) {
      companyPeers.getPeers().add(new CompanyPeers(s, Collections.emptySet()));
    }

    repository.save(companyPeers);
  }

  public void removeCompanyPeers(String symbol, Set<String> symbols) {
    var companyPeers = repository.findBySymbol(symbol);

    if (companyPeers == null) {
      //      throw new ResourceNotFoundException
      throw new RuntimeException("Peers not found for " + symbol);
    }

    companyPeers.getPeers().removeIf(peer -> symbols.contains(peer.getSymbol()));

    repository.save(companyPeers);
  }

  public List<CompanyPeersComparisonData> getCompanyPeersData(String symbol) {
    var peerSymbols =
        getCompanyPeers(symbol).stream().map(CompanyPeers::getSymbol).collect(Collectors.toSet());
    var comparisonData = new ArrayList<CompanyPeersComparisonData>();

    comparisonData.add(getCompanyComparisonDta(symbol, symbol));

    for (var peerSymbol : peerSymbols) {
      var data = getCompanyComparisonDta(peerSymbol, symbol);

      if (comparisonData != null) {
        comparisonData.add(data);
      }
    }

    return comparisonData;
  }

  public void findByIndustrySectorAndEqualOrBiggerMarketCap(
      String symbol, String industry, String sector, BigInteger marketCap) {}

  private CompanyPeersComparisonData getCompanyComparisonDta(String symbol, String coreSymbol) {
    var companyProfile = fundamentalsService.getCompanyProfile(symbol);
    var incomeStatement =
        fundamentalsService.getIncomeStatements(symbol, Period.LTM).stream()
            .findFirst()
            .orElse(null);

    var balanceSheet =
        fundamentalsService.getBalanceSheetStatements(symbol, Period.LTM).stream()
            .findFirst()
            .orElse(null);

    if (companyProfile == null || incomeStatement == null || balanceSheet == null) {
      log.warn("Can't find enough fundamentals data for {} when evaluating {}", symbol, coreSymbol);

      return null;
    }

    var sharePrice = BigDecimal.valueOf(companyProfile.getPrice());
    var marketCap = companyProfile.getMktCap();
    var sharesOutstanding = marketCap.divide(sharePrice, RoundingMode.DOWN).toBigInteger();

    var cashAndEquivalents = BigInteger.valueOf(balanceSheet.getCashAndCashEquivalents());
    var totalDebt = BigInteger.valueOf(balanceSheet.getTotalDebt());
    var enterpriseValue = marketCap.toBigInteger().add(totalDebt).subtract(cashAndEquivalents);

    return CompanyPeersComparisonData.builder()
        .companyName(companyProfile.getCompanyName())
        .symbol(symbol)
        .sharePrice(sharePrice)
        .sharesOutstanding(sharesOutstanding)
        .marketCap(marketCap.toBigInteger())
        .cashAndEquivalents(cashAndEquivalents)
        .netDebt(BigInteger.valueOf(balanceSheet.getNetDebt()))
        .enterpriseValue(enterpriseValue)
        .revenue(BigInteger.valueOf(incomeStatement.getRevenue()))
        .ebitda(BigInteger.valueOf(incomeStatement.getEbitda()))
        .netIncome(BigInteger.valueOf(incomeStatement.getNetIncome()))
        .build();
  }
}
