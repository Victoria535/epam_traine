package com.application.servlets.user;

import com.application.entity.Role;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.user.UserService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.application.Printable.printWarning;

/**
 * Class for edit user servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class EditUserServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("roles", Role.values());

        Long id = getParameterId(request);
        User user = null;
        if (id != null) {
            try (Factory factory = getFactory()) {
                UserService userService = factory.getUserService();
                user = userService.findById(id);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    printWarning(String.valueOf(ex));
                }
            }
        }

        request.setAttribute("user", user);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/user/editUser.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
