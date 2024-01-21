package com.nikoladichev.findich.api.integration.dcf.request;

import com.nikoladichev.findich.api.integration.dcf.request.helpers.GetRequestParam;
import com.nikoladichev.findich.api.model.fundamentals.statements.Period;
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

