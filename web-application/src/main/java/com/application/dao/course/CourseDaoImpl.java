package com.application.dao.course;

import com.application.dao.DaoException;
import com.application.entity.Course;
import com.application.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.application.Printable.printInfo;

/**
 * Class for implement class CourseDao.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class CourseDaoImpl extends CourseDao {
    private static final String COURSE_TABLE = "course";
    private static final String COURSE_ID = "course_id";
    private static final String COURSE_TITLE = "title";
    private static final String COURSE_TEACHER = "teacher_id";
    private static final String COURSE_DESCRIPTION = "description";


    @Override
    public void create(Course course) throws DaoException {
        String sqlCreate = "INSERT INTO " + COURSE_TABLE
                + " (" + COURSE_TITLE + ", " + COURSE_TEACHER + ", " + COURSE_DESCRIPTION + ") "
                + "VALUES(?,?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlCreate)) {
            statement.setString(1, course.getTitle());
            statement.setLong(2, course.getTeacher().getId());
            statement.setString(3, course.getDescription());

            int rowInsert;
            rowInsert = statement.executeUpdate();
            if (rowInsert > 0) {
                printInfo("Course " + course.getTitle() + " successfully insert");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<Course> readAll() throws DaoException {
        List<Course> courses = new ArrayList<>();

        String sqlRead = "SELECT * FROM " + COURSE_TABLE;
        ResultSet resultSet;

        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(sqlRead);

            Course course;
            while (resultSet.next()) {
                course = new Course();
                course.setTeacher(new User());
                course.setId(resultSet.getLong(1));
                course.setTitle(resultSet.getString(2));
                course.setTeacherID(resultSet.getLong(3));
                course.setDescription(resultSet.getString(4));
                courses.add(course);
            }
            return courses;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public Course findById(Long id) throws DaoException {
        String sqlFindById = "SELECT * FROM " + COURSE_TABLE + " WHERE " + COURSE_ID + "=?";

        ResultSet resultSet;
        Course course = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFindById)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                course = new Course();
                course.setTeacher(new User());
                course.setId(resultSet.getLong(1));
                course.setTitle(resultSet.getString(2));
                course.setTeacherID(resultSet.getLong(3));
                course.setDescription(resultSet.getString(4));
            }
            return course;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public Course findByTitle(String title) throws DaoException {
        String sqlFindById = "SELECT *  FROM " + COURSE_TABLE + " WHERE " + COURSE_TITLE + "=?";

        ResultSet resultSet;
        Course course = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFindById)) {
            statement.setString(1, title);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                course = new Course();
                course.setTeacher(new User());
                course.setId(resultSet.getLong(1));
                course.setTitle(resultSet.getString(2));
                course.setTeacherID(resultSet.getLong(3));
                course.setDescription(resultSet.getString(4));
            }
            return course;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<Course> findCoursesByTeacher(Long id) throws DaoException {
        List<Course> courses = new ArrayList<>();

        String sqlRead = "SELECT * FROM " + COURSE_TABLE + " WHERE " + COURSE_TEACHER + "=?";
        ResultSet resultSet;

        try (PreparedStatement statement = getConnection().prepareStatement(sqlRead)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            Course course;
            while (resultSet.next()) {
                course = new Course();
                course.setTeacher(new User());
                course.setId(resultSet.getLong(1));
                course.setTitle(resultSet.getString(2));
                course.setTeacherID(resultSet.getLong(3));
                course.setDescription(resultSet.getString(4));
                courses.add(course);
            }
            return courses;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(Course course) throws DaoException {
        String sqlUpdate = "UPDATE " + COURSE_TABLE +
                " SET " + COURSE_TITLE + "=?," + COURSE_TEACHER + "=?," + COURSE_DESCRIPTION + "=?"
                + " WHERE " + COURSE_ID + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlUpdate)) {
            statement.setString(1, course.getTitle());
            statement.setLong(2, course.getTeacher().getId());
            statement.setString(3, course.getDescription());

            statement.setLong(4, course.getId());

            int rowUpdate;
            rowUpdate = statement.executeUpdate();

            if (rowUpdate > 0) {
                printInfo("Course " + course.getTitle() + " updated successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sqlDelete = "DELETE FROM " + COURSE_TABLE + " WHERE " + COURSE_ID + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, id);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("Course " + id + " deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }
}
