package com.njdaeger.steve.core.argument;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public abstract class AbstractNumericAdapter<N extends Number> extends AbstractAdapter<N> {

    public AbstractNumericAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    public abstract N adapt(Arguments args) throws AdapterException;

    protected Number parse(Arguments args) throws AdapterException {
        try {
            return Double.parseDouble(args.argAt(currentArgumentIndex));
        } catch (NumberFormatException e) {
            throw new AdapterException("Argument at index " + currentArgumentIndex + " is not parsable as a Number.");
        }
    }

}
