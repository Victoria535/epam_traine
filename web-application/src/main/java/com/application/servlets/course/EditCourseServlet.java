package com.application.servlets.course;

import com.application.entity.Course;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.services.exception.FactoryException;
import com.application.services.exception.ServiceException;
import com.application.services.user.UserService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.application.Printable.printWarning;

/**
 * Class for edit course servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class EditCourseServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Long id = getParameterId(request);

        List<User> allTeachers = null;
        try (Factory factory = getFactory()) {
            UserService userService = factory.getUserService();
            allTeachers = userService.findAllTeachers();
        } catch (ServiceException | FactoryException exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("teachers", allTeachers);

        Course course = null;
        if (id != null) {
            try (Factory factory = getFactory()) {
                CourseService courseService = factory.getCourseService();
                course = courseService.findById(id);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    printWarning(String.valueOf(ex));
                }
            }
        }
        request.setAttribute("course", course);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/course/editCourse.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}

