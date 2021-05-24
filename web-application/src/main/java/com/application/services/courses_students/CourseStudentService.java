package com.application.services.courses_students;

import com.application.dao.course.CourseDao;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.user.UserDao;
import com.application.entity.CourseStudent;
import com.application.services.Service;
import com.application.services.exception.ServiceException;

import java.util.List;

/**
 * CourseStudent service.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public interface CourseStudentService extends Service {
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
     * Method for setting CourseStudentDao.
     *
     * @param courseStudentDao CourseStudentDao courseStudent dao
     */
    void setCourseStudentDao(CourseStudentDao courseStudentDao);


    /**
     * Method for find all courseStudent.
     *
     * @return List list of courseStudent
     * @throws ServiceException exception of service
     * @see CourseStudent
     */
    List<CourseStudent> findAll() throws ServiceException;

    /**
     * Method for save of courseStudent.
     *
     * @param courseStudent CourseStudent courseStudent
     * @throws ServiceException exception of service
     * @see CourseStudent
     */
    void save(CourseStudent courseStudent) throws ServiceException;

    /**
     * Method for delete of courseStudents.
     *
     * @param courseId  Long id of course
     * @param studentId Long id of student
     * @throws ServiceException exception of service
     */
    void delete(Long courseId, Long studentId) throws ServiceException;

    /**
     * Method for delete of courseStudents by course.
     *
     * @param courseId Long id of course
     * @throws ServiceException exception of service
     */
    void deleteCourse(Long courseId) throws ServiceException;
}
