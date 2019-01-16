package com.njdaeger.steve.core;

/**
 * A CommandContext acts as a wrapper for the CommandSource and the Command object.
 * @param <S> The Platform specific CommandSource
 */
public interface CommandContext<S> {

    S getSource();

    default <T extends S> boolean isType(Class<T> type) {
        return type.isInstance(getSource());
    }

    default <T extends S> T getAs(Class<T> type) {
        return isType(type) ? type.cast(getSource()) : null;
    }

    String getAlias();

    Arguments getArguments();



}
