package com.application.dao.course_student;

import com.application.dao.DaoException;
import com.application.entity.CourseStudent;

import java.sql.Connection;
import java.util.List;

/**
 * Class for data access object CourseStudent.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public abstract class CourseStudentDao {
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
     * Method for read all data to the database.
     *
     * @return List list of CourseStudent
     * @throws DaoException dao exception
     * @see CourseStudent
     */
    public abstract List<CourseStudent> readAll() throws DaoException;

    /**
     * Method for find courses by student.
     *
     * @param studentId Long id of student
     * @return List list of courses
     * @throws DaoException dao exception
     * @see CourseStudent
     */
    public abstract List<CourseStudent> findCoursesByStudent(Long studentId) throws DaoException;

    /**
     * Method for insert courseStudent to the database.
     *
     * @param courseStudent
     * @throws DaoException dao exception
     * @see CourseStudent
     */
    public abstract void create(CourseStudent courseStudent) throws DaoException;

    /**
     * Method for delete courseStudent to the database.
     *
     * @param courseId  Long id of course
     * @param studentId Long id of student
     * @throws DaoException dao exception
     */
    public abstract void delete(Long courseId, Long studentId) throws DaoException;

    /**
     * Method for delete course to the database.
     *
     * @param courseId Long id of course
     * @throws DaoException dao exception
     */
    public abstract void deleteCourse(Long courseId) throws DaoException;
}
