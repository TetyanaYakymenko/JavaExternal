package ua.com.finalProject.persistence.dao;

import ua.com.finalProject.persistence.entities.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDao extends AbstractDao<Report> {

    public ReportDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Report> getAll() {
        List<Report> resultingItems = new ArrayList<Report>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from report order by name ASC;");
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
    public Report getById(int id) {
        Report report = new Report();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from report where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            report = createAndGet(resultSet);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return report;
    }

    @Override
    public boolean delete(int id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from report where id =?");
            statement.setInt(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public boolean create(Report entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO report(id, name, text, speaker_id) VALUE (?,?,?,?)");

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getText());
            statement.setInt(4, entity.getSpeakerId());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

    @Override
    public Report createAndGet(ResultSet resultSet) {
        Report report = null;
        try {
            report = new Report();
            report.setId(resultSet.getInt(1));
            report.setName(resultSet.getString(2));
            report.setText(resultSet.getString(3));
            report.setSpeakerId(resultSet.getInt(4));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return report;
    }

    @Override
    public boolean update(Report entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update report SET name = ?, text = ?, spearer_id = ? WHERE id = ?; ");
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getText());
            statement.setInt(3, entity.getSpeakerId());
            statement.setInt(4, entity.getId());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

}
