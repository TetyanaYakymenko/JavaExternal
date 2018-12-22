package ua.com.finalProject.persistence;

import ua.com.finalProject.managers.DBManager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final Logger log = Logger.getLogger(ConnectionPool.class);

    private static final int DEFAULT_POOL_SIZE = 10;
    //single instance
    private static ConnectionPool instance;
    //queue of free connections
    private BlockingQueue<Connection> connectionQueue;

    public ConnectionPool(String driver, String url, String user,
                          String password, int poolSize)
            throws ClassNotFoundException {
        try {
            Class.forName(driver);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionQueue.offer(connection);
            }
        } catch (SQLException e) {
            log.error(e);
            //throw new DAOException(e.getMessage());
        }
    }

    public static void init() {
        try {
            if (instance == null) {
                String driver = DBManager.getProperty("jdbc.driver");
                String url = DBManager.getProperty("url");
                String userName = DBManager.getProperty("user");
                String password = DBManager.getProperty("password");
                Integer poolSize = Integer.parseInt(DBManager.getProperty("pool.size"));
                System.out.println(poolSize);

                instance = new ConnectionPool(driver, url, userName, password, poolSize.intValue());
;
            }
        } catch (ClassNotFoundException e) {
             log.error(e);
        }
    }

    public static void dispose() {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
            log.info("Connection queue is disposed");
        }

    }

    private void clearConnectionQueue() {
        try {
            Connection connection;
            while ((connection = connectionQueue.poll()) != null) {

                if (!connection.getAutoCommit()) {
                    connection.commit();
                    connection.close();
                }
            }
        } catch (SQLException e) {
            log.info(e.getMessage());
            //throw new DAOException(e.getMessage());
        }
    }

    public static ConnectionPool getInstance() {
        if(instance == null){
            init();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;

        connection = connectionQueue.poll();
        return connection;
    }

    public void closeConnection(Connection connection) {
        connectionQueue.offer(connection);
    }

}
