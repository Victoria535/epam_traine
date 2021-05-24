package com.application.services.mark;

import com.application.dao.course.CourseDao;
import com.application.dao.mark.MarkDao;
import com.application.dao.user.UserDao;
import com.application.entity.Mark;
import com.application.services.Service;
import com.application.services.exception.ServiceException;

import java.util.List;

/**
 * Interface for mark service.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public interface MarkService extends Service {
    /**
     * Method for setting markDao.
     *
     * @param markDao MarkDao mark dao
     */
    void setMarkDao(MarkDao markDao);

    /**
     * Method for setting userDao.
     *
     * @param userDao UserDao user dao
     */
    void setUserDao(UserDao userDao);

    /**
     * Method for setting courseDao.
     *
     * @param courseDao CourseDao course dao
     */
    void setCourseDao(CourseDao courseDao);

    /**
     * Method for find all marks.
     *
     * @return List list of marks
     * @throws ServiceException exception of service
     * @see Mark
     */
    List<Mark> findAll() throws ServiceException;

    /**
     * Method for find mark by id.
     *
     * @param id Long id of mark
     * @return Mark mark
     * @throws ServiceException exception of service
     * @see Mark
     */
    Mark findById(Long id) throws ServiceException;

    /**
     * Method for find mark by student.
     *
     * @param id Long id of student
     * @return List list of marks
     * @throws ServiceException exception of service
     * @see Mark
     */
    List<Mark> findMarkByStudent(Long id) throws ServiceException;

    /**
     * Method for save of mark.
     *
     * @param mark Mark mark
     * @throws ServiceException exception of service
     * @see Mark
     */
    void save(Mark mark) throws ServiceException;

    /**
     * Method for delete of mark.
     *
     * @param id Long id of mark
     * @throws ServiceException exception of service
     */
    void delete(Long id) throws ServiceException;

    /**
     * Method for delete of mark by course.
     *
     * @param id Long id of mark
     * @throws ServiceException exception of service
     */
    void deleteCourse(Long id) throws ServiceException;
}
