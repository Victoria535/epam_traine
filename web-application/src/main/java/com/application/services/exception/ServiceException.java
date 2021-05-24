package com.application.services.exception;

/**
 * Exception for Service.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class ServiceException extends Exception {

    /**
     * Constructor with parameter.
     *
     * @param cause Throwable cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
