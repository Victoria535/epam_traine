package com.application.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Servlet for log out.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class LogoutServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        try {
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
