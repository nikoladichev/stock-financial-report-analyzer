package com.nikoladichev.findich.api.integration.dcf.request.helpers;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface GetRequestParam {
    String value() default "";
}
