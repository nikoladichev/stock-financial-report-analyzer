package com.nikoladichev.findich.api.integration.dcf.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Statement<T> {
  private String originalCurrency;
  private String convertedCurrency;
  private T report;
}
