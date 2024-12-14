package org.example.dao.staffDAO;

import org.example.exceptions.ConnectionDBException;
import org.example.model.Client;
import org.example.model.Staff;
import org.example.services.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao
{
    private static final String SAVE_STAFF = "INSERT INTO staff(firstname,lastname,phone,mail,positionid) VALUES (?,?,?,?,?)";
    private static final String UPDATE_STAFF = "UPDATE staff SET firstname = ?, lastname = ?, phone = ?, mail = ?, positionid = ? ";
    private static final String DELETE_STAFF = "DELETE FROM staff WHERE staff.id = ?";
    private static final String DELETE_ALL_STAFF = "DELETE FROM staff";
    private static final String FIND_ALL_STAFF = "SELECT * FROM staff";

    @Override
    public void save(Staff data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_STAFF);
        )
        {
            ps.setString(1,data.getFirstName());
            ps.setString(2,data.getLastName());
            ps.setString(3,data.getPhone());
            ps.setString(4,data.getMail());
            ps.setLong(5,data.getPositionId());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<Staff> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_STAFF);
        ){
            for (Staff currentStaff : data){
                ps.setString(1,currentStaff.getFirstName());
                ps.setString(2,currentStaff.getLastName());
                ps.setString(3,currentStaff.getPhone());
                ps.setString(4,currentStaff.getMail());
                ps.setLong(5,currentStaff.getPositionId());
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
    public void update(Staff data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_STAFF);
        ){
            ps.setString(1,data.getFirstName());
            ps.setString(2,data.getLastName());
            ps.setString(3,data.getPhone());
            ps.setString(4,data.getMail());
            ps.setLong(5,data.getPositionId());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Staff data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_STAFF);
        ){
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
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_STAFF);
        ){
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> resultAddStaff = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_STAFF);
            ResultSet result = ps.executeQuery()
        ){
            while (result.next()){
                Staff addStaff = new Staff();
                addStaff.setId(result.getLong(1));
                addStaff.setFirstName(result.getString(2));
                addStaff.setLastName(result.getString(3));
                addStaff.setPhone(result.getString(4));
                addStaff.setMail(result.getString(5));
                addStaff.setPositionId(result.getLong(6));
                resultAddStaff.add(addStaff);
            }
            return resultAddStaff;
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
