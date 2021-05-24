package com.application.servlets.course;

import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.services.courses_students.CourseStudentService;
import com.application.services.mark.MarkService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for delete course servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class DeleteCourseServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request);

        Long id = getParameterId(request);
        try (Factory factory = getFactory()) {
            CourseService courseService = factory.getCourseService();
            courseService.delete(id);

            CourseStudentService courseStudentService = factory.getCourseStudentService();
            courseStudentService.deleteCourse(id);

            MarkService markService = factory.getMarkService();
            markService.deleteCourse(id);
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }

        if (user != null) {
            try {
                if (user.getRole().equals(Role.ADMIN)) {
                    response.sendRedirect(request.getContextPath() + "/listCourse");
                } else {
                    response.sendRedirect(request.getContextPath() + "/listMyCourses");
                }
            } catch (IOException exception) {
                printWarning(String.valueOf(exception));
            }
        }
    }
}
