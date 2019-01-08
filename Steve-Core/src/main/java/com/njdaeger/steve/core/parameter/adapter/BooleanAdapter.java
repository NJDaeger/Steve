package com.njdaeger.steve.core.parameter.adapter;

import com.njdaeger.steve.core.argument.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public final class BooleanAdapter extends AbstractAdapter<Boolean>{

    public BooleanAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    public Boolean adapt(Arguments args) throws AdapterException {
        String input = args.argAt(currentArgumentIndex);
        if (input == null || (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false"))) throw new AdapterException("Argument at index " + currentArgumentIndex + " is not parsable as a Boolean type.");
        return input.equalsIgnoreCase("true");
    }
}
