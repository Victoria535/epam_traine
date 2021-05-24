package com.application.servlets.user;

import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.user.UserService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.application.Printable.printWarning;

/**
 * Class for list users servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class ListUserServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = null;
        try (Factory factory = getFactory()) {
            UserService userService = factory.getUserService();
            users = userService.findAll();
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }
        request.setAttribute("users", users);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/user/listUser.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
