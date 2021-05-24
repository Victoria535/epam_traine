package com.application.services;

import com.application.services.transaction.Transaction;

/**
 * Interface for main service.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public interface Service {
    /**
     * @return Transaction transaction
     */
    Transaction getTransaction();

    /**
     * Method for setting transaction.
     *
     * @param transaction Transaction transaction
     */
    void setTransaction(Transaction transaction);
}
