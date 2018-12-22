package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.User;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {
    private static final Logger log = Logger.getLogger(UserDao.class);

    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> getAll() {
        List<User> resultingItems = new ArrayList<User>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user order by name ASC;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultingItems.add(createAndGet(resultSet));
            }
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return resultingItems;
    }

    @Override
    public User getById(int id) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            user = createAndGet(resultSet);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public User getByLoginPassword(String login, String password) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where login = ? and password = ?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            user = createAndGet(resultSet);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from user where id =?");
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(User entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(id, surname, name, login, password, email, phone, roles_id, rating, salary) VALUES(?,?,?,?,?,?,?,?,?,?)");

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getSurname());
            statement.setString(3, entity.getName());
            statement.setString(4, entity.getLogin());
            statement.setString(5, entity.getPassword());
            statement.setString(6, entity.getEmail());
            statement.setString(7, entity.getPhone());
            statement.setInt(8, entity.getRolesId());
            statement.setInt(9, entity.getRating());
            statement.setBigDecimal(10, entity.getSalary());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public User createAndGet(ResultSet resultSet) {

        User user = null;
        try {
            if (resultSet.next()) {
                user = new User();

                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRolesId(resultSet.getInt("role_id"));

                String ratingString =resultSet.getString("rating");
                int rating = 0;
                if(ratingString != null){
                    rating = Integer.parseInt(ratingString);
                }

                user.setRating(rating);
                String salaryString =resultSet.getString("salary");
                BigDecimal salary = null;
                if(salaryString != null){
                    salary = BigDecimal.valueOf(Long.parseLong(salaryString,10));
                }
                user.setSalary(salary);
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean update(User entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update user SET surname = ?, name = ?, login = ?, " +
                    "password = ?, email =?,phone = ?, roles_id = ?, rating = ?, salary = ?  WHERE id = ?; ");
            statement.setString(1, entity.getSurname());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setString(6, entity.getPhone());
            statement.setInt(7, entity.getRolesId());
            statement.setInt(8, entity.getRating());
            statement.setBigDecimal(9, entity.getSalary());
            statement.setInt(10, entity.getId());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }
}
