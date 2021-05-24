package com.application.dao.mark;

import com.application.dao.DaoException;
import com.application.entity.Course;
import com.application.entity.Mark;
import com.application.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.application.Printable.printInfo;

/**
 * Class for implement class MarkDao.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class MarkDaoImpl extends MarkDao {
    private static final String MARK_TABLE = "mark";
    private static final String MARK_ID = "id";
    private static final String MARK_STUDENT = "student";
    private static final String MARK_COURSE = "course";
    private static final String MARK_MARK = "mark";


    @Override
    public void create(Mark mark) throws DaoException {
        String sqlCreate = "INSERT INTO " + MARK_TABLE
                + " (" + MARK_STUDENT + ", " + MARK_COURSE + ", " + MARK_MARK + ") "
                + "VALUES(?,?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlCreate)) {
            statement.setLong(1, mark.getStudent().getId());
            statement.setLong(2, mark.getCourse().getId());
            statement.setInt(3, mark.getMark());

            int rowInsert;
            rowInsert = statement.executeUpdate();
            if (rowInsert > 0) {
                printInfo("Mark for course " + mark.getCourse() + " successfully insert");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<Mark> readAll() throws DaoException {
        List<Mark> listMarks = new ArrayList<>();

        String sqlRead = "SELECT * FROM " + MARK_TABLE;
        ResultSet resultSet;

        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(sqlRead);

            Mark mark;
            while (resultSet.next()) {
                mark = new Mark();
                mark.setCourse(new Course());
                mark.setStudent(new User());
                mark.setId(resultSet.getLong(1));
                mark.setStudentID(resultSet.getLong(2));
                mark.setCourseID(resultSet.getLong(3));
                mark.setMark(resultSet.getInt(4));
                listMarks.add(mark);
            }
            return listMarks;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public Mark findById(Long id) throws DaoException {
        String sqlFindById = "SELECT * FROM " + MARK_TABLE + " WHERE " + MARK_ID + "=?";

        ResultSet resultSet;
        Mark mark = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFindById)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                mark = new Mark();
                mark.setCourse(new Course());
                mark.setStudent(new User());
                mark.setId(resultSet.getLong(1));
                mark.setStudentID(resultSet.getLong(2));
                mark.setCourseID(resultSet.getLong(3));
                mark.setMark(resultSet.getInt(4));
            }
            return mark;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }


    @Override
    public List<Mark> findMarkByStudent(Long id) throws DaoException {
        List<Mark> marks = new ArrayList<>();
        String sqlFind = "SELECT * FROM " + MARK_TABLE + " WHERE " + MARK_STUDENT + "=?";

        ResultSet resultSet;
        Mark mark = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFind)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                mark = new Mark();
                mark.setCourse(new Course());
                mark.setStudent(new User());
                mark.setId(resultSet.getLong(1));
                mark.setStudentID(resultSet.getLong(2));
                mark.setCourseID(resultSet.getLong(3));
                mark.setMark(resultSet.getInt(4));
                marks.add(mark);
            }
            return marks;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }


    @Override
    public void update(Mark mark) throws DaoException {
        String sqlUpdate = "Update " + MARK_TABLE + " SET " + MARK_STUDENT + "=?," + MARK_COURSE + "=?,"
                + MARK_MARK + "=?" + " WHERE " + MARK_ID + "=?";
        try (PreparedStatement statement = getConnection().prepareStatement(sqlUpdate)) {
            statement.setLong(1, mark.getStudent().getId());
            statement.setLong(2, mark.getCourse().getId());
            statement.setInt(3, mark.getMark());

            statement.setLong(4, mark.getId());

            int rowUpdate;
            rowUpdate = statement.executeUpdate();

            if (rowUpdate > 0) {
                printInfo("Mark updated successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sqlDelete = "DELETE FROM " + MARK_TABLE + " WHERE " + MARK_ID + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, id);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("Mark " + id + " deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void deleteCourse(Long id) throws DaoException {
        String sqlDelete = "DELETE FROM " + MARK_TABLE + " WHERE " + MARK_COURSE + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, id);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("Mark " + id + " deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }
}

