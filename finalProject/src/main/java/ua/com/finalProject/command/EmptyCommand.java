package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    private static final String LOGIN_PAGE = "path.page.login";
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(LOGIN_PAGE);
        return page;
    }
}
