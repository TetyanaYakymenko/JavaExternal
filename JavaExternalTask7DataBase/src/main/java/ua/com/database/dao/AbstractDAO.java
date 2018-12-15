package ua.com.database.dao;

import ua.com.database.entities.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO  <T extends Entity> {
    /**ResourceBundle resource = ResourceBundle.getBundle("database");
     String url = resource.getString("db.url");
     String user = resource.getString("db.user");
     String pass = resource.getString("db.password");
     return DriverManager.getConnection(url, user, pass);*/
    protected Connection connection;
    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
    public abstract List<T> findAll();
    public abstract T findEntityById(int id);
    public abstract boolean delete(int id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
// лог о невозможности закрытия Statement
        }
    }
}
