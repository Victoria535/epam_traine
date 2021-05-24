package com.application.servlets;

import com.application.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for main page servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class MainPageServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = getSessionUser(request);

        try {
            if (user != null) {
                switch (user.getRole()) {
                    case ADMIN:
                        response.sendRedirect(request.getContextPath() + "/listUser");
                        return;
                    case STUDENT:
                    case TEACHER:
                        response.sendRedirect(request.getContextPath() + "/listCourse");
                        return;
                    default:
                        response.sendRedirect(request.getContextPath() + "/listCourse");
                }
            }
            response.sendRedirect(request.getContextPath() + "/login");
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}

