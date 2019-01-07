package com.njdaeger.steve.core.internal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.tree.CommandNode;

import java.util.Map;

public class CommandContextModifier<S> extends CommandContext<S> implements com.njdaeger.steve.core.CommandContext<S> {

    public CommandContextModifier(S source, String input, Map<String, ParsedArgument<S, ?>> arguments, Command<S> command, Map<CommandNode<S>, StringRange> nodes, StringRange range, CommandContext<S> child, RedirectModifier<S> modifier, boolean forks) {
        super(source, input, arguments, command, nodes, range, child, modifier, forks);
    }

    @Override
    public boolean isConsole() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
