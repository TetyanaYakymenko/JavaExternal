package ua.com.finalProject.command;

import ua.com.finalProject.logic.Logic;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.managers.MessageManager;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_ROLE = "role";
    private static final String PARAM_NAME_USERS = "users";
    private static final String PARAM_NAME_CONFERENCES = "conferences";

    private static final String LOGIN_PAGE = "path.page.login";
    private static final String ADMIN_PAGE = "path.page.admin";
    private static final String MAIN_PAGE = "path.page.main";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

// проверка логина и пароля
        User user = Logic.getUserbyLoginAndPassword(login, pass);
        ReportsCommand reportsCommand = null;
        if (user != null) {
            switch (user.getRolesId()) {
                case 1:
                    request.getSession().setAttribute(PARAM_NAME_ROLE, "admin");
                    List<User> users = Logic.getUsers();
                    request.setAttribute(PARAM_NAME_USERS, users);
                    page = ConfigurationManager.getProperty(ADMIN_PAGE);
                    break;
                case 2:
                    request.getSession().setAttribute(PARAM_NAME_ROLE, "moderator");
                    reportsCommand = new ReportsCommand();
                    return reportsCommand.execute(request);
                case 3:
                    request.getSession().setAttribute(PARAM_NAME_ROLE, "speaker");
                    break;
                default:
                     reportsCommand = new ReportsCommand();
                    return reportsCommand.execute(request);
            }
            request.getSession().setAttribute(PARAM_NAME_LOGIN, login);
            request.getSession().setAttribute(PARAM_NAME_PASSWORD, pass);
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty(LOGIN_PAGE);
        }
        return page;
    }
}
