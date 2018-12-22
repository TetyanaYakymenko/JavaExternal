package ua.com.finalProject.command;

import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.managers.MessageManager;
import ua.com.finalProject.logic.LoginLogic;
import ua.com.finalProject.persistence.dao.ConferenceDao;
import ua.com.finalProject.persistence.entities.Conference;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

// проверка логина и пароля
        User user = LoginLogic.getUserbyLoginAndPassword(login, pass);
        if (user != null) {
            if (user.getRolesId() == 1) {
                request.getSession().setAttribute("role", "admin");
                List<User> users = LoginLogic.getUsers();
                request. setAttribute("users", users);
                page = ConfigurationManager.getProperty("path.page.admin");
            } else {
                page = ConfigurationManager.getProperty("path.page.main");
                List<Conference> conferences = LoginLogic.getConferences();
                request. setAttribute("conferences", conferences);
            }
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("password", pass);
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
