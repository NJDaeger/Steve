package com.njdaeger.steve.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is meant to mark a parameter for only taking n amount of arguments from the arguments array.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Consume {

    /**
     * How many arguments to take from the argument array. Default is 1.
     * @return The amount of arguments to take from the array.
     */
    int value() default 1;

}
