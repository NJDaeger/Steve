package com.njdaeger.steve.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies a method which is to be used as a tab completion method for a command.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Completion {

    /**
     * The name of the command(s) which this completion belongs to.
     * @return The commands which use this method for completions.
     */
    String[] value();

}
