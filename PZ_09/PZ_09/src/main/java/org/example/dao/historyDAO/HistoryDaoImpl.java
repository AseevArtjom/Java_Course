package org.example.dao.historyDAO;

import org.example.exceptions.ConnectionDBException;
import org.example.model.History;
import org.example.services.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDaoImpl implements HistoryDao
{
    private static final String SAVE_HISTORY = "INSERT INTO history(cost, totalordercost, created, client_firstname, client_lastname, staff_firstname, staff_lastname) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_HISTORY = "UPDATE history SET cost = ?, totalordercost = ?, created = ?, client_firstname = ?, client_lastname = ?, staff_firstname = ?, staff_lastname = ? WHERE id = ?";
    private static final String DELETE_HISTORY= "DELETE FROM history WHERE id = ?";
    private static final String DELETE_ALL_HISTORY = "DELETE FROM history";
    private static final String FIND_ALL_HISTORY = "SELECT * FROM history";

    @Override
    public void save(History data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_HISTORY);
        )
        {
            ps.setDouble(1,data.getCost());
            ps.setDouble(2,data.getTotalOrderCost());
            ps.setDate(3, (Date) data.getCreated());
            ps.setString(4,data.getClientFirstName());
            ps.setString(5,data.getClientLastName());
            ps.setString(6,data.getStaffFirstName());
            ps.setString(7,data.getStaffLastName());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<History> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_HISTORY);
        )
        {
            for (History currentHistory : data){
                ps.setDouble(1,currentHistory.getCost());
                ps.setDouble(2,currentHistory.getTotalOrderCost());
                ps.setDate(3, (Date) currentHistory.getCreated());
                ps.setString(4,currentHistory.getClientFirstName());
                ps.setString(5,currentHistory.getClientLastName());
                ps.setString(6,currentHistory.getStaffFirstName());
                ps.setString(7,currentHistory.getStaffLastName());
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
    public void update(History data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_HISTORY);
        )
        {
            ps.setDouble(1,data.getCost());
            ps.setDouble(2,data.getTotalOrderCost());
            ps.setDate(3, (Date) data.getCreated());
            ps.setString(4,data.getClientFirstName());
            ps.setString(5,data.getClientLastName());
            ps.setString(6,data.getStaffFirstName());
            ps.setString(7,data.getStaffLastName());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(History data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_HISTORY);
        )
        {
            ps.setLong(1,data.getId());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_HISTORY);
        )
        {
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<History> findAll() {
        List<History> resultAddHistory = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_HISTORY);
            ResultSet rs = ps.executeQuery();
        )
        {
            while (rs.next()){
                History addHistory = new History();
                addHistory.setId(rs.getLong(1));
                addHistory.setCost( rs.getDouble(2));
                addHistory.setTotalOrderCost(rs.getDouble(3));
                addHistory.setCreated(rs.getDate(4));
                addHistory.setClientFirstName(rs.getString(5));
                addHistory.setClientLastName(rs.getString(6));
                addHistory.setStaffFirstName(rs.getString(7));
                addHistory.setStaffLastName(rs.getString(8));
                resultAddHistory.add(addHistory);
            }
            return resultAddHistory;
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

}
