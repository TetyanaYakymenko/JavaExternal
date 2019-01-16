package ua.com.finalProject.logic;

import org.apache.log4j.Logger;
import ua.com.finalProject.persistence.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionService {
    private static final Logger log = Logger.getLogger(ConnectionService.class);
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static Connection getConnection() throws SQLException {
        Connection connection = connectionPool.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public static void commitAndCloseConnection(Connection connection) throws SQLException {
        connection.commit();
        connectionPool.closeConnection(connection);
    }
}
