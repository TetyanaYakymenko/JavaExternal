package ua.com.finalProject.logic;

import org.apache.log4j.Logger;

import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.ConferenceDao;
import ua.com.finalProject.persistence.dao.UserDao;
import ua.com.finalProject.persistence.entities.Conference;
import ua.com.finalProject.persistence.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LoginLogic {
    private static final Logger log = Logger.getLogger(LoginLogic.class);

    public static User getUserbyLoginAndPassword(String enterLogin, String enterPass) {
        User user = null;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            UserDao userDao = new UserDao(connection);

            user = userDao.getByLoginPassword(enterLogin, enterPass);
            connection.commit();
            connectionPool.closeConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return user;
    }

    public static List<Conference> getConferences(){
        List<Conference> conferences = null;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            ConferenceDao conferenceDao = new ConferenceDao(connection);

            conferences = conferenceDao.getAll();
            connection.commit();
            connectionPool.closeConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return conferences;
    }
    public static List<User> getUsers(){
        List<User> users = null;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            UserDao userDao = new UserDao(connection);

            users = userDao.getAll();
            connection.commit();
            connectionPool.closeConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return users;
    }
}
