package services;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.user.UserServiceImpl;
import com.application.services.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final Long USER_ID = 1L;
    private User user;
    private User userNotAdd;

    @Mock
    private Dao<User> dao;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setName("user");
        user.setLogin("user");
        user.setPassword("user");
        user.setRole(Role.STUDENT);

        userNotAdd = new User();
        userNotAdd.setName(null);
        userNotAdd.setLogin(null);
        userNotAdd.setPassword(null);
    }

    @Test
    public void whenFindAllThenSuccess() throws DaoException, ServiceException {
        List<User> expected = Collections.singletonList(user);
        when(dao.readAll()).thenReturn(expected);
        List<User> actual = userServiceImpl.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void whenFindByIdThenSuccess() throws ServiceException, DaoException {
        user.setId(USER_ID);
        when(dao.findById(USER_ID)).thenReturn(user);
        User actualUser = userServiceImpl.findById(USER_ID);
        assertEquals(user, actualUser);
    }

    @Test
    public void whenCreateThenSuccess() throws ServiceException, DaoException {
        userServiceImpl.save(user);
        verify(dao, times(1)).create(user);
    }

    @Test
    public void whenUpdateThenSuccess() throws ServiceException, DaoException {
        user.setId(USER_ID);
        userServiceImpl.save(user);
        verify(dao, times(1)).update(user);
    }

    @Test
    public void whenDeleteThenReturn() throws DaoException, ServiceException {
        userServiceImpl.delete(USER_ID);
        verify(dao, times(1)).delete(USER_ID);
    }
}
