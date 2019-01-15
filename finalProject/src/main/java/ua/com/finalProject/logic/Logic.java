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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Logic {
    private static final Logger log = Logger.getLogger(Logic.class);
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
    public static User getUserByLogin(String login){
        User user = null;
        try {
            Connection connection = getConnection();

            UserDao userDao = new UserDao(connection);
            user = userDao.getByLogin(login);

            commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }
    public static void AddUser(User user){
        try {
            Connection connection = getConnection();

            UserDao userDao = new UserDao(connection);

            PreparedStatement statement = connection.prepareStatement("select max(id) from user; ");
            int id =1;
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                id += resultSet.getInt(1);
            }
            user.setId(id);
            user.setRolesId(4);
            userDao.create(user);

            commitAndCloseConnection(connection);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

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
