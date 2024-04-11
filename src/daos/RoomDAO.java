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
import javax.swing.JOptionPane;
import model.Room;


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

    //This method inserts a new row in table "rooms" with de provided data of a new room
    @Override
    public void insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, String idHotel) { //paste: 
        String insertSQL = "INSERT INTO rooms (room_number,id_type_room,price_per_night,availability,amenities_details, id_hotel) VALUES (?,(SELECT id FROM type_rooms WHERE type_room = ?),?,?,?,(SELECT id FROM hotels WHERE name =?))";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, roomNumber);
            pstmt.setString(2, typeRoom);
            pstmt.setDouble(3, pricePerNigth);
            pstmt.setBoolean(4,availability );
            pstmt.setString(5, amenitiesDetails);
            pstmt.setString(6, idHotel);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Successful insertion");
            } else {
                System.out.println("No insertion was made");
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
    }

    //This method modifies information of a previously registered user in table "rooms"
    @Override
    public void update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, int id) {
        String updateSQL = "UPDATE rooms SET room_number = ?,  id_type_room = (SELECT id FROM type_rooms WHERE type_room = ?), price_per_night = ?, availability = ?, amenities_details = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, roomNumber);
            pstmt.setString(2, typeRoom);
            pstmt.setDouble(3, pricePerNigth);
            pstmt.setBoolean(4,availability );
            pstmt.setString(5, amenitiesDetails);
            pstmt.setInt(6, id);
            
            pstmt.executeUpdate();

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Successfull update");
            } else {
                JOptionPane.showMessageDialog(null,"No update was made");
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data update");
            e.printStackTrace();
        }
    }

    //This method returns a HashMap that contains data and metadata from table "rooms"  
    @Override
    public Map<String, Object> select(String query) {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = query;
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

    //This method deletes a row of a previously registered user in table "rooms" searching by it's id
    @Override
    public void delete(int id) {
        String deleteSQL = "DELETE FROM rooms WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Successfully deleted room");
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
    }

    /**
     *  This method find a room registered in table "rooms" and returns the room
     * @param id
     * @return
     */
    @Override
    public Room findRoom(int id) {
        String selectSQL = "SELECT * FROM rooms WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement pstm = conn.prepareStatement(selectSQL)) {
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()) {
                
               Room room = new Room(rs.getInt("id"), rs.getString("room_number"), rs.getString("id_type_room"),rs.getDouble("price_per_night"), rs.getBoolean("availability"), rs.getString("amenities_details"), null);
                
               return room;
            }
            else{
                JOptionPane.showMessageDialog(null, "es null");
            }
            
            
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
        return null;
    }

    
}
