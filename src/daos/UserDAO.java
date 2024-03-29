/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import connection.MySQLConnection;
import exceptions.EmailNotExistException;
import exceptions.IncorrectPasswordException;
import exceptions.NullConnectionException;
import interfaces.UserDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleRole;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author ASUS - JOSE
 */
public class UserDAO implements UserDAOInterface{
    
    public MySQLConnection connection;

    //Stablish connection to database
    public UserDAO() {
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
    //This method inserts a new row in table "users" with de provided data of a new user
    public void insert(String name, String email, String password, String contact) {
        String insertSQL = "INSERT INTO users (full_name,email,password,contact,id_rol) VALUES (?,?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, contact);
            pstmt.setInt(5, 2);//Registered users are client by defaul 

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
    //This method modifies information of a previously registered user in table "users"
    public void update(String name, String email, String password, String contact) {
        String updateSQL = "UPDATE users SET full_name = ?,  email = ?, password = ?, contact = ?  WHERE email = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, contact);
            pstmt.setString(5, email);
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
    //This method returns a HashMap that contains data and metadata from table "users"  
    public Map<String, Object> select() {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = "SELECT u.id, u.full_name, u.email, u.password, u.contact, r.name FROM users u JOIN rols r on u.id_rol = r.id";
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
    //This method deletes a row of a previously registered user in table "users" searching by it's id
    public void delete(int id) {
        String deleteSQL = "DELETE FROM users WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
    }
    
    /**
     *  This method validates the email found in the database
     * @param email
     * @return true or false
     */
    @Override
     public boolean findEmail (String email) {
        
        String consultationSQL = "SELECT *  FROM users WHERE email = ? ";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(consultationSQL)){
            pstmt.setString(1, email);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                return true;
            }
            else{
                throw  new EmailNotExistException();//Exception if email dont exist in Data base
                
                
            
            }
        } catch (SQLException  | NullConnectionException  | EmailNotExistException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return false;
        
    }
    
     /**
      * his method validates if a user is registered in table "users" and returns the user
      * @param email
      * @param password
      * @return user
      */
    @Override
    public User findUser(String email, String password){
        
        boolean aux = findEmail(email);
        
        if(aux){
            String serchSQL = "SELECT * FROM users WHERE email = ? AND password = ? ";
            try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(serchSQL)){
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
                if(rs.next()){
                
                    System.out.println("entra");
                    User user = new User(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"), rs.getNString("password"), rs.getString("contact"), rs.getInt("id_rol"));
                    return user;
                
                }
                else{
                    throw new IncorrectPasswordException();
                
                
                
            
                }
             } catch (SQLException  | NullConnectionException | IncorrectPasswordException e) {
                System.out.println("An error occurred while connecting to database for deletion of data");
                
                JOptionPane.showMessageDialog(null, e.getMessage());
                
        }
        }
        return null;
    }
}
