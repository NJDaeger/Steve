package com.njdaeger.steve.core;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.tree.CommandNode;

import java.util.Map;

public class DefaultContext extends CommandContext<DefaultContext> {

    public DefaultContext(DefaultContext source, String input, Map<String, ParsedArgument<DefaultContext, ?>> arguments, Command<DefaultContext> command, Map<CommandNode<DefaultContext>, StringRange> nodes, StringRange range, CommandContext<DefaultContext> child, RedirectModifier<DefaultContext> modifier, boolean forks) {
        super(source, input, arguments, command, nodes, range, child, modifier, forks);
    }
}
