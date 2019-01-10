package com.njdaeger.steve.core;

import com.njdaeger.steve.core.exception.AdapterException;
import com.njdaeger.steve.core.exception.NotEnoughArgumentsException;
import com.njdaeger.steve.core.argument.AbstractAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents the raw argument provided in the given command.
 */
public class Arguments implements Iterable<String> {

    private final String[] arguments;

    /**
     * Creates an Arguments object with the given command argument array.
     *
     * @param arguments The array of argument to represent.
     */
    public Arguments(String... arguments) {
        this.arguments = arguments;
    }

    /**
     * Returns an iterator of the argument array.
     *
     * @return An iterator of the argument array.
     */
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
     * The current length of this argument array.
     *
     * @return The current length of the argument array.
     */
    public int length() {
        return arguments.length;
    }

    /**
     * Method to retrieve the base array of argument
     *
     * @return The base argument array.
     */
    public String[] asArray() {
        return arguments;
    }

    /**
     * Method to retrieve the base array of argument as a list.
     *
     * @return THe base argument array as an ArrayList
     */
    public List<String> asList() {
        return Arrays.asList(arguments);
    }

    /**
     * Check whether the argument array has an argument at the specified index. It checks whether the index provided is
     * within bounds and if the argument found is not null.
     *
     * @param index The index to check for an argument.
     * @return True if the index given is greater than or equal to 0 and less than the length of the argument array and if the
     *         argument found is not null.
     */
    public boolean hasArgAt(int index) {
        return index >= 0 && index < arguments.length && arguments[index] != null;
    }

    /**
     * Check if the argument array has an argument at the specified index which matches the given {@link
     * AbstractAdapter} parser.
     *
     * @param index The index of the argument to check.
     * @param type The class type of the adapter to parse this argument with.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return True if the argument at the given index is parsable with the specified Abstract Adapter.
     */
    public <A extends AbstractAdapter<T>, T> boolean isArgAt(int index, Class<A> type) {
        try {
            argAt(index, type);
        } catch (AdapterException | NotEnoughArgumentsException e) {
            return false;
        }
        return true;
    }

    /**
     * Attempt to get an argument from the argument array at the specified index parsed as the specified Adapter type
     *
     * @param index The index of the argument to retrieve.
     * @param type The class type of the adapter to parse the argument with.
     * @param <A> The {@link AbstractAdapter} to parse the argument with.
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The argument at the specified index parsed as the Adapter's adapting type.
     * @throws AdapterException If the argument exists, but could not be parsed to the given adapter.
     * @throws NotEnoughArgumentsException If the argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T argAt(int index, Class<A> type) throws AdapterException, NotEnoughArgumentsException {
        if (hasArgAt(index)) {
            try {
                return type.getDeclaredConstructor(int.class).newInstance(index).adapt(this);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        throw new NotEnoughArgumentsException("Cannot adapt argument " + index + ". It does not exist!");
    }

    /**
     * Attempts to get an argument at the specified index. Null if the index provided is out of bounds.
     *
     * @param index The index to get the argument from
     * @return The argument found, or null if no argument was found.
     */
    public String argAt(int index) {
        if (!hasArgAt(index)) return null;
        else return arguments[index];
    }

    /**
     * Attempts to return the first argument in the argument array.
     *
     * @return The first argument in the argument array, or null if there is no first argument.
     */
    public String first() {
        return argAt(0);
    }

    /**
     * Attempts to return the first argument in the argument array parsed with a specific {@link AbstractAdapter}
     *
     * @param type The class type of the adapter to parse this argument with.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The first argument parsed to the Abstract Adapter's adapting type.
     * @throws AdapterException If the argument exists, but could not be parsed to the given adapter.
     * @throws NotEnoughArgumentsException If the argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T first(Class<A> type) throws AdapterException, NotEnoughArgumentsException {
        if (first() != null) return argAt(0, type);
        throw new NotEnoughArgumentsException("Cannot adapt first argument. It does not exist!");
    }

    /**
     * Attempts to return the first argument in the argument array parsed with a specific {@link AbstractAdapter} or
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
        try {
            return isArgAt(0, type) ? argAt(0, type) : fallback;
        } catch (AdapterException | NotEnoughArgumentsException ignored) {}
        return fallback;
    }

    /**
     * Attempts to return the last argument int he argument array. This will return null if there are no argument.
     * @return The last argument in the argument array, or null if there are no argument.
     */
    public String last() {
        return argAt(arguments.length-1);
    }

    /**
     * Attempts to return the last argument in the argument array parsed with a specific {@link AbstractAdapter}
     *
     * @param type The class type of the adapter to parse this argument with.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The last argument parsed to the Abstract Adapter's adapting type.
     * @throws AdapterException If the argument exists, but could not be parsed to the given adapter.
     * @throws NotEnoughArgumentsException If the argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T last(Class<A> type) throws AdapterException, NotEnoughArgumentsException {
        if (last() != null) return argAt(arguments.length-1, type);
        throw new NotEnoughArgumentsException("Cannot adapt last argument. It does not exist!");
    }

    /**
     * Attempts to return the last argument in the argument array parsed with a specific {@link AbstractAdapter} or
     * returns the fallback value if the value was unable to be parsed as the adapter provided or if the last argument
     * does not exist.
     *
     * @param type The class type of the adapter to parse this argument with.
     * @param fallback The fallback value to return if the value was unable to be parsed to the provided
     *         adapter.
     * @param <A> The {@link AbstractAdapter} to parse the argument with
     * @param <T> The return type which is specified in the {@link AbstractAdapter<T>}
     * @return The last argument parsed with the abstract adapter's adapting type, or the fallback value if it was
     *         unable to be parsed or if the last argument does not exist.
     */
    public <A extends AbstractAdapter<T>, T> T last(Class<A> type, T fallback) {
        try {
            return isArgAt(arguments.length-1, type) ? argAt(arguments.length-1, type) : fallback;
        } catch (AdapterException | NotEnoughArgumentsException ignored) {}
        return fallback;
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
