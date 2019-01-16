package com.njdaeger.steve.core.argument;

import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.CommandContext;
import com.njdaeger.steve.core.exception.SteveException;

public abstract class AbstractParameterProvider<P, S> {

    public abstract P provide(Arguments args, CommandContext<S> context) throws SteveException;

}
