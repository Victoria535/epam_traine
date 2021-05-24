package dao;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.dao.user.UserDaoImpl;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.FactoryImpl;
import com.application.services.exception.FactoryException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
    @Mock
    DataSource dataSource;
    @Mock
    Connection connection;
    @Mock
    ResultSet resultSet;
    @Mock
    PreparedStatement preparedStatement;
    @InjectMocks
    private Dao<User> dao;

    private User user;


    @Before
    public void setUp() throws SQLException {
        when(dataSource.getConnection()).thenReturn(connection);

        user = new User();
        user.setId(1L);
        user.setLogin("user");
        user.setPassword("user");
        user.setName("user");
        user.setRole(Role.STUDENT);

        when(resultSet.first()).thenReturn(true);
        when(resultSet.getLong(1)).thenReturn(user.getId());
        when(resultSet.getString(2)).thenReturn(user.getLogin());
        when(resultSet.getString(3)).thenReturn(user.getPassword());
        when(resultSet.getString(4)).thenReturn(user.getName());
        when(resultSet.getString(5)).thenReturn(String.valueOf(user.getRole()));

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }


    @Test
    public void whenReadAllThenSuccess() throws DaoException, FactoryException {
        Factory factory = new FactoryImpl();
        dao = factory.getUserDao();

        List<User> userList = dao.readAll();
        for (User user : userList) {
            System.out.println(user.toString() + " ");
        }
    }

    @Test
    public void whenCreateThenSuccess() throws DaoException {
        dao = new UserDaoImpl();
        dao.create(user);
    }


    @After
    public void deleteUser() {

    }
}
