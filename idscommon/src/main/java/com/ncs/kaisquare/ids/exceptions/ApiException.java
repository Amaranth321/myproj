package com.ncs.kaisquare.ids.exceptions;

public class ApiException extends Exception {

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String format, Object... params) {
        super(String.format(format, params));
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

}
