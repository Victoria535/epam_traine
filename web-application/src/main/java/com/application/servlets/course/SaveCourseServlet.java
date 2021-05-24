package com.application.servlets.course;

import com.application.entity.Course;
import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.course.CourseService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for save course servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class SaveCourseServlet extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request);

        Long id = getParameterId(request);
        String teacher = request.getParameter("teacher");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (!title.isEmpty() && !description.isEmpty()) {

            Course course = new Course();
            course.setTitle(title);
            course.setTeacher(new User());
            course.setTeacherName(teacher);
            course.setDescription(description);
            course.setId(id);

            try (Factory factory = getFactory()) {
                CourseService courseService = factory.getCourseService();
                courseService.save(course);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception exception1) {
                    printWarning(String.valueOf(exception1));
                }
            }


            if (user != null) {
                if (user.getRole().equals(Role.ADMIN)) {
                    redirect(request, response, "/listCourse");
                } else {
                    redirect(request, response, "/listMyCourses");
                }
            }
        } else {
            redirect(request, response, "/editCourse?id=" + id + "&message=" + "Complete the empty fields.");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String message) {
        try {
            response.sendRedirect(request.getContextPath() + message);
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}

