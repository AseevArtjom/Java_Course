package org.example.dao.positionDAO;

import org.example.dao.CRUDInterface;
import org.example.exceptions.ConnectionDBException;
import org.example.model.Client;
import org.example.model.Position;
import org.example.services.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao {
    private static final String SAVE_POSITION = "INSERT INTO positions(name) VALUES (?)";
    private static final String UPDATE_POSITION = "UPDATE positions SET name = ? WHERE id = ?";
    private static final String DELETE_POSITION = "DELETE FROM positions WHERE id = ?";
    private static final String DELETE_ALL_POSITION = "DELETE FROM positions";
    private static final String FIND_ALL_POSITION = "SELECT * FROM positions";

    @Override
    public void save(Position data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(SAVE_POSITION)) {
            ps.setString(1, data.getName());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<Position> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_POSITION)
        )
        {
            for(Position currentPosition : data){
                ps.setLong(1,currentPosition.getId());
                ps.setString(2,currentPosition.getName());
                ps.addBatch();
            }
            ps.executeBatch();
        }
        catch (ConnectionDBException | SQLException ex){
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_POSITION);
        ){
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Position data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_POSITION)) {
            ps.setString(1, data.getName());
            ps.setLong(2, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Position data) {
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_POSITION)) {
            ps.setLong(1, data.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<Position> findAll() {
        List<Position> result = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = connection.prepareStatement(FIND_ALL_POSITION);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Position position = new Position();
                position.setId(rs.getLong(1));
                position.setName(rs.getString(2));
                result.add(position);
            }
            return result;
        } catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
