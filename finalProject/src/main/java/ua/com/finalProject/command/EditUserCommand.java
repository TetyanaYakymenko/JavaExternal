package ua.com.finalProject.command;

import org.apache.log4j.Logger;
import ua.com.finalProject.displaymodel.ReportDisplay;
import ua.com.finalProject.logic.Logic;
import ua.com.finalProject.managers.ConfigurationManager;
import ua.com.finalProject.managers.MessageManager;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.UserDao;
import ua.com.finalProject.persistence.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class EditUserCommand implements ActionCommand {
    private static final Logger log = Logger.getLogger(EditUserCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        String currentUserId = null;
        currentUserId = request.getParameter("userId");
        String name = request.getParameter("name");


        User user = null;
        try {
            if (name == null) {
                user = getUserById(currentUserId);

            } else {
                user = updateUser(request);

            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            request.setAttribute("error",
                    MessageManager.getProperty("message.loginerror"));
        }
        request.setAttribute("user", user);

        String page = ConfigurationManager.getProperty("path.page.edit.user");
        return page;

    }

    private User getUserById(String id) throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        Connection connection = connectionPool.getConnection();
        connection.setAutoCommit(false);

        UserDao userDao = new UserDao(connection);
        user = userDao.getById(Integer.valueOf(id));

        connection.commit();
        connectionPool.closeConnection(connection);

        return user;
    }

    private User updateUser(HttpServletRequest request) throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        Connection connection = connectionPool.getConnection();
        connection.setAutoCommit(false);

        UserDao userDao = new UserDao(connection);
        user = new User();

        user.setId(Integer.valueOf(request.getParameter("userId")).intValue());
        user.setSurname(request.getParameter("surname"));
        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setRating(1);
        user.setRating(Integer.valueOf(request.getParameter("rating")).intValue());
        user.setSalary(new BigDecimal(request.getParameter("salary")));

        if (!userDao.update(user)) {
            user = getUserById(request.getParameter("userId"));
        }
        ;

        connection.commit();
        connectionPool.closeConnection(connection);

        return user;
    }
}
