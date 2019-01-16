package com.njdaeger.steve.core;

import com.mojang.brigadier.suggestion.Suggestions;
import com.njdaeger.steve.core.annotation.Command;
import com.njdaeger.steve.core.annotation.Completion;
import com.njdaeger.steve.core.annotation.Permission;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.Map.Entry;

public class SteveCommand {

    private final Method method;
    private final Command command;
    private final Method completion;
    private final Permission permission;
    private final Collection<Parameter> parameters;
    private final Map<Parameter, Annotation[]> parameterMap;

    public SteveCommand(Method method, Command command, Permission permission, Method completion) {

        this.method = method;
        this.command = command;
        this.permission = permission;
        this.completion = completion;
        this.parameters = Arrays.asList(method.getParameters());
        this.parameterMap = new HashMap<>();

        parameters.forEach(p -> parameterMap.put(p, p.getAnnotations()));
    }

    public Method getMethod() {
        return method;
    }

    public String getName() {
        return command.name();
    }

    public String[] getAliases() {
        return command.aliases();
    }

    public String getDescription() {
        return command.description();
    }

    public String getUsage() {
        return command.usage();
    }

    public int getMin() {
        return command.min();
    }

    public int getMax() {
        return command.max();
    }

    public boolean hasPermissions() {
        return permission != null;
    }

    public String[] getPermissions() {
        if (hasPermissions()) return permission.value();
        throw new UnsupportedOperationException("No permissions were defined for this command.");
    }

    public boolean requiresAllPermissions() {
        if (hasPermissions()) return permission.requireAll();
        throw new UnsupportedOperationException("No permissions were defined for this command.");
    }

    public void execute(Arguments arguments, CommandContext<?> context) {

        for (Entry<Parameter, Annotation[]> entry : parameterMap.entrySet()) {

            for (Annotation annotation : entry.getValue()) {



            }

        }

    }

    public List<Suggestions> suggest(Arguments arguments) {

    }

}
