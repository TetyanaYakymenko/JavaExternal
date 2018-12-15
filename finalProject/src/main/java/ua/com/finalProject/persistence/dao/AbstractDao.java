package ua.com.finalProject.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ua.com.finalProject.persistence.entities.Entity;

public abstract class AbstractDao<T extends Entity> {

    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> getAll();

    public abstract T getById(int id);

    public abstract boolean delete(int id);

    public boolean delete(T entity) {
        return delete(entity.getId());
    };

    public abstract boolean create(T entity);

    public abstract T createAndGet(ResultSet resultSet);

    public abstract boolean update(T entity);

    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("Error in closing Statement");
        }
    }

}
