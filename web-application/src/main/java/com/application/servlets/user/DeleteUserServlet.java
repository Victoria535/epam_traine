package com.application.servlets.user;

import com.application.services.Factory;
import com.application.services.user.UserService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for delete user servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class DeleteUserServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Long id = null;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException exception) {
            printWarning(String.valueOf(exception));
        }
        if (id != null) {
            try (Factory factory = getFactory()) {
                UserService userService = factory.getUserService();
                userService.delete(id);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    printWarning(String.valueOf(ex));
                }
            }

            try {
                response.sendRedirect(request.getContextPath() + "/listUser");
            } catch (IOException exception) {
                printWarning(String.valueOf(exception));
            }
        }
    }
}

