package com.application.services.course;

import com.application.dao.DaoException;
import com.application.dao.course.CourseDao;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.user.UserDao;
import com.application.entity.Course;
import com.application.entity.CourseStudent;
import com.application.entity.CourseViewState;
import com.application.entity.User;
import com.application.services.exception.ServiceException;
import com.application.services.transaction.Transaction;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Course service implements interface CourseService.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class CourseServiceImpl implements CourseService {
    private Transaction transaction;
    private CourseDao courseDao;
    private UserDao userDao;
    private CourseStudentDao courseStudentDao;

    @Override
    public void setCourseStudentDao(CourseStudentDao courseStudentDao) {
        this.courseStudentDao = courseStudentDao;
    }

    @Override
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public List<Course> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<Course> courses = courseDao.readAll();

            User user;
            for (Course course : courses) {
                user = userDao.findById(course.getTeacher().getId());
                course.setTeacher(user);
            }
            getTransaction().commit();
            return courses;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<Course> findAllCourseByTeacher(Long id) throws ServiceException {
        getTransaction().start();
        List<Course> courses = null;
        try {
            courses = courseDao.findCoursesByTeacher(id);
            getTransaction().commit();
            return courses;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public Course findById(Long id) throws ServiceException {
        try {
            getTransaction().start();
            Course course = courseDao.findById(id);

            User user = userDao.findById(course.getTeacher().getId());
            course.setTeacher(user);
            getTransaction().commit();
            return course;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void save(Course course) throws ServiceException {
        try {
            getTransaction().start();

            User teacher = userDao.findByName(course.getTeacher().getName());
            course.setTeacher(teacher);

            if (course.getId() == null) {
                courseDao.create(course);
            } else {
                courseDao.update(course);
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
            courseDao.delete(id);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public Map<Course, CourseViewState> findAll(User student) throws ServiceException {
        try {
            getTransaction().start();
            List<Course> allCourses = courseDao.readAll();

            User user;
            for (Course course : allCourses) {
                user = userDao.findById(course.getTeacher().getId());
                course.setTeacher(user);
            }

            List<Long> allCoursesIds = allCourses.stream().map(Course::getId).collect(Collectors.toList());
            List<CourseStudent> coursesStudents = Collections.emptyList();
            if (student != null) {
                coursesStudents = courseStudentDao.findCoursesByStudent(student.getId());
            }
            List<Long> subscribeCoursesIds = coursesStudents.stream().map(CourseStudent::getCourse).map(Course::getId).collect(Collectors.toList());
            Map<Course, CourseViewState> mapState = new LinkedHashMap<>();

            for (int i = 0; i < allCoursesIds.size(); i++) {
                if (student != null) {
                    if (subscribeCoursesIds.contains(allCoursesIds.get(i))) {
                        mapState.put(allCourses.get(i), CourseViewState.SUBSCRIBABLE);
                    } else {
                        mapState.put(allCourses.get(i), CourseViewState.UNSUBSCRIBABLE);
                    }
                } else {
                    mapState.put(allCourses.get(i), CourseViewState.EDITABLE);
                }
            }
            getTransaction().commit();
            return mapState;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }
}
