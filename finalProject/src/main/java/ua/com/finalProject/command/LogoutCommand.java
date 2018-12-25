package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_ROLE = "role";
    private static final String LOGIN_PAGE = "path.page.login";

    @Override
    public String execute(HttpServletRequest request) {

        // уничтожение сессии
        request.getSession().removeAttribute(PARAM_NAME_LOGIN);
        request.getSession().removeAttribute(PARAM_NAME_PASSWORD);
        request.getSession().removeAttribute(PARAM_NAME_ROLE);

        String page = ConfigurationManager.getProperty(LOGIN_PAGE);
        return page;
    }
}