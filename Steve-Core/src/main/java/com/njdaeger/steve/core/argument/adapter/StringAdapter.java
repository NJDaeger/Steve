package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.argument.AbstractAdapter;

public final class StringAdapter extends AbstractAdapter<String> {

    public StringAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public String adapt(Arguments args) {
        return args.argAt(currentArgumentIndex);
    }
}
