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

public class ReportService {

    private static final Logger log = Logger.getLogger(ReportService.class);
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public List<Report> getReports() {
        List<Report> reports = null;
        try {
            Connection connection = ConnectionService.getConnection();
            ReportDao reportDao = new ReportDao(connection);
            reports = reportDao.getAll();
            ConnectionService.commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return reports;
    }

    public static List<ReportDisplay> getReportsDisplay() {
        List<Report> reports = new ArrayList<>();
        final List<Conference> cons;
        final List<User> users;
        List<ReportDisplay> result = new ArrayList<>();

        try {
            Connection connection = ConnectionService.getConnection();

            ReportDao reportDao = new ReportDao(connection);
            reports = reportDao.getAll();

            ConferenceDao conferenceDao = new ConferenceDao(connection);
            cons = conferenceDao.getAll();

            UserDao userDao = new UserDao(connection);
            users = userDao.getAll();

            reports.stream().forEach(report1 -> result.add(new ReportDisplay(report1, cons, users)));

            ConnectionService.commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return result;
    }

    public static boolean updateReportDisplay(ReportDisplay reportDisplay) throws SQLException {
        Connection connection = ConnectionService.getConnection();

        ReportDao reportDao = new ReportDao(connection);
        boolean result1 = reportDao.update(reportDisplay.getReport());



        ConferenceDao conferenceDao = new ConferenceDao(connection);
        boolean result2 = conferenceDao.update(reportDisplay.getConference());


        UserDao userDao = new UserDao(connection);
        boolean result3 = userDao.update(reportDisplay.getUser());
        boolean result = result1 && result2 && result3;
        if(result){
            connection.commit();
        }else{
            connection.rollback();
        }
        connectionPool.closeConnection(connection);
       // ConnectionService.commitAndCloseConnection(connection);

        return result;
    }


}
