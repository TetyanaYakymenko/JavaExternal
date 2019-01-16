package ua.com.finalProject.logic;

import org.apache.log4j.Logger;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.UserDao;
import ua.com.finalProject.persistence.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static final Logger log = Logger.getLogger(UserService.class);

    public static User getUserbyLoginAndPassword(String enterLogin, String enterPass) {
        User user = null;
        try {
            Connection connection = ConnectionService.getConnection();

            UserDao userDao = new UserDao(connection);
            user = userDao.getByLoginPassword(enterLogin, enterPass);

            ConnectionService.commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return user;
    }

    public static List<User> getUsers() {
        List<User> users = null;
        try {
            Connection connection = ConnectionService.getConnection();

            UserDao userDao = new UserDao(connection);
            users = userDao.getAll();

            ConnectionService.commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return users;
    }

    public static User getUserByLogin(String login) {
        User user = null;
        try {
            Connection connection = ConnectionService.getConnection();

            UserDao userDao = new UserDao(connection);
            user = userDao.getByLogin(login);

            ConnectionService.commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public static void AddUser(User user) {
        try {
            Connection connection = ConnectionService.getConnection();

            UserDao userDao = new UserDao(connection);

            PreparedStatement statement = connection.prepareStatement("select max(id) from user; ");
            int id = 1;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id += resultSet.getInt(1);
            }
            user.setId(id);
            user.setRolesId(4);
            userDao.create(user);

            ConnectionService.commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

    }
    public static User getUserById(String id) throws SQLException {
        Connection connection = ConnectionService.getConnection();

        User user = null;
        UserDao userDao = new UserDao(connection);
        user = userDao.getById(Integer.valueOf(id));

        ConnectionService.commitAndCloseConnection(connection);

        return user;
    }
}

