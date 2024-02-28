package com.nikoladichev.findich.api.model.common;

import java.math.BigInteger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MarketCap {
  MEGA(
      "Mega Cap",
      new BigInteger("200000000000"),
      new BigInteger("1000000000000000")), // Range: 200 billion and above
  LARGE(
      "Large Cap",
      new BigInteger("10000000000"),
      new BigInteger("200000000000")), // Range: 10 billion to 200 billion
  MID(
      "Mid Cap",
      new BigInteger("2000000000"),
      new BigInteger("10000000000")), // Range: 2 billion to 10 billion
  SMALL(
      "Small Cap",
      new BigInteger("250000000"),
      new BigInteger("2000000000")), // Range: 250 million to 2 billion
  MICRO("Micro Cap", BigInteger.ZERO, new BigInteger("250000000")); // Range: Less than 250 million

  private final String label;
  private final BigInteger minRange;
  private final BigInteger maxRange;

  public static MarketCap getMarketCap(BigInteger marketCap) {
    for (MarketCap cap : MarketCap.values()) {
      if (cap.getMaxRange() == null) {
        if (marketCap.compareTo(cap.minRange) >= 0) {
          return cap;
        }
      } else {
        if (marketCap.compareTo(cap.minRange) >= 0 && marketCap.compareTo(cap.maxRange) <= 0) {
          return cap;
        }
      }
    }
    throw new IllegalArgumentException(
        "No market cap range found for the provided value: " + marketCap);
  }
}
