package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.argument.AbstractNumericAdapter;
import com.njdaeger.steve.core.exception.AdapterException;

public final class ShortAdapter extends AbstractNumericAdapter<Short> {

    public ShortAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Short adapt(Arguments args) throws AdapterException {
        return parse(args).shortValue();
    }
}
