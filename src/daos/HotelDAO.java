/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import connection.MySQLConnection;
import exceptions.NullConnectionException;
import interfaces.HotelDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Hotel;

/**
 *
 * @author ASUS - JOSE
 */
public class HotelDAO implements HotelDAOInterface{
    
    public MySQLConnection connection;

    //Stablish connection to database
    public HotelDAO() {
        this.connection = new MySQLConnection();
    }
    
    //This method establishes the connection to database, which is necessary to execute the other methods.
    //If connection is null, throws a NullConnectionException
    public Connection connect() { 
        Connection conn = connection.connectMySQL();
        if (conn != null) {
            return conn;
        }
        throw new NullConnectionException();
    }

    @Override
    //This method inserts a new row in table "hotels" with de provided data of a new hotel
    public void insert(String name, String address, int classification, String comforts) {
        String insertSQL = "INSERT INTO hotels (name,address,classification,comforts) VALUES (?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, classification);
            pstmt.setString(4, comforts);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successful insertion");
            } else {
                System.out.println("No insertion was made");
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
    }

    @Override
    //This method modifies information of a previously registered hotel in table "hotels", searching by its id
    public void update(String name, String address, int classification, String comforts, int id) {
        String updateSQL = "UPDATE hotels SET name = ?,  address = ?, classification = ?, comforts = ?  WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, classification);
            pstmt.setString(4, comforts);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfull update");
            } else {
                System.out.println("No update was made");
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data update");
            e.printStackTrace();
        }
    }

    @Override
    //This method returns a HashMap that contains data and metadata from table "hotels"
    public Map<String, Object> select() {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = "SELECT name, address, classification, comforts FROM hotels";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            //Execute query and get the results in a ResultSet 
            ResultSet rs = pstmt.executeQuery();

            //Get metadata from ResultSet. Metadata contains information about results such as number of columns an column names
            ResultSetMetaData rsmd = rs.getMetaData();

            //Get number of columns from metadata
            int numColumns = rsmd.getColumnCount();

            //Create a list to save column names
            List<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= numColumns; i++) {
                //Get each column name from metadata and add them to columnNames list
                columnNames.add(rsmd.getColumnName(i));
            }

            //Create a list of lists to save table data
            List<List<Object>> tableData = new ArrayList<>();
            while (rs.next()) {
                //Create a list to save data from the current row
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= numColumns; i++) {
                    //Get every colum data and add it them to list
                    rowData.add(rs.getObject(i));
                }
                //Add data list (that represents a row from table) to de tableData list
                tableData.add(rowData);
            }

            //Add number of columns, column names and table data to de result HasMap
            result.put("numColumns", numColumns);
            result.put("columnNames", columnNames);
            result.put("tableData", tableData);
            
        }catch (SQLException | NullConnectionException e) {
            //If an exception occurs
            System.out.println("An error occurred while connecting to database for selection");
        e.printStackTrace();
        }
        
        //Print the result map for debugging
        System.out.println (result);

        //Return the result Map
        return result ;
    }

    @Override
    //This method deletes a row of a previously registered hotel in table "hotels" searching by its id
    public void delete(int id) {
        String deleteSQL = "DELETE FROM hotels WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
    }    
    // This method create a ArrayList with hotel names from table "hotels"
    @Override
    public ArrayList<String> selectNameHotels() {
        String selectSQL = "SELECT name FROM hotels";
        ArrayList<String> hotelsName = new  ArrayList<>();
        try(Connection conn = connect(); PreparedStatement pstm = conn.prepareStatement(selectSQL)) {
            
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                
               hotelsName.add(rs.getString("name"));
                
               
                
            }
            
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }return hotelsName;
    }

    
}

