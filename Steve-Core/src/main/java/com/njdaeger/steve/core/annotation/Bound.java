package com.njdaeger.steve.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is meant to act as a bound for numeric parameters in command methods to specify a minimum and maximum possible
 * value for the particular argument.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bound {

    /**
     * The lowest number allowed for the argument
     * @return The lowest number allowed for the argument
     */
    int min() default Integer.MIN_VALUE;

    /**
     * The highest number allowed for the argument.
     * @return The highest number allowed for the argument
     */
    int max() default Integer.MAX_VALUE;

}
