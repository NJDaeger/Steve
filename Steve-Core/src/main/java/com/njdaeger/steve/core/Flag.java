package com.njdaeger.steve.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Flag {

    Class<? extends AbstractFlag> parser() default OptionalFlag.class;

    String value();

}
