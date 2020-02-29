package com.source.condi;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("com.condition")
//@MyConditionAnnotation({"condition1", "condition2"})
public class A {
}
