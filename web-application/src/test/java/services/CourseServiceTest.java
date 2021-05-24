package services;

import com.application.dao.Dao;
import com.application.dao.DaoException;
import com.application.entity.Course;
import com.application.services.course.CourseServiceImpl;
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
public class CourseServiceTest {
    private static final Long ID = 1L;
    private Course course;

    @Mock
    private Dao<Course> dao;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Before
    public void setUp() {
        course = new Course();
        course.setTitle("title");
        course.setDescription("description");
    }

    @Test
    public void whenFindAllThenSuccess() throws DaoException, ServiceException {
        List<Course> expected = Collections.singletonList(course);
        when(dao.readAll()).thenReturn(expected);
        List<Course> actual = courseService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void whenFindByIdThenSuccess() throws ServiceException, DaoException {
        course.setId(ID);
        when(dao.findById(ID)).thenReturn(course);
        Course actualCourse = courseService.findById(ID);
        assertEquals(course, actualCourse);
    }

    @Test
    public void whenCreateThenSuccess() throws ServiceException, DaoException {
        courseService.save(course);
        verify(dao, times(1)).create(course);
    }

    @Test
    public void whenUpdateThenSuccess() throws ServiceException, DaoException {
        course.setId(ID);
        courseService.save(course);
        verify(dao, times(1)).update(course);
    }

    @Test
    public void whenDeleteThenReturn() throws ServiceException, DaoException {
        courseService.delete(ID);
        verify(dao, times(1)).delete(ID);
    }
}
