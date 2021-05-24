package com.application.dao.course;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.entity.Course;

import java.util.List;

/**
 * Class for data access object Course.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public abstract class CourseDao extends Dao<Course> {

    /**
     * Method for find course by title.
     *
     * @param title String title to course
     * @return Course course
     * @throws DaoException exception to dao
     * @see Course
     */
    public abstract Course findByTitle(String title) throws DaoException;

    /**
     * Method for find course by teacher.
     *
     * @param id Long title to course
     * @return List list of courses
     * @throws DaoException exception to dao
     * @see Course
     */
    public abstract List<Course> findCoursesByTeacher(Long id) throws DaoException;
}
