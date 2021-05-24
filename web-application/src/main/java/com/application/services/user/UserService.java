package com.application.services.user;

import com.application.dao.user.UserDao;
import com.application.entity.User;
import com.application.services.Service;
import com.application.services.exception.ServiceException;

import java.util.List;

/**
 * Interface for user service.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public interface UserService extends Service {
    /**
     * Method for setting userDao.
     *
     * @param userDao UserDao user dao
     */
    void setUserDao(UserDao userDao);

    /**
     * Method for find all users.
     *
     * @return List list of users
     * @throws ServiceException exception of service
     * @see User
     */
    List<User> findAll() throws ServiceException;

    /**
     * Method for find all users by teacher.
     *
     * @return List list of teachers
     * @throws ServiceException exception of service
     * @see User
     */
    List<User> findAllTeachers() throws ServiceException;

    /**
     * Method for find all users by student.
     *
     * @return List list of students
     * @throws ServiceException exception of service
     * @see User
     */
    List<User> findAllStudents() throws ServiceException;

    /**
     * Method for find user by id.
     *
     * @param id Long id of user
     * @return User mark
     * @throws ServiceException exception of service
     * @see User
     */
    User findById(Long id) throws ServiceException;

    /**
     * Method for authorized user.
     *
     * @param login    String login of user
     * @param password String password of user
     * @return User user
     * @throws ServiceException exception of service
     * @see User
     */
    User login(String login, String password) throws ServiceException;

    /**
     * Method for save of user.
     *
     * @param user User user
     * @throws ServiceException exception of service
     * @see User
     */
    void save(User user) throws ServiceException;

    /**
     * Method for delete of user.
     *
     * @param id Long id of user
     * @throws ServiceException exception of service
     */
    void delete(Long id) throws ServiceException;
}
