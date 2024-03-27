/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;
import connection.MySQLConnection;
import exceptions.NullConnectionException;
import interfaces.RoomDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lugo
 */
public class RoomDAO implements RoomDAOInterface {
    
    
    public MySQLConnection conexion = new MySQLConnection();
    
    //Stablish connection to database
    public RoomDAO() {
        this.conexion = new MySQLConnection();

    }

    //This method establishes the connection to database, which is necessary to execute the other methods.
    //If connection is null, throws a NullConnectionException
    public Connection connect() { 
        Connection conn = conexion.connectMySQL();
        if (conn != null) {
            return conn;
        }
        throw new NullConnectionException();
    }

    //This method inserts a new row in table "users" with de provided data of a new user 
    @Override
    public void Insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails) { //paste: 
        String insertSQL = "INSERT INTO rooms (room_number,type_room,price_per_night,availability,amenities_details) VALUES (?,?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, roomNumber);
            pstmt.setString(2, typeRoom);
            pstmt.setDouble(3, pricePerNigth);
            pstmt.setBoolean(4,availability );
            pstmt.setString(5, amenitiesDetails);

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

    //This method modifies information of a previously registered user in table "users"
    @Override
    public void Update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails) {
        String updateSQL = "UPDATE rooms SET room_number = ?,  type_room = ?, price_per_night = ?, availability = ?, amenities_details = ?  WHERE room_number = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, roomNumber);
            pstmt.setString(2, typeRoom);
            pstmt.setDouble(3, pricePerNigth);
            pstmt.setBoolean(4,availability );
            pstmt.setString(5, amenitiesDetails);
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

    //This method returns a HashMap that contains data and metadata from table "users"  
    @Override
    public Map<String, Object> select() {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = "SELECT id, room_number, type_room, price_per_nigth, availability, amenities_details  FROM rooms";
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

    //This method deletes a row of a previously registered user in table "users" searching by it's id
    @Override
    public void delete(int id) {
        String deleteSQL = "DELETE FROM rooms WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
    }

    
}
