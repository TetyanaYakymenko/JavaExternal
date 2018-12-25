package ua.com.finalProject.logic;

import org.apache.log4j.Logger;
import ua.com.finalProject.persistence.ConnectionPool;
import ua.com.finalProject.persistence.dao.ReportDao;
import ua.com.finalProject.persistence.entities.Report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReportService {

    private static final Logger log = Logger.getLogger(ReportService.class);
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public List<Report> getReports(){
        List<Report> reports = null;
        try{
            Connection connection = getConnection();
            ReportDao reportDao = new ReportDao(connection);
            reports = reportDao.getAll();
            commitAndCloseConnection(connection);
        }catch (SQLException e){
            log.error(e.getMessage());
        }

        return reports;
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
