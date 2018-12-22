package ua.com.finalProject.command;

import ua.com.finalProject.logic.LoginLogic;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = LoginLogic.getUsers();
        request. setAttribute("users", users);
        return ConfigurationManager.getProperty("path.page.admin");
    }
}
