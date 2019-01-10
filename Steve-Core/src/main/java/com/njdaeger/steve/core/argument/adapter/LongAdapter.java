package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public final class LongAdapter extends AbstractNumericAdapter<Long> {

    public LongAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Long adapt(Arguments args) throws AdapterException {
        return parse(args).longValue();
    }
}
