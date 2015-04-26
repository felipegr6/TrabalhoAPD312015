package br.mack.projeto.war.servlets;

import br.mack.projeto.war.controllers.Controller;
import br.mack.projeto.war.controllers.ControllerFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {

            String controller = request.getParameter("control");
            Controller control = ControllerFactory.getControllerByFullClassName(controller);

            control.init(request);
            control.execute();

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());

            requestDispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
