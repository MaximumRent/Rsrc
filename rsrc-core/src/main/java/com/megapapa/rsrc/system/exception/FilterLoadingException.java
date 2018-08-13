package com.megapapa.rsrc.system.exception;

public class FilterLoadingException extends Exception {

    public FilterLoadingException() {
        super();
    }

    public FilterLoadingException(String message) {
        super(message);
    }

    public FilterLoadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilterLoadingException(Throwable cause) {
        super(cause);
    }

    protected FilterLoadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
