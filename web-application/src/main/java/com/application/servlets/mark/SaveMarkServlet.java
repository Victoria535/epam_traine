package com.application.servlets.mark;

import com.application.entity.Course;
import com.application.entity.CourseStudent;
import com.application.entity.Mark;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.courses_students.CourseStudentService;
import com.application.services.mark.MarkService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for save mark servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class SaveMarkServlet extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String student = request.getParameter("student");
        String course = request.getParameter("course");
        int markCourse = 0;
        try {
            markCourse = Integer.parseInt(request.getParameter("mark"));
        } catch (NumberFormatException exception) {
            printWarning(String.valueOf(exception));
        }

        Mark mark = new Mark();
        mark.setStudent(new User());
        mark.setStudentName(student);
        mark.setCourse(new Course());
        mark.setCourseTitle(course);
        mark.setMark(markCourse);

        if (id != null) {
            try {
                mark.setId(Long.valueOf(id));
            } catch (NumberFormatException exception) {
                printWarning(String.valueOf(exception));
            }
        }
        try (Factory factory = getFactory()) {
            MarkService markService = factory.getMarkService();
            markService.save(mark);

            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setStudent(new User());
            courseStudent.setCourse(new Course());
            courseStudent.setStudentName(student);
            courseStudent.setCourseTile(course);

            CourseStudentService courseStudentService = getFactory().getCourseStudentService();
            courseStudentService.save(courseStudent);
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }

        try {
            response.sendRedirect(request.getContextPath() + "/listMark");
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}

