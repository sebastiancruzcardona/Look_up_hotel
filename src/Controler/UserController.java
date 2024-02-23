/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Connetion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author fabian-lugo
 */
public class UserController {

// Creamos un objeto de la clase ConexionMySQL
    public ConexionMySQL conexion = new ConexionMySQL();

    // Establecemos la conexión con la base de datos
    public UserController() {
        this.conexion = new ConexionMySQL();

    }

    //This method inserts a new row in table "User" with de provided data of a new user 
    public void Insert(String name, String  email, String password, String contact) {
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Ejemplo de INSERT
                String insertSQL = "INSERT INTO User (full_name,email,password,contact) VALUES (?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, email);
                    pstmt.setString(3, password);
                    pstmt.setString(4, contact);
                    
                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Insert successful");
                    } else {
                        System.out.println("i cant insert the data");
                    }
                }

            } else {
                System.out.println("No se puedo establecer la conexion con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al relizar la seleccion de la base de datos");
            e.printStackTrace();
        }

    }

    public void Update(String name, int edad, String email) throws SQLException {

        try (Connection conn = conexion.conectarMySQL()) {

            if (conn != null) {
                String updateSQL = "UPDATE User SET nombre = ?,  edad = ?  WHERE correo= ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(1, name);
                    pstmt.setString(3, email);
                    pstmt.setInt(2, edad);
                    pstmt.executeUpdate();

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Inser");
                    }

                }

            }
        }
    }

    public void select() {
        try (Connection conn = conexion.conectarMySQL()) {
            if (conn != null) {

                String selectSQL = "SELECT * FROM User";

                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        System.out.println("Name: " + rs.getString("nombre") + ",email: " + rs.getString("correo") + ", edad: " + rs.getString("edad"));
                    }

                }
            } else {
                System.out.println("No se puedo establecer la conexion con la base de datos");
            }

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al relizar la seleccion de la base de datos");
            e.printStackTrace();
        }
    }

    public void delete(String nombre) {
        try (Connection conn = conexion.conectarMySQL()) {
            if (conn != null) {
                String deleteSQL = "DELETE FROM User WHERE nombre = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setString(1, nombre);
                    pstmt.executeUpdate();
                }
            } else {
                System.out.println("No se puedo establecer la conexion con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al relizar la seleccion de la base de datos");
            e.printStackTrace();
        }

    }
}
