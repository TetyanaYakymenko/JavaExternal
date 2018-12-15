package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {

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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public User createAndGet(ResultSet resultSet) {
        User user = null;
        try {
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setSurname(resultSet.getString(2));
            user.setName(resultSet.getString(3));
            user.setLogin(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setPhone(resultSet.getString(7));
            user.setRolesId(resultSet.getInt(8));
            user.setRating(resultSet.getInt(9));
            user.setSalary(resultSet.getBigDecimal(10));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }
}
