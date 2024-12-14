package org.example.dao.orderDAO;

import org.example.dao.CRUDInterface;
import org.example.exceptions.ConnectionDBException;
import org.example.model.Client;
import org.example.model.Order;
import org.example.model.Position;
import org.example.model.Staff;
import org.example.services.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private static final String SAVE_ORDER = "INSERT INTO orders(clientid, staffid, totalcost, created) VALUES (?,?,?,?)";
    private static final String UPDATE_ORDER = "UPDATE orders SET clientid = ?, staffid = ?, totalcost = ?, created = ? WHERE id = ?";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";
    private static final String DELETE_ALL_ORDERS = "DELETE FROM orders";
    private static final String FIND_ALL_ORDER = "SELECT * FROM orders";

    @Override
    public void save(Order data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(SAVE_ORDER)) {
            ps.setLong(1, data.getClientId());
            ps.setLong(2, data.getStaffId());
            ps.setDouble(3, data.getTotalCost());
            ps.setDate(4, new java.sql.Date(data.getCreated().getTime()));
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<Order> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_ORDER);
        ){
            for (Order currentOrder : data){
                ps.setLong(1,currentOrder.getClientId());
                ps.setLong(2,currentOrder.getStaffId());
                ps.setDouble(3,currentOrder.getTotalCost());
                ps.setDate(4, (Date) currentOrder.getCreated());
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
    public void update(Order data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER)) {
            ps.setLong(1, data.getClientId());
            ps.setLong(2, data.getStaffId());
            ps.setDouble(3, data.getTotalCost());
            ps.setDate(4, new java.sql.Date(data.getCreated().getTime()));
            ps.setLong(5, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Order data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_ORDER)) {
            ps.setLong(1, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_ALL_ORDERS)) {
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> result = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_ORDER);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong(1));
                order.setClientId(rs.getLong(2));
                order.setStaffId(rs.getLong(3));
                order.setTotalCost(rs.getDouble(4));
                order.setCreated(rs.getDate(5));
                result.add(order);
            }
            return result;
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
