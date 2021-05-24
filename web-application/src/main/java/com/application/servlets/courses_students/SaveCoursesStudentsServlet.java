package com.application.servlets.courses_students;

import com.application.Printable;
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
 * Class for save coursesStudents servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class SaveCoursesStudentsServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Long courseId = null;
        Long studentId = null;
        try {
            courseId = Long.valueOf(request.getParameter("courseId"));
            studentId = Long.valueOf(request.getParameter("studentId"));
        } catch (NumberFormatException exception) {
            printWarning(String.valueOf(exception));
        }
        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setCourse(new Course());
        courseStudent.setStudent(new User());

        if (courseId != null && studentId != null) {
            try {
                courseStudent.setCourseId(courseId);
                courseStudent.setStudentId(studentId);
            } catch (NumberFormatException exception) {
                printWarning(String.valueOf(exception));
            }
        }

        String courseTitle = request.getParameter("courseTitle");
        String studentName = request.getParameter("studentName");
        Mark mark = new Mark();
        mark.setStudent(new User());
        mark.setStudentID(studentId);
        mark.setStudentName(studentName);

        mark.setCourse(new Course());
        mark.setCourseID(courseId);
        mark.setCourseTitle(courseTitle);

        try (Factory factory = getFactory()) {
            MarkService markService = factory.getMarkService();
            markService.save(mark);

            CourseStudentService courseStudentService = getFactory().getCourseStudentService();
            courseStudentService.save(courseStudent);
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                Printable.printWarning(String.valueOf(ex));
            }
        }

        try {
            response.sendRedirect(request.getContextPath() + "/listCourse");
        } catch (IOException exception) {
            Printable.printWarning(String.valueOf(exception));
        }
    }
}
