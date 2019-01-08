package com.njdaeger.steve.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface Optional {

    String value() default "";

    int consume() default 1;

}
