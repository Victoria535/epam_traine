package com.application.services.exception;

/**
 * Exception for Service.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class TransactionException extends ServiceException {
    /**
     * Constructor with parameter.
     *
     * @param cause Throwable cause
     */
    public TransactionException(Throwable cause) {
        super(cause);
    }
}
