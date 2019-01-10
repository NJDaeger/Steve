package com.njdaeger.steve.core.argument;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

/**
 * Formats argument into more useful form by adapting them to the desired type.
 * @param <R> The type of value to turn the argument(s) into and return.
 */
public abstract class AbstractAdapter<R> {

    protected int currentArgumentIndex;

    public AbstractAdapter(int currentArgumentIndex) {
        this.currentArgumentIndex = currentArgumentIndex;
    }

    public abstract R adapt(Arguments args) throws AdapterException;

}
