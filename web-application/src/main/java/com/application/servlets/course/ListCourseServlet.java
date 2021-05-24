package com.application.servlets.course;

import com.application.entity.Course;
import com.application.entity.CourseViewState;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.application.Printable.printWarning;

/**
 * Class for list course servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class ListCourseServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request);

        Map<Course, CourseViewState> stateMap = new LinkedHashMap<>();

        try (Factory factory = getFactory()) {
            CourseService courseService = factory.getCourseService();
            if (user != null) {
                if (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.TEACHER)) {
                    stateMap = courseService.findAll(null);
                }

                if (user.getRole().equals(Role.STUDENT)) {
                    stateMap = courseService.findAll(user);
                }
            }
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }

        request.setAttribute("courses", stateMap);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/course/listCourse.jsp").forward(request, response);
        } catch (IOException | ServletException exception) {
            printWarning(String.valueOf(exception));
        }
    }


}
