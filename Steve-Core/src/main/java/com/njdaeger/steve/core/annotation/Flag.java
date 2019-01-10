package com.njdaeger.steve.core.annotation;

import com.njdaeger.steve.core.argument.AbstractAdapter;
import com.njdaeger.steve.core.argument.adapter.StringAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a flag in the command argument.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Flag {

    //@Flag(value = "w:", adapter = CoWorldAdapter.class, splitter = ':')
    //@Flag(value = "-s", adapter = IntegerAdapter.class, consume = 2)
    //  /command [-s 1] 1

    /**
     * This parses the (optional) value at the end of this flag.
     * @return
     */
    Class<? extends AbstractAdapter> adapter() default StringAdapter.class;

    int consume() default 1;

    char splitter() default Character.UNASSIGNED;

    String value();

}
