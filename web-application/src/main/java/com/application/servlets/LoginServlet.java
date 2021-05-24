package com.application.servlets;

import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Servlet for login.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class LoginServlet extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            try (Factory factory = getFactory()) {
                UserService userService = factory.getUserService();
                User user = userService.login(login, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("currentUser", user);
                    response.sendRedirect(request.getContextPath() + "/listCourses");
                    return;
                }
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    printWarning(String.valueOf(ex));
                }
            }
        }
        try {
            response.sendRedirect(request.getContextPath() + "/login?message="
                    + "Invalid username or password. You cannot log in.");
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
