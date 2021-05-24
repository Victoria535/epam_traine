package com.application.servlets.mark;

import com.application.Printable;
import com.application.services.Factory;
import com.application.services.mark.MarkService;
import com.application.servlets.MainServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class for delete mark servlet.
 * <p>
 * Date: may 5 2021
 *
 * @author Viktoria Symaniuk
 */
public class DeleteMarkServlet extends MainServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Long id = getParameterId(request);

        if (id != null) {
            try (Factory factory = getFactory()) {
                MarkService markService = factory.getMarkService();
                markService.delete(id);
            } catch (Exception exception) {
                try {
                    throw new ServletException(exception);
                } catch (Exception ex) {
                    Printable.printWarning(String.valueOf(ex));
                }
            }
            try {
                response.sendRedirect(request.getContextPath() + "/listMark");
            } catch (IOException exception) {
                Printable.printWarning(String.valueOf(exception));
            }
        }
    }
}
