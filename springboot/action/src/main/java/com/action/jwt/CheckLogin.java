package com.action.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
public @interface CheckLogin {
    String value();
}
