package com.njdaeger.steve.core.parameter.adapter;

import com.njdaeger.steve.core.argument.Arguments;

public final class StringAdapter extends AbstractAdapter<String> {

    public StringAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public String adapt(Arguments args) {
        return args.argAt(currentArgumentIndex);
    }
}
