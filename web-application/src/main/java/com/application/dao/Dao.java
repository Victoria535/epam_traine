package com.application.dao;

import com.application.entity.Entity;

import java.sql.Connection;
import java.util.List;

/**
 * Interface for data access object.
 *
 * @param <T> Entity to database
 *            <p>
 *            Date: apr 30 2021
 * @author Viktoria Symaniuk
 */
public abstract class Dao<T extends Entity> {
    private Connection connection;

    /**
     * @return Connection connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Method for setting the connection.
     *
     * @param connection Connection connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method for insert data to the database.
     *
     * @param entity data to insert
     * @see Entity
     */
    public abstract void create(T entity) throws DaoException;

    /**
     * Method for read all data to the database.
     *
     * @return List read data list
     */
    public abstract List<T> readAll() throws DaoException;

    /**
     * Method for find entity by id.
     *
     * @param id Long id of entity
     * @return T Entity
     */
    public abstract T findById(Long id) throws DaoException;

    /**
     * Method for update data to the database.
     *
     * @param entity data to update
     */
    public abstract void update(T entity) throws DaoException;

    /**
     * Method for delete data to the database.
     *
     * @param id int id of the data to delete
     */
    public abstract void delete(Long id) throws DaoException;
}
