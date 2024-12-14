package org.example.dao.menuItemTypeDAO;
import org.example.dao.CRUDInterface;
import org.example.exceptions.ConnectionDBException;
import org.example.model.Client;
import org.example.model.MenuItemType;
import org.example.model.Order;
import org.example.model.Position;
import org.example.services.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemTypeDaoImpl implements MenuItemTypeDao {
    private static final String SAVE_MENU_ITEM_TYPE = "INSERT INTO menuitemstype(name) VALUES (?)";
    private static final String UPDATE_MENU_ITEM_TYPE = "UPDATE menuitemstype SET name = ? WHERE id = ?";
    private static final String DELETE_MENU_ITEM_TYPE = "DELETE FROM menuitemstype WHERE id = ?";
    private static final String DELETE_ALL_MENU_ITEM_TYPES = "DELETE FROM menuitemstype";
    private static final String FIND_ALL_MENU_ITEM_TYPE = "SELECT * FROM menuitemstype";

    @Override
    public void save(MenuItemType data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(SAVE_MENU_ITEM_TYPE)) {
            ps.setString(1, data.getName());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<MenuItemType> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_MENU_ITEM_TYPE);
        ){
            for (MenuItemType currentMenuItemType : data){
                ps.setString(1,currentMenuItemType.getName());
            }
            ps.executeBatch();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void update(MenuItemType data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_MENU_ITEM_TYPE)) {
            ps.setString(1, data.getName());
            ps.setLong(2, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(MenuItemType data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_MENU_ITEM_TYPE)) {
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
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_MENU_ITEM_TYPES);
        ){
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<MenuItemType> findAll() {
        List<MenuItemType> result = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_MENU_ITEM_TYPE);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MenuItemType type = new MenuItemType();
                type.setId(rs.getLong(1));
                type.setName(rs.getString(2));
                result.add(type);
            }
            return result;
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
