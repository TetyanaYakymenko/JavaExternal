package ua.com.finalProject.logic;

import org.apache.log4j.Logger;
import ua.com.finalProject.persistence.dao.ConferenceDao;
import ua.com.finalProject.persistence.entities.Conference;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConferenceService {
    private static final Logger log = Logger.getLogger(ConferenceService.class);

    public static List<Conference> getConferences() {
        List<Conference> conferences = null;
        try {
            Connection connection = ConnectionService.getConnection();

            ConferenceDao conferenceDao = new ConferenceDao(connection);
            conferences = conferenceDao.getAll();

            ConnectionService.commitAndCloseConnection(connection);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return conferences;
    }
}
