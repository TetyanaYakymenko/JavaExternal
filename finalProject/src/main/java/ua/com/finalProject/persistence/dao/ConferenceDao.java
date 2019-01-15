package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.Conference;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ConferenceDao extends AbstractDao<Conference> {
    private static final Logger log = Logger.getLogger(ConferenceDao.class);

    public ConferenceDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Conference> getAll() {
        List<Conference> resultingItems = new ArrayList<Conference>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from conference order by id ASC;");
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
    public Conference getById(int id) {
        Conference conference = new Conference();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from conference where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                conference = createAndGet(resultSet);
            }
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return conference;
    }

    @Override
    public boolean delete(int id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from conference where id =?");
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(Conference entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO conference (id, name, date, place) VALUE (?,?,?,?)");

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setDate(3, new java.sql.Date(entity.getDate().getTime().getTime()));
            statement.setString(4, entity.getPlace());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public Conference createAndGet(ResultSet resultSet) {
        Conference conference = null;
        try {
            conference = new Conference();
            conference.setId(resultSet.getInt("id"));
            conference.setName(resultSet.getString("name"));
            GregorianCalendar calendar = new GregorianCalendar();

            java.util.Date date = resultSet.getDate("date");

            if (date != null) {

                calendar.setTimeInMillis(date.getTime());
                conference.setDate(calendar);
            } else {
                conference.setDate(null);
            }
            conference.setPlace(resultSet.getString("place"));
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return conference;
    }

    @Override
    public boolean update(Conference entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update conference SET name = ?, date = ?, place = ? WHERE id = ?; ");
            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getName());
            statement.setDate(2, new java.sql.Date(entity.getDate().getTimeInMillis()));
            statement.setString(3, entity.getPlace());
            statement.setInt(4, entity.getId());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return changeNumber > 0;
    }
}
