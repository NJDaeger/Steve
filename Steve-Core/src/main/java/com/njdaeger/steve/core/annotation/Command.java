package com.njdaeger.steve.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a command method.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    /**
     * Primary name of this command.
     * @return The name of this command.
     */
    String name();

    /**
     * Aliases for this command. Default is an empty array.
     * @return The aliases for this command
     */
    String[] aliases() default {};

    /**
     * The description of the command.
     * @return The description of the command.
     */
    String description() default "";

    /**
     * The usage of the command.
     * @return
     */
    String usage() default "";

    int max() default -1;

    int min() default -1;

}
