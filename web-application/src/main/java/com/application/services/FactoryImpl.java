package com.application.services;

import com.application.connection.ConnectionPoolException;
import com.application.dao.course.CourseDao;
import com.application.dao.course.CourseDaoImpl;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.course_student.CourseStudentDaoImpl;
import com.application.dao.mark.MarkDao;
import com.application.dao.mark.MarkDaoImpl;
import com.application.dao.user.UserDao;
import com.application.dao.user.UserDaoImpl;
import com.application.services.course.CourseService;
import com.application.services.course.CourseServiceImpl;
import com.application.services.courses_students.CourseStudentService;
import com.application.services.courses_students.CourseStudentServiceImpl;
import com.application.services.exception.FactoryException;
import com.application.services.mark.MarkService;
import com.application.services.mark.MarkServiceImpl;
import com.application.services.transaction.Transaction;
import com.application.services.transaction.TransactionImpl;
import com.application.services.user.UserService;
import com.application.services.user.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

import static com.application.Printable.printWarning;
import static com.application.connection.ConnectionPool.getInstance;

/**
 * Class for implements interface Factory.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class FactoryImpl implements Factory {
    private Connection connection;

    @Override
    public UserService getUserService() throws FactoryException {
        UserService userService = new UserServiceImpl();
        userService.setTransaction(getTransaction());
        userService.setUserDao(getUserDao());
        return userService;
    }

    @Override
    public CourseService getCourseService() throws FactoryException {
        CourseService courseService = new CourseServiceImpl();
        courseService.setTransaction(getTransaction());
        courseService.setCourseDao(getCourseDao());
        courseService.setUserDao(getUserDao());
        courseService.setCourseStudentDao(getCourseStudentDao());
        return courseService;
    }

    @Override
    public MarkService getMarkService() throws FactoryException {
        MarkService markService = new MarkServiceImpl();
        markService.setTransaction(getTransaction());
        markService.setMarkDao(getMarkDao());
        markService.setUserDao(getUserDao());
        markService.setCourseDao(getCourseDao());
        return markService;
    }

    @Override
    public CourseStudentService getCourseStudentService() throws FactoryException {
        CourseStudentService courseStudentService = new CourseStudentServiceImpl();
        courseStudentService.setTransaction(getTransaction());
        courseStudentService.setCourseStudentDao(getCourseStudentDao());
        courseStudentService.setUserDao(getUserDao());
        courseStudentService.setCourseDao(getCourseDao());
        return courseStudentService;
    }

    @Override
    public Transaction getTransaction() throws FactoryException {
        TransactionImpl transaction = null;
        transaction = new TransactionImpl();
        transaction.setConnection(getConnection());
        return transaction;
    }

    @Override
    public Connection getConnection() throws FactoryException {
        if (connection == null) {
            try {
                connection = getInstance().getConnection();
            } catch (ConnectionPoolException exception) {
                throw new FactoryException(exception);
            }
        }
        return connection;
    }

    @Override
    public UserDao getUserDao() throws FactoryException {
        UserDao userDao = new UserDaoImpl();
        userDao.setConnection(getConnection());
        return userDao;
    }

    @Override
    public CourseDao getCourseDao() throws FactoryException {
        CourseDao courseDao = new CourseDaoImpl();
        courseDao.setConnection(getConnection());
        return courseDao;
    }

    @Override
    public MarkDao getMarkDao() throws FactoryException {
        MarkDao markDao = new MarkDaoImpl();
        markDao.setConnection(getConnection());
        return markDao;
    }

    @Override
    public CourseStudentDao getCourseStudentDao() throws FactoryException {
        CourseStudentDao courseStudentDao = new CourseStudentDaoImpl();
        courseStudentDao.setConnection(getConnection());
        return courseStudentDao;
    }

    @Override
    public void close() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
