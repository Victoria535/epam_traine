package com.application.servlets.courses_students;

import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.courses_students.CourseStudentService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;


/**
 * Class for delete coursesStudents servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class DeleteCoursesStudentsServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        User user = getSessionUser(request);

        long courseId = 0;
        long studentId = 0;
        try {
            courseId = Long.parseLong(request.getParameter("courseId"));
            studentId = Long.parseLong(request.getParameter("studentId"));

        } catch (NumberFormatException exception) {
            printWarning(String.valueOf(exception));
        }

        try (Factory factory = getFactory()) {
            CourseStudentService courseStudentService = factory.getCourseStudentService();
            courseStudentService.delete(courseId, studentId);
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }
        try {
            if (user != null) {
                if (user.getRole().equals(Role.ADMIN)) {
                    response.sendRedirect(request.getContextPath() + "/listCoursesStudents");
                } else {
                    response.sendRedirect(request.getContextPath() + "/listCourse");
                }
            }
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
