package com.application.services.courses_students;

import com.application.dao.DaoException;
import com.application.dao.course.CourseDao;
import com.application.dao.course_student.CourseStudentDao;
import com.application.dao.user.UserDao;
import com.application.entity.Course;
import com.application.entity.CourseStudent;
import com.application.entity.User;
import com.application.services.exception.ServiceException;
import com.application.services.transaction.Transaction;

import java.util.List;

/**
 * Course service implements interface CourseStudentService.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class CourseStudentServiceImpl implements CourseStudentService {
    private Transaction transaction;
    private CourseStudentDao courseStudentDao;
    private CourseDao courseDao;
    private UserDao userDao;

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void setCourseStudentDao(CourseStudentDao courseStudentDao) {
        this.courseStudentDao = courseStudentDao;
    }

    @Override
    public List<CourseStudent> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<CourseStudent> courseStudents = courseStudentDao.readAll();

            Course course;
            User user;
            for (int i = 0; i < courseStudents.size(); i++) {
                course = courseDao.findById(courseStudents.get(i).getCourse().getId());
                courseStudents.get(i).setCourse(course);

                user = userDao.findById(courseStudents.get(i).getStudent().getId());
                courseStudents.get(i).setStudent(user);
            }
            getTransaction().commit();
            return courseStudents;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void save(CourseStudent courseStudent) throws ServiceException {
        try {
            getTransaction().start();

            if (courseStudent.getStudent().getName() != null && courseStudent.getCourse().getTitle() != null) {
                User student = userDao.findByName(courseStudent.getStudent().getName());
                courseStudent.setStudent(student);

                Course course = courseDao.findByTitle(courseStudent.getCourse().getTitle());
                courseStudent.setCourse(course);
            }
            courseStudentDao.create(courseStudent);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void delete(Long courseId, Long studentId) throws ServiceException {
        try {
            getTransaction().start();
            courseStudentDao.delete(courseId, studentId);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void deleteCourse(Long courseId) throws ServiceException {
        try {
            getTransaction().start();
            courseStudentDao.deleteCourse(courseId);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }
}
