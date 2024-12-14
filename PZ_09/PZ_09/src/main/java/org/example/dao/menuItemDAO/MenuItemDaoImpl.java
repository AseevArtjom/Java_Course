package org.example.dao.menuItemDAO;
import org.example.exceptions.ConnectionDBException;
import org.example.model.*;
import org.example.services.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDaoImpl implements MenuItemDao {
    private static final String SAVE_MENU_ITEM = "INSERT INTO menuitems(name_eng, name_ru, typeid, cost) VALUES (?)";
    private static final String UPDATE_MENU_ITEM = "UPDATE menuitems SET name_eng = ?, name_ru = ?, typeid = ?, cost = ? WHERE id = ?";
    private static final String DELETE_MENU_ITEM= "DELETE FROM menuitems WHERE id = ?";
    private static final String DELETE_ALL_MENU_ITEMS = "DELETE FROM menuitems";
    private static final String FIND_ALL_MENU_ITEM = "SELECT * FROM menuitems";

    @Override
    public void save(MenuItem data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(SAVE_MENU_ITEM)) {
            ps.setString(1, data.getName_Eng());
            ps.setString(2, data.getName_Ru());
            ps.setLong(3, data.getTypeId());
            ps.setDouble(4, data.getCost());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<MenuItem> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_MENU_ITEM);
        ){
            for (MenuItem currentMenuItem : data){
                ps.setString(1, currentMenuItem.getName_Eng());
                ps.setString(2, currentMenuItem.getName_Ru());
                ps.setLong(3, currentMenuItem.getTypeId());
                ps.setDouble(4, currentMenuItem.getCost());
                ps.addBatch();
            }
            ps.executeBatch();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void update(MenuItem data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_MENU_ITEM)) {
            ps.setString(1, data.getName_Eng());
            ps.setString(2, data.getName_Ru());
            ps.setLong(3, data.getTypeId());
            ps.setDouble(4, data.getCost());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(MenuItem data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_MENU_ITEM)) {
            ps.setLong(1, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_MENU_ITEMS);
        ){
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }


    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> result = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_MENU_ITEM);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MenuItem item = new MenuItem();
                item.setId(rs.getLong(1));
                item.setName_Eng(rs.getString(2));
                item.setName_Ru(rs.getString(3));
                item.setTypeId(rs.getLong(4));
                item.setCost(rs.getDouble(5));
                result.add(item);
            }
            return result;
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
