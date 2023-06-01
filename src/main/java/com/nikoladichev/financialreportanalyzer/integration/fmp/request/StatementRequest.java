package com.nikoladichev.financialreportanalyzer.integration.fmp.request;

import com.nikoladichev.financialreportanalyzer.integration.fmp.request.helpers.GetRequestParam;
import com.nikoladichev.financialreportanalyzer.model.fundamentals.statements.Period;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatementRequest {
    private final @GetRequestParam Integer limit;
    private final @GetRequestParam Period period;
    // TODO [STATEMENTS_AS_REPORTED] - this field shouldn't be used since it's not implemented
    private final @GetRequestParam Boolean asReported;
}

