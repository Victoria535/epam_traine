package com.application.connection;

/**
 * Exception for Connection Pool.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class ConnectionPoolException extends Exception {
    /**
     * Constructor.
     */
    public ConnectionPoolException() {
    }

    /**
     * Constructor with parameter.
     *
     * @param cause Throwable
     */
    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
