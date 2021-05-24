package com.application.services.mark;

import com.application.dao.DaoException;
import com.application.dao.course.CourseDao;
import com.application.dao.mark.MarkDao;
import com.application.dao.user.UserDao;
import com.application.entity.Course;
import com.application.entity.Mark;
import com.application.entity.User;
import com.application.services.exception.ServiceException;
import com.application.services.transaction.Transaction;

import java.util.List;

/**
 * Course service implements interface MarkService.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class MarkServiceImpl implements MarkService {
    private Transaction transaction;
    private MarkDao markDao;
    private CourseDao courseDao;
    private UserDao userDao;

    @Override
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }

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

    @Override
    public List<Mark> findAll() throws ServiceException {
        try {
            getTransaction().start();
            List<Mark> marks = markDao.readAll();

            Course course;
            User user;
            for (Mark mark : marks) {
                course = courseDao.findById(mark.getCourse().getId());
                mark.setCourse(course);

                user = userDao.findById(mark.getStudent().getId());
                mark.setStudent(user);
            }
            getTransaction().commit();
            return marks;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public Mark findById(Long id) throws ServiceException {
        try {
            getTransaction().start();
            Mark mark = markDao.findById(id);

            Course course = courseDao.findById(mark.getCourse().getId());
            mark.setCourse(course);

            User user = userDao.findById(mark.getStudent().getId());
            mark.setStudent(user);
            getTransaction().commit();
            return mark;
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public List<Mark> findMarkByStudent(Long id) throws ServiceException {
        getTransaction().start();
        List<Mark> marks = null;
        try {
            marks = markDao.findMarkByStudent(id);

            Course course;
            User user;
            for (Mark mark : marks) {
                course = courseDao.findById(mark.getCourse().getId());
                mark.setCourse(course);

                user = userDao.findById(mark.getStudent().getId());
                mark.setStudent(user);
            }
            getTransaction().commit();
            return marks;
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public void save(Mark mark) throws ServiceException {
        try {
            getTransaction().start();
            User student = userDao.findByName(mark.getStudent().getName());
            mark.setStudent(student);

            Course course = courseDao.findByTitle(mark.getCourse().getTitle());
            mark.setCourse(course);

            if (mark.getId() == null) {
                markDao.create(mark);
            } else {
                markDao.update(mark);
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
            markDao.delete(id);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }

    @Override
    public void deleteCourse(Long id) throws ServiceException {
        try {
            getTransaction().start();
            markDao.deleteCourse(id);
            getTransaction().commit();
        } catch (DaoException exception) {
            getTransaction().rollback();
            throw new ServiceException(exception);
        }
    }
}
