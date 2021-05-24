package com.application.services.course;

import com.application.dao.course.CourseDao;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.user.UserDao;
import com.application.entity.Course;
import com.application.entity.CourseViewState;
import com.application.entity.User;
import com.application.services.Service;
import com.application.services.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Interface for course service.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public interface CourseService extends Service {
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
     * Method for setting courseStudentDao.
     *
     * @param courseStudentDao CourseStudentDao courseStudent dao
     */
    void setCourseStudentDao(CourseStudentDao courseStudentDao);

    /**
     * Method for find all courses.
     *
     * @return List list of courses
     * @throws ServiceException exception of service
     * @see Course
     */
    List<Course> findAll() throws ServiceException;

    /**
     * Method for find all courses by teacher.
     *
     * @param id Long id of teacher
     * @return List list of courses
     * @throws ServiceException exception of service
     */
    List<Course> findAllCourseByTeacher(Long id) throws ServiceException;

    /**
     * Method for find course by id.
     *
     * @param id Long id of course
     * @return Course course
     * @throws ServiceException exception of service
     * @see Course
     */
    Course findById(Long id) throws ServiceException;

    /**
     * Method for save of course.
     *
     * @param course Course course
     * @throws ServiceException exception of service
     * @see Course
     */
    void save(Course course) throws ServiceException;

    /**
     * Method for delete of course.
     *
     * @param id Long id of course
     * @throws ServiceException exception of service
     */
    void delete(Long id) throws ServiceException;

    /**
     * Method for find all courses with course state.
     *
     * @param student User
     * @return Map map of courses
     * @throws ServiceException exception of service
     * @see User
     */
    Map<Course, CourseViewState> findAll(User student) throws ServiceException;
}
