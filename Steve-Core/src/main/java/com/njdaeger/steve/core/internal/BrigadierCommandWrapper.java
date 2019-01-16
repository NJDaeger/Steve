package com.njdaeger.steve.core.internal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.njdaeger.steve.core.Arguments;
import com.njdaeger.steve.core.SteveCommand;

import java.util.concurrent.CompletableFuture;

public class BrigadierCommandWrapper<S> implements Command<S>, SuggestionProvider<S> {

    private SteveCommand command;

    public BrigadierCommandWrapper(SteveCommand command) {
        this.command = command;
    }

    @Override
    public int run(CommandContext<S> context) throws CommandSyntaxException {
        command.execute(new Arguments(context.getInput().split(" "), ));
        return 1;
    }

    @Override
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<S> context, SuggestionsBuilder builder) throws CommandSyntaxException {
        return null;
    }
}
