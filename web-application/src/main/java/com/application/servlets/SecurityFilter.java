package com.application.servlets;

import com.application.entity.Role;
import com.application.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * SecurityFilter.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class SecurityFilter implements Filter {
    private static final Map<String, Set<Role>> permissions = new HashMap<>();

    static {
        Set<Role> all = new HashSet<>(Arrays.asList(Role.values()));
        Set<Role> admin = new HashSet<>();
        admin.add(Role.ADMIN);
        Set<Role> teacher = new HashSet<>();
        teacher.add(Role.TEACHER);
        Set<Role> student = new HashSet<>();
        student.add(Role.STUDENT);

        Set<Role> teacherAndAdmin = Set.of(Role.ADMIN, Role.TEACHER);

        permissions.put("/logout", all);
        permissions.put("/listCourse", all);
        permissions.put("/listMark", all);

        permissions.put("/listUser", admin);
        permissions.put("/editUser", admin);
        permissions.put("/saveUser", admin);
        permissions.put("/deleteUser", admin);

        permissions.put("/listCoursesStudents", admin);

        permissions.put("/editMark", teacherAndAdmin);
        permissions.put("/saveMark", teacherAndAdmin);
        permissions.put("/deleteMark", teacherAndAdmin);

        permissions.put("/editCourse", teacherAndAdmin);
        permissions.put("/saveCourse", teacherAndAdmin);
        permissions.put("/deleteCourse", teacherAndAdmin);

        permissions.put("/listMyCourses", teacher);

        permissions.put("/listMyMarks", student);
        permissions.put("/saveCoursesStudents", Set.of(Role.ADMIN, Role.STUDENT));
        permissions.put("/deleteCoursesStudents", Set.of(Role.ADMIN, Role.STUDENT));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = httpRequest.getRequestURI();
        String context = httpRequest.getContextPath();
        int postfixIndex = url.lastIndexOf("");
        if (postfixIndex != -1) {
            url = url.substring(context.length(), postfixIndex);
        } else {
            url = url.substring(context.length());
        }
        Set<Role> roles = permissions.get(url);
        if (roles != null) {
            HttpSession session = httpRequest.getSession(false);
            if (session != null) {
                User user = (User) session.getAttribute("currentUser");
                if (user != null && roles.contains(user.getRole())) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        } else {
            chain.doFilter(request, response);
            return;
        }
        httpResponse.sendRedirect(context + "/login?message=Access is denied");
    }
}
