package com.application.servlets.mark;

import com.application.Printable;
import com.application.entity.Mark;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.services.mark.MarkService;
import com.application.services.user.UserService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for edit mark servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class EditMarkServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        User user = getSessionUser(request);

        try (Factory factory = getFactory()) {
            UserService userService = factory.getUserService();
            CourseService courseService = getFactory().getCourseService();

            request.setAttribute("students", userService.findAllStudents());
            request.setAttribute("courses", courseService.findAll());
            if (user != null) {
                request.setAttribute("myCourses", courseService.findAllCourseByTeacher(user.getId()));
            }
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                Printable.printWarning(String.valueOf(ex));
            }
        }

        Long id = getParameterId(request);
        Mark mark = null;
        if (id != null) {
            try (Factory factory = getFactory()) {
                MarkService markService = factory.getMarkService();
                mark = markService.findById(id);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    Printable.printWarning(String.valueOf(ex));
                }
            }
        }

        request.setAttribute("mark", mark);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/mark/editMark.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
