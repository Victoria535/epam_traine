package com.application.dao.course_student;

import com.application.dao.DaoException;
import com.application.entity.Course;
import com.application.entity.CourseStudent;
import com.application.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.application.Printable.printInfo;

/**
 * Class for implement class CourseStudentDao.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class CourseStudentDaoImpl extends CourseStudentDao {
    private static final String COURSE_TABLE = "course_student";
    private static final String COURSE = "course";
    private static final String STUDENT = "student";

    @Override
    public void create(CourseStudent courseStudent) throws DaoException {
        String sqlCreate = "INSERT INTO course_student (course, student) "
                + "VALUES(?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlCreate)) {
            statement.setLong(1, courseStudent.getCourse().getId());
            statement.setLong(2, courseStudent.getStudent().getId());

            int rowInsert;
            rowInsert = statement.executeUpdate();
            if (rowInsert > 0) {
                printInfo("Course_student add successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<CourseStudent> readAll() throws DaoException {
        List<CourseStudent> courseStudentList = new ArrayList<>();

        String sqlRead = "SELECT * FROM " + COURSE_TABLE;
        ResultSet resultSet;

        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(sqlRead);

            CourseStudent courseStudent;
            while (resultSet.next()) {
                courseStudent = new CourseStudent();
                courseStudent.setStudent(new User());
                courseStudent.setCourse(new Course());
                courseStudent.setCourseId(resultSet.getLong(1));
                courseStudent.setStudentId(resultSet.getLong(2));
                courseStudentList.add(courseStudent);
            }
            return courseStudentList;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<CourseStudent> findCoursesByStudent(Long studentId) throws DaoException {
        List<CourseStudent> courseStudentList = new ArrayList<>();

        String sqlFind = "SELECT * FROM " + COURSE_TABLE + " WHERE " + STUDENT + "=?";
        ResultSet resultSet;

        try (PreparedStatement statement = getConnection().prepareStatement(sqlFind)) {
            statement.setLong(1, studentId);
            resultSet = statement.executeQuery();

            CourseStudent courseStudent;
            while (resultSet.next()) {
                courseStudent = new CourseStudent();
                courseStudent.setStudent(new User());
                courseStudent.setCourse(new Course());
                courseStudent.setCourseId(resultSet.getLong(1));
                courseStudent.setStudentId(resultSet.getLong(2));
                courseStudentList.add(courseStudent);
            }
            return courseStudentList;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void delete(Long courseId, Long studentId) throws DaoException {
        String sqlDelete = "DELETE FROM " + COURSE_TABLE + " WHERE " + COURSE + "=? AND " + STUDENT + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, courseId);
            statement.setLong(2, studentId);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("CourseStudent deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void deleteCourse(Long courseId) throws DaoException {
        String sqlDelete = "DELETE FROM " + COURSE_TABLE + " WHERE " + COURSE + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, courseId);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("CourseStudent deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }
}
