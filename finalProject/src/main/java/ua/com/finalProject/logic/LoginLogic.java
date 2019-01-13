package ua.com.finalProject.logic;

import org.apache.log4j.Logger;

import ua.com.finalProject.displaymodel.ReportDisplay;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.ConferenceDao;
import ua.com.finalProject.persistence.dao.ReportDao;
import ua.com.finalProject.persistence.dao.UserDao;
import ua.com.finalProject.persistence.entities.Conference;
import ua.com.finalProject.persistence.entities.Report;
import ua.com.finalProject.persistence.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginLogic {
    private static final Logger log = Logger.getLogger(LoginLogic.class);
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static User getUserbyLoginAndPassword(String enterLogin, String enterPass) {
        User user = null;
        try {
            Connection connection = getConnection();

            UserDao userDao = new UserDao(connection);
            user = userDao.getByLoginPassword(enterLogin, enterPass);

            commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return user;
    }

    public static List<ReportDisplay> getReportsDisplay() {
        List<Report> reports = new ArrayList<>();
        final List<Conference> cons;
        final List<User> users;
        List<ReportDisplay> result = new ArrayList<>();

        try {
            Connection connection = getConnection();

            ReportDao reportDao = new ReportDao(connection);
            reports = reportDao.getAll();

            ConferenceDao conferenceDao = new ConferenceDao(connection);
            cons = conferenceDao.getAll();

            UserDao userDao = new UserDao(connection);
            users = userDao.getAll();

            reports.stream().forEach(report1 -> result.add(new ReportDisplay(report1, cons, users)));

            commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return result;
    }
//

    public static List<Conference> getConferences() {
        List<Conference> conferences = null;
        try {
            Connection connection = getConnection();

            ConferenceDao conferenceDao = new ConferenceDao(connection);
            conferences = conferenceDao.getAll();

            commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return conferences;
    }

    public static List<User> getUsers() {
        List<User> users = null;
        try {
            Connection connection = getConnection();

            UserDao userDao = new UserDao(connection);
            users = userDao.getAll();

            commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return users;
    }

    private static Connection getConnection() throws SQLException {
        Connection connection = connectionPool.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    private static void commitAndCloseConnection(Connection connection) throws SQLException {
        connection.commit();
        connectionPool.closeConnection(connection);
    }
}
