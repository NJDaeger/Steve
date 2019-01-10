package com.njdaeger.steve.core.annotation;

public @interface Permission {

    String[] value() default {};

    boolean requireAll() default false;

}
