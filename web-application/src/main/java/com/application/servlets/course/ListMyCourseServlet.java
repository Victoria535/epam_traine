package com.application.servlets.course;

import com.application.entity.Course;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.application.Printable.printWarning;

public class ListMyCourseServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request);

        List<Course> courses = null;
        try (Factory factory = getFactory()) {
            CourseService courseService = factory.getCourseService();
            if (user != null) {
                courses = courseService.findAllCourseByTeacher(user.getId());
            }
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }
        request.setAttribute("courses", courses);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/course/listMyCourses.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
