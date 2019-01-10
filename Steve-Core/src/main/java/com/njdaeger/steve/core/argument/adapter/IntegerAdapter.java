package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.argument.AbstractNumericAdapter;
import com.njdaeger.steve.core.exception.AdapterException;

public final class IntegerAdapter extends AbstractNumericAdapter<Integer> {

    public IntegerAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Integer adapt(Arguments args) throws AdapterException {
        return parse(args).intValue();
    }
}
