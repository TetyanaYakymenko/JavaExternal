package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.login");
// уничтожение сессии
        request.getSession().removeAttribute("login");
        request.getSession().removeAttribute("password");
        request.getSession().removeAttribute("role");
        return page;
    }
}