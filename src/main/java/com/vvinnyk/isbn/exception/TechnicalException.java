package com.vvinnyk.isbn.exception;

/**
 * @author Vladyslav_Vinnyk on 11/30/2016.
 */
public class TechnicalException extends RuntimeException {
    /**
     * @param message message.
     */
    public TechnicalException(String message) {
        super(message);
    }

    /**
     * @param message   message.
     * @param exception throwing exception.
     */
    public TechnicalException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * @param exception throwing exception.
     */
    public TechnicalException(Throwable exception) {
        super(exception);
    }
}
