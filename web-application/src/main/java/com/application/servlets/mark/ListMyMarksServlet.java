package com.application.servlets.mark;

import com.application.Printable;
import com.application.entity.Mark;
import com.application.entity.User;
import com.application.services.Factory;
import com.application.services.mark.MarkService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.application.Printable.printWarning;

/**
 * Class for list marks a student servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class ListMyMarksServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        User user = getSessionUser(request);

        List<Mark> marks = null;
        try (Factory factory = getFactory()) {
            MarkService markService = factory.getMarkService();
            if (user != null) {
                marks = markService.findMarkByStudent(user.getId());
            }
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                Printable.printWarning(String.valueOf(ex));
            }
        }
        request.setAttribute("marks", marks);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/mark/listMyMarks.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
