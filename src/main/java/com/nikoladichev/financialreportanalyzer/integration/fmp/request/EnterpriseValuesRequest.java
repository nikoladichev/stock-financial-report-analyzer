package com.nikoladichev.financialreportanalyzer.integration.fmp.request;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestParam;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnterpriseValuesRequest {
  private final @GetRequestParam Integer limit;
  private final @GetRequestParam Period period;
}
