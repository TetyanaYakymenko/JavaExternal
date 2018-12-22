package ua.com.finalProject.persistence;

import ua.com.finalProject.persistence.dao.*;
import ua.com.finalProject.persistence.entities.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class FactoryDAO {
    private Map< Class, AbstractDao > creators;

    public FactoryDAO(Connection connection ) {
        creators = new HashMap<>();
        creators.put(Conference.class, new ConferenceDao(connection));
        creators.put(Report.class, new ReportDao(connection));
        creators.put(Role.class, new RoleDao(connection));
        creators.put(UserConference.class, new UserConferenceDao(connection));
        creators.put(UserDao.class, new UserDao(connection));
    }

    public AbstractDao getDao(Connection connection, Class dtoClass) throws Exception {
        AbstractDao creator = creators.get(dtoClass);
        if (creator == null) {
            throw new Exception("Dao object for " + dtoClass + " not found.");
        }
        return creator;
    }


}
