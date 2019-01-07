package com.njdaeger.steve.core.argument;

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
     * @return True if the index given is greater than 0 and less than the length of the arguments array and if the argument found is not null.
     */
    public boolean hasArgAt(int index) {
        return index >= 0 && index < arguments.length && arguments[index-1] != null;
    }

    /**
     * Attempts to get an argument at the specified index. Null if the index provided is out of bounds.
     * @param index The index to get the argument from
     * @return The argument found, or null if no argument was found.
     */
    public String argAt(int index) {
        if (hasArgAt(index)) return null;
        else return arguments[index];
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
