package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.UserConference;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserConferenceDao extends AbstractDao<UserConference> {
    private static final Logger log = Logger.getLogger(UserConferenceDao.class);

    public UserConferenceDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<UserConference> getAll() {
        List<UserConference> resultingItems = new ArrayList<UserConference>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user_conference order by name ASC;");
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
    public UserConference getById(int id) {
        UserConference userConference = new UserConference();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user_conference where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            userConference = createAndGet(resultSet);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return userConference;
    }

    @Override
    public boolean delete(int id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from user_conference where id =?");
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(UserConference entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user_conference (id, user_id, conference_id, visited) VALUES(?,?,?,?)");

            statement.setInt(1, entity.getId());
            statement.setInt(2, entity.getUserId());
            statement.setInt(3, entity.getConferenceId());
            statement.setBoolean(4, entity.isVisited());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public UserConference createAndGet(ResultSet resultSet) {
        UserConference userConference = null;
        try {
            userConference = new UserConference();
            userConference.setId(resultSet.getInt("id"));
            userConference.setUserId(resultSet.getInt("user_id"));
            userConference.setConferenceId(resultSet.getInt("conferece_id"));
            userConference.setVisited(resultSet.getBoolean("visited"));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return userConference;
    }

    @Override
    public boolean update(UserConference entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update user_conference SET user_id = ?, conference_id = ?, visited = ? WHERE id = ?; ");

            statement.setInt(1, entity.getUserId());
            statement.setInt(2, entity.getConferenceId());
            statement.setBoolean(3, entity.isVisited());
            statement.setInt(4, entity.getId());
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }
}
