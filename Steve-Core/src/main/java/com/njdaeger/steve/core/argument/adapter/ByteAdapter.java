package com.njdaeger.steve.core.argument.adapter;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.argument.AbstractNumericAdapter;
import com.njdaeger.steve.core.exception.AdapterException;

public final class ByteAdapter extends AbstractNumericAdapter<Byte> {

    public ByteAdapter(int currentArgumentIndex) {
        super(currentArgumentIndex);
    }

    @Override
    public Byte adapt(Arguments args) throws AdapterException {
        return parse(args).byteValue();
    }
}
