package org.example.dao.clientDAO;

import org.example.exceptions.ConnectionDBException;
import org.example.model.Client;
import org.example.services.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao
{
    private static final String SAVE_CLIENT = "INSERT INTO clients(firstname,lastname,birth,phone,mail,discount) VALUES(?,?,?,?,?,?)";
    private static final String FIND_ALL_CLIENTS = "SELECT * FROM clients";
    private static final String UPDATE_CLIENT = "UPDATE clients SET lastname = ?, lastname = ?, birth = ?, phone = ?, mail = ?, discount = ? "
            + " WHERE clients.id = ? ";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE clients.id = ?";
    private static final String DELETE_ALL_CLIENTS = "DELETE FROM clients";

    @Override
    public void save(Client data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_CLIENT);
            )
        {
            ps.setString(1,data.getFirstName());
            ps.setString(2,data.getLastName());
            ps.setDate(3,data.getBirth());
            ps.setString(4,data.getPhone());
            ps.setString(5,data.getMail());
            ps.setInt(6,data.getDiscount());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<Client> data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(SAVE_CLIENT)
            )
        {
            for(Client currentClient : data){
                ps.setString(1,currentClient.getFirstName());
                ps.setString(2,currentClient.getLastName());
                ps.setDate(3,currentClient.getBirth());
                ps.setString(4,currentClient.getPhone());
                ps.setString(5,currentClient.getMail());
                ps.setInt(6,currentClient.getDiscount());
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
    public void update(Client data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_CLIENT)
            )
        {
            ps.setString(1,data.getFirstName());
            ps.setString(2,data.getLastName());
            ps.setDate(3,data.getBirth());
            ps.setString(4,data.getPhone());
            ps.setString(5,data.getMail());
            ps.setInt(6,data.getDiscount());
            ps.setLong(7,data.getId());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex){
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Client data) {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_CLIENT);
            )
        {
            ps.setLong(1,data.getId());
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex){
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAll() {
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_ALL_CLIENTS);
        )
        {
            ps.execute();
        }
        catch (ConnectionDBException | SQLException ex){
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> resultAddClients = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getInstance().makeConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_ALL_CLIENTS);
             ResultSet result = ps.executeQuery()
        )
        {
            while (result.next()){
                Client addClient = new Client();
                addClient.setId(result.getLong(1));
                addClient.setFirstName(result.getString(2));
                addClient.setLastName(result.getString(3));
                addClient.setBirth(result.getDate(4));
                addClient.setPhone(result.getString(5));
                addClient.setMail(result.getString(6));
                addClient.setDiscount(result.getInt(7));
                resultAddClients.add(addClient);
            }
            return resultAddClients;
        }
        catch (ConnectionDBException | SQLException ex){
            System.err.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}
