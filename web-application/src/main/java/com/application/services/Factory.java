package com.application.services;

import com.application.dao.course.CourseDao;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.mark.MarkDao;
import com.application.dao.user.UserDao;
import com.application.services.course.CourseService;
import com.application.services.courses_students.CourseStudentService;
import com.application.services.exception.FactoryException;
import com.application.services.mark.MarkService;
import com.application.services.transaction.Transaction;
import com.application.services.user.UserService;

import java.sql.Connection;

/**
 * Interface Factory.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public interface Factory extends AutoCloseable {
    /**
     * Method for getting UserService.
     *
     * @return UserService user service
     * @throws FactoryException exception of factory
     */
    UserService getUserService() throws FactoryException;

    /**
     * Method for getting CourseService.
     *
     * @return CourseService course service
     * @throws FactoryException exception of factory
     */
    CourseService getCourseService() throws FactoryException;

    /**
     * Method for getting MarkService.
     *
     * @return MarkService mark service
     * @throws FactoryException exception of factory
     */
    MarkService getMarkService() throws FactoryException;

    /**
     * Method for getting CourseStudentService.
     *
     * @return CourseStudentService courseStudent service
     * @throws FactoryException exception of factory
     */
    CourseStudentService getCourseStudentService() throws FactoryException;

    /**
     * @return Transaction transaction
     * @throws FactoryException exception of factory
     */
    Transaction getTransaction() throws FactoryException;

    /**
     * @return UserDao user dao
     * @throws FactoryException exception of factory
     */
    UserDao getUserDao() throws FactoryException;

    /**
     * @return CourseDao course dao
     * @throws FactoryException exception of factory
     */
    CourseDao getCourseDao() throws FactoryException;

    /**
     * @return MarkDao mark dao
     * @throws FactoryException exception of factory
     */
    MarkDao getMarkDao() throws FactoryException;

    /**
     * @return CourseStudentDao courseStudent dao
     * @throws FactoryException exception of factory
     */
    CourseStudentDao getCourseStudentDao() throws FactoryException;

    /**
     * @return Connection connection
     * @throws FactoryException exception of factory
     */
    Connection getConnection() throws FactoryException;
}
