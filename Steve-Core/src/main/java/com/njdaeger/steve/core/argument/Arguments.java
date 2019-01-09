package com.njdaeger.steve.core.argument;

import com.njdaeger.steve.core.exception.AdapterException;
import com.njdaeger.steve.core.exception.NotEnoughArgumentsException;
import com.njdaeger.steve.core.parameter.adapter.AbstractAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Represents the raw arguments provided in the given command.
 */
public class Arguments implements Iterable<String> {

    private final String[] arguments;

    /**
     * Creates an Arguments object with the given command arguments array.
     *
     * @param arguments The array of arguments to represent.
     */
    public Arguments(String... arguments) {
        this.arguments = arguments;
    }

    @Override
    public Iterator<String> iterator() {
        return new ArgumentsIterator();
    }

    /**
     * Check if the length of this argument object is equal to the given length.
     *
     * @param length The length to check equality against.
     * @return True if the length of the given length and this argument object are equal.
     */
    public boolean isLength(int length) {
        return length == arguments.length;
    }

    /**
     * The current length of this arguments array.
     *
     * @return The current length of the arguments array.
     */
    public int length() {
        return arguments.length;
    }

    /**
     * Method to retrieve the base array of arguments
     *
     * @return The base argument array.
     */
    public String[] asArray() {
        return arguments;
    }

    /**
     * Method to retrieve the base array of arguments as a list.
     *
     * @return THe base argument array as an ArrayList
     */
    public List<String> asList() {
        return Arrays.asList(arguments);
    }

    /**
     * Check whether the arguments array has an argument at the specified index. It checks whether the index provided is
     * within bounds and if the argument found is not null.
     *
     * @param index The index to check for an argument.
     * @return True if the index given is greater than 0 and less than the length of the arguments array and if the
     *         argument found is not null.
     */
    public boolean hasArgAt(int index) {
        return index >= 0 && index < arguments.length && arguments[index - 1] != null;
    }

    /**
     * Attempts to get an argument at the specified index. Null if the index provided is out of bounds.
     *
     * @param index The index to get the argument from
     * @return The argument found, or null if no argument was found.
     */
    public String argAt(int index) {
        if (hasArgAt(index)) return null;
        else return arguments[index];
    }

    /**
     * Attempts to return the first argument in the arguments array.
     *
     * @return The first argument in the argument array, or null if there is no first argument.
     */
    public String first() {
        return argAt(0);
    }

    /**
     * Attempts to return the first argument in the arguments array parsed with a specific {@link AbstractAdapter}
     *
     * @param type The class type of the adapter to parse this argument with.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The first argument parsed to the Abstract Adapter's adapting type.
     * @throws AdapterException If the argument exists, but could not be parsed to the given adapter.
     * @throws NotEnoughArgumentsException If the argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T first(Class<A> type) throws AdapterException, NotEnoughArgumentsException {
        if (first() != null) {
            try {
                return type.getDeclaredConstructor(int.class).newInstance(0).adapt(this);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        throw new NotEnoughArgumentsException("Cannot adapt first argument. It does not exist!");
    }

    /**
     * Attempts to return the first argument in the arguments array parsed with a specific {@link AbstractAdapter} or
     * returns the fallback value if the value was unable to be parsed as the adapter provided or if the first argument
     * does not exist.
     *
     * @param type The class type of the adapter to parse this argument with.
     * @param fallback The fallback value to return if the value was unable to be parsed to the provided
     *         adapter.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The first argument parsed with the abstract adapter's adapting type, or the fallback value if it was
     *         unable to be parsed or if the first argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T first(Class<A> type, T fallback) {

    }

    private class ArgumentsIterator implements Iterator<String> {

        private int index;

        @Override
        public boolean hasNext() {
            return index < arguments.length - 1;
        }

        @Override
        public String next() {
            if (hasNext()) {
                int current = index;
                index++;
                return arguments[current];
            }
            throw new NoSuchElementException();
        }

    }

}
