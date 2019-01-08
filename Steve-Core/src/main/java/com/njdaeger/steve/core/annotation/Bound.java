package com.njdaeger.steve.core.annotation;

public @interface Bound {

    int min() default Integer.MIN_VALUE;

    int max() default Integer.MAX_VALUE;

}
