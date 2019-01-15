package ua.com.finalProject.servlet;

import ua.com.finalProject.command.LanguageCommand;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.managers.MessageManager;
import ua.com.finalProject.ActionFactory;
import ua.com.finalProject.command.ActionCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty("path.page.error");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
// вызов страницы ответа на запрос
            dispatcher.forward(request, response);
            ;
        }
    }
}