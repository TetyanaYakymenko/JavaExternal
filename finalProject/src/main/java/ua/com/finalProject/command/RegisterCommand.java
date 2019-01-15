package ua.com.finalProject.command;

import ua.com.finalProject.logic.Logic;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.UserDao;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterCommand implements ActionCommand {
    private static final String PARAM_NAME = "name";
    private static final String REGISTRATION_PAGE = "path.page.registration";
    private static final String MAIN_PAGE = "path.page.main";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phone = request.getParameter("login");


        User user = new User();
        if (name == null) {
            return ConfigurationManager.getProperty(REGISTRATION_PAGE);
        }
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        //TODO check correct email/phone
        user.setEmail(email);
        user.setPhone(phone);

        Logic.AddUser(user);
        request.setAttribute("login", login);
        request.setAttribute("password", password);
        return new LoginCommand().execute(request);


    }


}
