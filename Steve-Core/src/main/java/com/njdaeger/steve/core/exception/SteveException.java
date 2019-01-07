package com.njdaeger.steve.core.exception;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

public class SteveException extends CommandSyntaxException {

    public SteveException(CommandExceptionType type, Message message, String input, int cursor) {
        super(type, message, input, cursor);
    }

}
