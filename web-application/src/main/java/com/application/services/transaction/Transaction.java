package com.application.services.transaction;

import com.application.services.exception.TransactionException;

/**
 * Interface for transaction.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public interface Transaction {
    /**
     * Method for start transaction.
     *
     * @throws TransactionException transaction exception
     */
    void start() throws TransactionException;

    /**
     * Method for commit transaction.
     *
     * @throws TransactionException transaction exception
     */
    void commit() throws TransactionException;

    /**
     * Method for rollback transaction.
     *
     * @throws TransactionException transaction exception
     */
    void rollback() throws TransactionException;
}
