package com.application.dao;

/**
 * Exception for Dao.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class DaoException extends Exception {
    /**
     * Constructor.
     */
    public DaoException() {
    }

    /**
     * Constructor with parameter.
     *
     * @param cause Throwable
     */
    public DaoException(Throwable cause) {
        super(cause);
    }
}
