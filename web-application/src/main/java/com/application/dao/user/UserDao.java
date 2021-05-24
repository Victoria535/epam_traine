package com.application.dao.user;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.entity.User;

/**
 * Class for data access object User.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public abstract class UserDao extends Dao<User> {
    /**
     * Method for find by login and password.
     *
     * @param login    String login of user
     * @param password String password of user
     * @return User user
     * @throws DaoException dao exception
     * @see User
     */
    public abstract User findByLoginAndPassword(String login, String password) throws DaoException;

    /**
     * Method for find by login and password.
     *
     * @param name String name of user
     * @return User user
     * @throws DaoException dao exception
     * @see User
     */
    public abstract User findByName(String name) throws DaoException;
}
