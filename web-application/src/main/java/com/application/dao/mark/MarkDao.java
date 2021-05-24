package com.application.dao.mark;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.entity.Mark;

import java.util.List;

/**
 * Class for data access object Mark.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public abstract class MarkDao extends Dao<Mark> {
    /**
     * Method for find mark by student.
     *
     * @param id Long id of course
     * @return List list of marks
     * @throws DaoException dao exception
     * @see Mark
     */
    public abstract List<Mark> findMarkByStudent(Long id) throws DaoException;

    /**
     * Method for delete course to the database.
     *
     * @param id Long id of course
     * @throws DaoException dao exception
     */
    public abstract void deleteCourse(Long id) throws DaoException;
}
