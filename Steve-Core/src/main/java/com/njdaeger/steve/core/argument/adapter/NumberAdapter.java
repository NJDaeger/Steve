package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public final class NumberAdapter extends AbstractNumericAdapter<Number> {

    public NumberAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Number adapt(Arguments args) throws AdapterException {
        return parse(args);
    }

}
