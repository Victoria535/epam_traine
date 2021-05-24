package com.application.services.user;

import com.application.dao.DaoException;
import com.application.dao.user.UserDao;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.exception.ServiceException;
import com.application.services.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * User service implements interface UserService.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class UserServiceImpl implements UserService {
    private Transaction transaction;
    private UserDao userDao;

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<User> userList = userDao.readAll();
            getTransaction().commit();
            return userList;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<User> findAllTeachers() throws ServiceException {
        try {
            getTransaction().start();
            List<User> teachers = new ArrayList<>();
            List<User> users = userDao.readAll();
            for (User user : users) {
                if (user.getRole().equals(Role.TEACHER)) {
                    teachers.add(user);
                }
            }
            getTransaction().commit();
            return teachers;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }

    }

    @Override
    public List<User> findAllStudents() throws ServiceException {
        try {
            getTransaction().start();
            List<User> students = new ArrayList<>();
            List<User> users = userDao.readAll();
            for (User user : users) {
                if (user.getRole().equals(Role.STUDENT)) {
                    students.add(user);
                }
            }
            getTransaction().commit();
            return students;

        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public User findById(Long id) throws ServiceException {
        try {
            getTransaction().start();
            User user = userDao.findById(id);
            getTransaction().commit();
            return user;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public User login(String login, String password) throws ServiceException {
        try {
            getTransaction().start();
            User user = userDao.findByLoginAndPassword(login, password);
            getTransaction().commit();
            return user;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void save(User user) throws ServiceException {
        try {
            getTransaction().start();
            if (user.getId() == null) {
                userDao.create(user);
            } else {
                userDao.update(user);
            }
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            getTransaction().start();
            userDao.delete(id);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }
}
