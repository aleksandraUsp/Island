package com.javarush.uspenskaya.island.exeption;

public class IslandException extends RuntimeException {
    public IslandException() {
    }

    public IslandException(String message) {
        super(message);
    }

    public IslandException(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandException(Throwable cause) {
        super(cause);
    }
}
