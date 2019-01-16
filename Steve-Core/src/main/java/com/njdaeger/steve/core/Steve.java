package com.njdaeger.steve.core;

import com.njdaeger.steve.core.annotation.Command;
import com.njdaeger.steve.core.annotation.Completion;
import com.njdaeger.steve.core.annotation.Permission;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class Steve {

    private final Map<String, SteveCommand> commands;
    private static Steve steve = null;

    private Steve() {
        this.commands = new HashMap<>();
        steve = this;
    }

    /**
     * Gets the current instance of Steve if it exists. This will create a new instance of Steve if steve does not
     * exist.
     *
     * @return The instance of Steve.
     */
    public static Steve get() {
        return steve != null ? steve : new Steve();
    }

    /**
     * Registers an individual {@link SteveCommand}
     *
     * @param command The command to register.
     */
    public void register(SteveCommand command) {
        commands.put(command.getName(), command);
        for (String alias : command.getAliases()) {
            commands.put(alias, command);
        }
    }

    /**
     * Registers all methods annotated with the {@link com.njdaeger.steve.core.annotation.Command} annotation.
     *
     * @param cls The class to search for methods.
     */
    public void register(Class<?> cls) {

        Collection<Method> commandMethods = new ArrayList<>();
        Map<String, Method> completions = new HashMap<>();

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Command.class)) {
                commandMethods.add(method);
                continue;
            }
            //Check if the completion annotation is present.
            if (method.isAnnotationPresent(Completion.class)) {

                //We get the completion annotation and get all of the commands/aliases it completes for.
                Completion completion = method.getAnnotation(Completion.class);

                //Loop through the names of the commands.
                for (String command : completion.value()) {
                    completions.put(command, method);
                }
            }
        }

        for (Method method : commandMethods) {
            //If the Completion annotation is present, just skip it.
            if (method.isAnnotationPresent(Completion.class)) continue;

            //We already know the command method is present.
            Command command = method.getAnnotation(Command.class);
            Permission permission = method.isAnnotationPresent(Permission.class) ? method.getAnnotation(Permission.class) : null;
            Method completion = completions.getOrDefault(command.name(), null);

            register(new SteveCommand(method, command, permission, completion));
        }

    }

    public void unregister(SteveCommand command) {

    }

    public void unregister(String command) {

    }

    public void unregister(Class<?> cls) {

    }

    public SteveCommand getCommand(String name) {
        return commands.get(name);
    }

}
