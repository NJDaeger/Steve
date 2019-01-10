package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public final class FloatAdapter extends AbstractNumericAdapter<Float> {

    public FloatAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Float adapt(Arguments args) throws AdapterException {
        return parse(args).floatValue();
    }
}
