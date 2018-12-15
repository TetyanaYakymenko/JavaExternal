package ua.com.database.dao;

import ua.com.database.entities.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO extends AbstractDAO<Laptop> {

    public LaptopDAO(Connection connection) {
        super(connection);
    }

    public List<Laptop> findAll() {
        List<Laptop> resultingItems = new ArrayList<Laptop>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from laptop order by price ASC;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultingItems.add(createEntity(resultSet));
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultingItems;
    }

    public Laptop findEntityById(String id) {
        Laptop laptop = new Laptop();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from laptop where code = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            laptop = createEntity(resultSet);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return laptop;
    }

    public boolean delete(String id) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from laptop where code=?");
            statement.setString(1, id);
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

    public boolean delete(Laptop entity) {
        return delete("" + entity.getCode());
    }

    public boolean create(Laptop entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO laptop(code, model, speed, ram, hd, price, screen) VALUE (?,?,?,?,?,?,?)");

            statement.setInt(1, entity.getCode());
            statement.setString(2, entity.getModel());
            statement.setInt(3, entity.getSpeed());
            statement.setInt(4, entity.getRam());
            statement.setDouble(5, entity.getHd());
            statement.setBigDecimal(6, entity.getPrice());
            statement.setInt(7, entity.getScreen());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }

    public Laptop createEntity(ResultSet resultSet) {
        Laptop laptop = null;
        try {
            laptop = new Laptop();
            laptop.setCode(resultSet.getInt(1));
            laptop.setModel(resultSet.getString(2));
            laptop.setSpeed(resultSet.getInt(3));
            laptop.setRam(resultSet.getInt(4));
            laptop.setHd(resultSet.getDouble(5));
            laptop.setPrice(resultSet.getBigDecimal(6));
            laptop.setScreen(resultSet.getInt(7));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return laptop;
    }

    public boolean update(Laptop entity) {
        int changeNumber = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update laptop SET model = ?, speed = ?, ram = ?, hd =?, price = ?, screen = ? where code = ?); VALUE (?,?,?,?,?,?,?)");
            statement.setString(1, entity.getModel());
            statement.setInt(2, entity.getSpeed());
            statement.setInt(3, entity.getRam());
            statement.setDouble(4, entity.getHd());
            statement.setBigDecimal(5, entity.getPrice());
            statement.setInt(6, entity.getScreen());
            statement.setInt(7, entity.getCode());
            changeNumber = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return changeNumber > 0;
    }
}