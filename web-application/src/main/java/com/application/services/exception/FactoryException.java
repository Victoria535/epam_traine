package com.application.services.exception;

/**
 * Exception for Factory.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class FactoryException extends Exception {
    /**
     * Constructor.
     */
    public FactoryException() {
    }

    /**
     * Constructor with parameter.
     *
     * @param cause Throwable
     */
    public FactoryException(Throwable cause) {
        super(cause);
    }
}
