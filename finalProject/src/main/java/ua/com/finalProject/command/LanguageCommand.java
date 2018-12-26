package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LanguageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String local = request.getParameter("locale");
        System.out.println("local=" + local);
        HttpSession session = request.getSession();
        //request.setAttribute("locale", local);
        session.setAttribute("locale", local);

        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
