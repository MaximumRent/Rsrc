package com.megapapa.rsrc.resource.filter.exception;

/**
 * Specific exception, which says what filtration failed.
 */
public class FilterationFailedException extends RuntimeException {

    public FilterationFailedException() {
        super();
    }

    public FilterationFailedException(String message) {
        super(message);
    }

    public FilterationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilterationFailedException(Throwable cause) {
        super(cause);
    }

    protected FilterationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
