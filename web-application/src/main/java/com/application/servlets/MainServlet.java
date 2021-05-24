package com.application.servlets;

import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.FactoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.application.Printable.printWarning;

/**
 * Class for getting Factory.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public abstract class MainServlet extends HttpServlet {
    private Factory factory;

    /**
     * Method for getting field factory.
     *
     * @return Factory field factory
     * @see Factory
     */
    public Factory getFactory() {
        if (factory == null) {
            factory = new FactoryImpl();
        }
        return factory;
    }

    /**
     * Method fro getting session user.
     *
     * @param request HttpServletRequest request
     * @return User user
     */
    public User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("currentUser");
        }
        return user;
    }

    /**
     * Method for getting parameter id.
     *
     * @param request HttpServletRequest request
     * @return Long
     */
    public Long getParameterId(HttpServletRequest request) {
        Long id = null;
        try {
            id = Long.valueOf(request.getParameter("id"));
        } catch (NumberFormatException exception) {
            printWarning(String.valueOf(exception));
        }
        return id;
    }
}
