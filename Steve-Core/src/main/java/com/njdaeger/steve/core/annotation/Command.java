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
     *
     * @return The name of this command.
     */
    String name();

    /**
     * Aliases for this command. Default is an empty array.
     *
     * @return The aliases for this command
     */
    String[] aliases() default {};

    /**
     * The description of the command. Default is an empty string.
     *
     * @return The description of the command.
     */
    String description() default "";

    /**
     * The usage of the command. Default is an empty string.
     *
     * @return The command usage.
     */
    String usage() default "";

    /**
     * The maximum amount of argument allowed in order for this command to still be ran. Default is there's no max
     * (-1).
     *
     * @return The max amount of argument allowed in the command.
     */
    int max() default -1;

    /**
     * The minimum amount of argument needed in order for this command to run. Default is there's no min (-1).
     *
     * @return The min amount of argument allowed in the command.
     */
    int min() default -1;

}
