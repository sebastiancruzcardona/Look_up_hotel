/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.MySQLConnection;
import exceptions.NullConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class UserController {

    
    public MySQLConnection conexion = new MySQLConnection();

    //Stablish connection to database
    public UserController() {
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
    public void Insert(String name, String email, String password, String contact) { //paste: 
        String insertSQL = "INSERT INTO users (full_name,email,password,contact) VALUES (?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, contact);

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
    public void Update(String name, String email, String password, String contact) {
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

    //This method prints out all rows from table "users"
    public void select() {
        String selectSQL = "SELECT * FROM users";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + ", name: " + rs.getString("full_name") + ", email: " + rs.getString("email") + ", password: " + rs.getString("password") + ", contact info: " + rs.getString("contact"));
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for selection");
            e.printStackTrace();
        }
    }

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
}
