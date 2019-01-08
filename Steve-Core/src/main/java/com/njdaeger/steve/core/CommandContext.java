package com.njdaeger.steve.core;

import com.njdaeger.steve.core.argument.Arguments;

/**
 * Represents a base CommandContext which represents the sender of this command.
 * @param <S> The Platform specific CommandSource
 */
public interface CommandContext<S> {

    S getSource();

    boolean isConsole();

    boolean isPlayer();

    boolean isEntity();

    boolean isBlock();

    default boolean isLocatable() {
        return !isConsole();
    }

    default <T extends S> boolean isType(Class<T> type) {
        return type.isInstance(getSource());
    }

    default <T extends S> T getAs(Class<T> type) {
        return isType(type) ? type.cast(getSource()) : null;
    }

    String getAlias();

    Arguments getArguments();



}
