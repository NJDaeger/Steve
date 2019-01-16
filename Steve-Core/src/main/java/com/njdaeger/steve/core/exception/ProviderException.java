package com.njdaeger.steve.core.exception;

public class ProviderException extends RuntimeException {

    public ProviderException() {
        super("Error attempting to provide argument.");
    }

}
