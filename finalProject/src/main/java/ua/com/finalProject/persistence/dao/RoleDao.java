package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.Role;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends AbstractDao<Role> {
    private static final Logger log = Logger.getLogger(RoleDao.class);

    public RoleDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Role> getAll() {
        List<Role> resultingItems = new ArrayList<Role>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role order by name ASC;");
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
    public Role getById(int id) {
        Role role = new Role();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            role = createAndGet(resultSet);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return role;
    }

    @Override
    public boolean delete(int id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from role where id =?");
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(Role entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO role (id, role_name) VALUE (?,?)");

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getRoleName());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public Role createAndGet(ResultSet resultSet) {
        Role role = null;
        try {
            role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setRoleName(resultSet.getString("role_name"));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return role;
    }

    @Override
    public boolean update(Role entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update role SET role_name = ? WHERE id = ?; ");

            statement.setString(1, entity.getRoleName());
            statement.setInt(2, entity.getId());
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }
}
