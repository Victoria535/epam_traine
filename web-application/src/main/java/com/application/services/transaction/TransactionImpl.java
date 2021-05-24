package com.application.services.transaction;

import com.application.services.exception.TransactionException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class for implements interface Transaction.
 * <p>
 * Date: may 15 2021
 *
 * @author Viktoria Symaniuk
 */
public class TransactionImpl implements Transaction {
    private Connection connection;

    /**
     * Method for setting field connection.
     *
     * @param connection Connection field connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void start() throws TransactionException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            throw new TransactionException(exception);
        }
    }

    @Override
    public void commit() throws TransactionException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException exception) {
            throw new TransactionException(exception);
        }
    }

    @Override
    public void rollback() throws TransactionException {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException exception) {
            throw new TransactionException(exception);
        }
    }
}
