package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public final class DoubleAdapter extends AbstractNumericAdapter<Double> {

    public DoubleAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Double adapt(Arguments args) throws AdapterException {
        return parse(args).doubleValue();
    }
}
