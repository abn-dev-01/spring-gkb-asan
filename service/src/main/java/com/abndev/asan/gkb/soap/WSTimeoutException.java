package com.abndev.asan.gkb.soap;

public class WSTimeoutException extends RuntimeException {
    public WSTimeoutException(String message) {
        super(message);
    }

    public WSTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public WSTimeoutException(Throwable cause) {
        super(cause);
    }
}
