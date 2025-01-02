package org.example.service;

import org.example.exception.ConnectionDBException;
import org.example.exception.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyDbInitializer
{
    private static final List<String> TABLES_NAME_ARRAY;
    private static final String SQL_SCRIPT_CREATE_TABLES;

    static {
        SQL_SCRIPT_CREATE_TABLES = PropertyFactory.getInstance().getProperty().getProperty("db.sqlScriptCreateTables");
        String tablesNames = PropertyFactory.getInstance().getProperty().getProperty("db.tablesNames");
        TABLES_NAME_ARRAY = Arrays.stream(tablesNames.split(",")).collect(Collectors.toList());
    }

    public static void createTables()
    {
        try {
            Connection connection = ConnectionFactory.getInstance().makeConnection();

            for (String tableName : TABLES_NAME_ARRAY){
                if(!tableExists(tableName)){
                    try(Stream<String> lineStream = Files.lines(Paths.get(SQL_SCRIPT_CREATE_TABLES)))
                    {
                        StringBuilder createTableQuery = new StringBuilder();

                        for (String  currentString : lineStream.collect(Collectors.toList())){
                            createTableQuery.append(currentString).append(" ");
                        }
                        try(PreparedStatement ps = connection.prepareStatement(createTableQuery.toString()))
                        {
                            ps.execute();
                        }
                    }
                    catch (IOException ex){
                        throw new FileException("Error with createTables.sql");
                    }
                    catch (SQLException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        }
        catch (ConnectionDBException | FileException ex){
            System.err.println(ex.getMessage());
        }
    }

    public static void createStaff() throws ConnectionDBException{

    }

    private static boolean tableExists(String tableName) throws ConnectionDBException{
        try(Connection connection = ConnectionFactory.getInstance().makeConnection())
        {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet resultSet = meta.getTables(null,null,tableName,new String[]{"TABLE"});
            return resultSet.next();
        }
        catch (SQLException ex) {
            throw new ConnectionDBException("error connection to DB");
        }
    }
    private MyDbInitializer(){}
}