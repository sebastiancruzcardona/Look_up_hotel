/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import connection.DataBaseSingleton;
import connection.MySQLConnection;
import exceptions.HotelNameAlreadyInDataBase;
import exceptions.NullConnectionException;
import exceptions.ThisHotelDoesNotExistException;
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
import javax.swing.JOptionPane;
import model.Hotel;

/**
 *
 * @author ASUS - JOSE
 */
public class HotelDAO implements HotelDAOInterface {

    public Connection connection;

    //Stablish connection to database
    public HotelDAO() {
        connection = DataBaseSingleton.getInstance().getConnection();
    }

   

    @Override
    //This method inserts a new row in table "hotels" with de provided data of a new hotel
    public boolean insert(String name, String address, int classification, String comforts) {
        String insertSQL = "INSERT INTO hotels (name,address,classification,comforts) VALUES (?,?,?,?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, classification);
            pstmt.setString(4, comforts);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successful insertion");
                return true;
            } else {
                System.out.println("No insertion was made");
                return false;
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    //This method modifies information of a previously registered hotel in table "hotels", searching by its id
    public boolean update(String name, String address, int classification, String comforts, int id) {
        String updateSQL = "UPDATE hotels SET name = ?,  address = ?, classification = ?, comforts = ?  WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setInt(3, classification);
            pstmt.setString(4, comforts);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfull update");
                return true;
            } else {
                System.out.println("No update was made");
                return false;
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data update");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    //This method returns a HashMap that contains data and metadata from table "hotels"
    public Map<String, Object> select(String query) {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = query;
        try ( PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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

        } catch (SQLException | NullConnectionException e) {
            //If an exception occurs
            System.out.println("An error occurred while connecting to database for selection");
            e.printStackTrace();
        }

        //Print the result map for debugging
        System.out.println(result);

        //Return the result Map
        return result;
    }

    @Override
    //This method deletes a row of a previously registered hotel in table "hotels" searching by its id
    public boolean delete(int id) {
        String deleteSQL = "DELETE FROM hotels WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * This method brings out the uri addresses of the stored images of an hotel
     * from table "images". This method is to be used inside the findHotel
     * method, because this does not validate for it self if there is a hotel
     * identified by the provided id. That is why this method is not called in
     * HotelServices
     *
     * @param id
     * @return A String ArrayList of images. If there are not images, the
     * Arraylist is empty
     */
    public ArrayList<String> findHotelImages(int id) {
        ArrayList<String> images = new ArrayList<>();
        String selectSQL = "SELECT uri FROM images WHERE id_hotel = ?";
        try ( PreparedStatement pstm = connection.prepareStatement(selectSQL)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                images.add(rs.getString("uri"));
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for finding hotel images");
            e.printStackTrace();
        }
        return images;
    }

    @Override
    /**
     * This method finds a hotel registered in table "hotels" and returns it. If
     * it finds a hotel, this method calls findHotelImages method to set the
     * hotel's ArrayList of images
     *
     * @param id
     * @return A Hotel if the hotel exists, or null, if there is not a hotel
     * with that id
     */
    public Hotel findHotel(int id) {
        String selectSQL = "SELECT id, name, address, classification, comforts FROM hotels WHERE id = ?";
        try ( PreparedStatement pstm = connection.prepareStatement(selectSQL)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getInt("classification"), rs.getString("comforts"), findHotelImages(id));
                return hotel;
            } else {
                throw new ThisHotelDoesNotExistException();
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for finding hotel");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    // This method creates an ArrayList with hotel names from table "hotels"
    public ArrayList<String> selectNameHotels() {
        String selectSQL = "SELECT name FROM hotels";
        ArrayList<String> hotelsName = new ArrayList<>();
        try ( PreparedStatement pstm = connection.prepareStatement(selectSQL)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                hotelsName.add(rs.getString("name"));
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for hotels names selection");
            e.printStackTrace();
        }
        return hotelsName;
    }

    @Override
    //This method validates if the name provided for a hotel is available. If the name is not available throws a HotelNameAlreadyInDataBase exception
    public boolean validateHotelNameAvailability(String name) {
        String consultationSQL = "SELECT *  FROM hotels WHERE name = ? ";
        try ( PreparedStatement pstmt = connection.prepareStatement(consultationSQL)) {
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return true;
            } else {
                throw new HotelNameAlreadyInDataBase();

            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
        }
        return false;
    }

}
