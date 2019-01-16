package com.njdaeger.steve.core.internal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.RedirectModifier;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedArgument;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.tree.CommandNode;
import com.njdaeger.steve.core.Arguments;

import java.util.List;
import java.util.Map;

public class CommandContextModifier<S> extends CommandContext<S> implements com.njdaeger.steve.core.CommandContext<S> {

    /**
     * Creates a new CommandContext.
     *
     * @param source the command source to invoke the command for
     * @param input the full input
     * @param arguments the parsed arguments
     * @param command the command to invoke
     * @param rootNode the root node of the command tree
     * @param parsedCommandNodes all nodes associated with this context
     * @param range the string range indicating what part in the input this context covers
     * @param child the child context, or null if none
     * @param modifier the {@link RedirectModifier} to apply when invoking the command
     * @param forks whether this command forks. See {@link CommandDispatcher#execute(ParseResults)} for an
     *         explanation
     */
    public CommandContextModifier(S source, String input, Map<String, ParsedArgument<S, ?>> arguments, Command<S> command, CommandNode<S> rootNode, List<ParsedCommandNode<S>> parsedCommandNodes, StringRange range, CommandContext<S> child, RedirectModifier<S> modifier, boolean forks) {
        super(source, input, arguments, command, rootNode, parsedCommandNodes, range, child, modifier, forks);
    }

    @Override
    public String getAlias() {
        return getr
    }

    @Override
    public Arguments getArguments() {
        return null;
    }
}
