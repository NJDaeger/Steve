package com.njdaeger.steve.core.exception;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

public class SteveException extends CommandSyntaxException implements CommandExceptionType {

    public SteveException(String message) {
        super(new SimpleCommandExceptionType(new LiteralMessage(message)), new LiteralMessage(message));
    }

}
