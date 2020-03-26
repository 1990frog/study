package com.sourcecode.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("com.code.condition")
//@MyConditionAnnotation({"condition1", "condition2"})
public class A {
}
