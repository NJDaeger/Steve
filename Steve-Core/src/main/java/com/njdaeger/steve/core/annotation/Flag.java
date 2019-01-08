package com.njdaeger.steve.core.annotation;

import com.njdaeger.steve.core.parameter.adapter.AbstractAdapter;
import com.njdaeger.steve.core.parameter.adapter.StringAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Flag {

    Class<? extends AbstractAdapter> parser() default StringAdapter.class;

    String value();

}
