package com.application.servlets.courses_students;

import com.application.entity.CourseStudent;
import com.application.services.Factory;
import com.application.services.courses_students.CourseStudentService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.application.Printable.printWarning;

/**
 * Class for list coursesStudents servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class ListCoursesStudentsServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<CourseStudent> courseStudents = null;
        try (Factory factory = getFactory()) {
            CourseStudentService courseStudentService = factory.getCourseStudentService();
            courseStudents = courseStudentService.findAll();
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }
        request.setAttribute("courses", courseStudents);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/coursesStudents/listCoursesStudents.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
