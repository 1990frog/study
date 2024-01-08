package com.action.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
public @interface Decode {
    String value() default "";
}
