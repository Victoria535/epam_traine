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
 * Class for save user servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class SaveUserServlet extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Role role = Role.valueOf(request.getParameter("role"));

        User user = null;
        if (!login.isEmpty() && !password.isEmpty() && !name.isEmpty()) {
            user = new User(login, password, name, role);
            if (id != null) {
                try {
                    user.setId(Long.valueOf(id));
                } catch (NumberFormatException exception) {
                    printWarning(String.valueOf(exception));
                }
            }
            try (Factory factory = getFactory()) {
                UserService userService = factory.getUserService();
                userService.save(user);
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
        } else {
            try {
                response.sendRedirect(request.getContextPath() + "/editUser?id=" + id + "&message="
                        + "Complete the empty fields.");
            } catch (IOException exception) {
                printWarning(String.valueOf(exception));
            }
        }
    }
}
