package com.shunyi.ddd.core.stereotype;

import javax.security.auth.Subject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface BoundedContext {
    public String name();
    public SubDomain subDomain() default SubDomain.Core;
}
