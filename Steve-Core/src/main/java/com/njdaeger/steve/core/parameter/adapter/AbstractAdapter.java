package com.njdaeger.steve.core.parameter.adapter;

import com.njdaeger.steve.core.argument.Arguments;
import com.njdaeger.steve.core.exception.AdapterException;

public abstract class AbstractAdapter<R> {

    protected int currentArgumentIndex;

    public AbstractAdapter(int currentArgumentIndex) {
        this.currentArgumentIndex = currentArgumentIndex;
    }

    public abstract R adapt(Arguments args) throws AdapterException;

}
