package com.application.dao.user;

import com.application.dao.DaoException;
import com.application.entity.Role;
import com.application.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.application.Printable.printInfo;

/**
 * Class for implement class UserDao.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class UserDaoImpl extends UserDao {
    private static final String USER_TABLE = "user";
    private static final String USER_ID = "id";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String USER_NAME = "name";
    private static final String USER_ROLE = "role";

    @Override
    public void create(User user) throws DaoException {
        String sqlInsert = "INSERT INTO " + USER_TABLE
                + " (" + USER_LOGIN + ", " + USER_PASSWORD + ", " + USER_NAME + ", " + USER_ROLE + ") "
                + "VALUES(?,?,?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlInsert)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, String.valueOf(user.getRole()));

            int rowInserted;
            rowInserted = statement.executeUpdate();

            if (rowInserted > 0) {
                printInfo("user " + user.getName() + " successfully added.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public List<User> readAll() throws DaoException {
        String sqlRead = "SELECT * FROM " + USER_TABLE;
        List<User> users = new ArrayList<>();

        ResultSet resultSet;
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(sqlRead);

            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setRole(Role.valueOf(resultSet.getString(5)));
                users.add(user);
            }
            return users;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public User findById(Long id) throws DaoException {
        String sqlFindById = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_ID + "=?";

        ResultSet resultSet;
        User user = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFindById)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setRole(Role.valueOf(resultSet.getString(5)));
            }
            return user;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public User findByName(String name) throws DaoException {
        String sqlFindById = "SELECT *  FROM " + USER_TABLE + " WHERE " + USER_NAME + "=?";

        ResultSet resultSet;
        User user = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFindById)) {
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setRole(Role.valueOf(resultSet.getString(5)));
            }
            return user;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws DaoException {
        String sqlFind = "SELECT * FROM " + USER_TABLE +
                " WHERE " + USER_LOGIN + "=? AND " + USER_PASSWORD + "=?";

        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sqlFind)) {
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setName(resultSet.getString("name"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }

            return user;
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        String sqlUpdate = "Update " + USER_TABLE +
                " SET " + USER_NAME + "=?," + USER_LOGIN + "=?," + USER_PASSWORD + "=?," + USER_ROLE + "=?"
                + "WHERE " + USER_ID + "=?";
        try (PreparedStatement statement = getConnection().prepareStatement(sqlUpdate)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, String.valueOf(user.getRole()));

            statement.setLong(5, user.getId());

            int rowUpdate;
            rowUpdate = statement.executeUpdate();

            if (rowUpdate > 0) {
                printInfo("User " + user.getName() + " updated successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException();
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sqlDelete = "DELETE FROM " + USER_TABLE + " WHERE " + USER_ID + "=?";

        try (PreparedStatement statement = getConnection().prepareStatement(sqlDelete)) {
            statement.setLong(1, id);

            int rowDelete;
            rowDelete = statement.executeUpdate();

            if (rowDelete > 0) {
                printInfo("User " + id + " deleted successfully.");
            }
        } catch (SQLException exception) {
            throw new DaoException(exception);
        }
    }
}
