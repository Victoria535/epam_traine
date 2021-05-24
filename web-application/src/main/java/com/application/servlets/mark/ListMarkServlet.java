package com.application.servlets.mark;

import com.application.entity.Mark;
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
 * Class for list mark servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class ListMarkServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        List<Mark> marks = null;
        try (Factory factory = getFactory()) {
            MarkService markService = factory.getMarkService();
            marks = markService.findAll();
        } catch (Exception exception) {
            try {
                throw new ServletException(exception);
            } catch (Exception ex) {
                printWarning(String.valueOf(ex));
            }
        }
        request.setAttribute("marks", marks);

        try {
            request.getRequestDispatcher("WEB-INF/jsp/mark/listMark.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            printWarning(String.valueOf(exception));
        }
    }
}
