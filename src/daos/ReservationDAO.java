/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import connection.DataBaseSingleton;
import connection.MySQLConnection;
import exceptions.NullConnectionException;
import interfaces.ReservationDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lugo
 */
public class ReservationDAO implements ReservationDAOInterface{
    public Connection connection;
    
    //Stablish connection to database
    public ReservationDAO() {
        connection = DataBaseSingleton.getInstance().getConnection();

    }

   

    //This method inserts a new row in table "reservations" with de provided data of a new reservation 
    @Override
    public void insert(int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, int status, double totalPrice) { //paste: 
        String insertSQL = "INSERT INTO reservations (id_user,id_hotel,id_room,entry_date,departure_date,status,total_price) VALUES (?,?,?,?,?,?,?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, idUser);
            pstmt.setInt(2, idHotel);
            pstmt.setInt(3, idRoom);
            pstmt.setDate(4, (java.sql.Date) entryDate);
            pstmt.setDate(5, (java.sql.Date) departureDate);
            pstmt.setInt(6, status);
            pstmt.setDouble(7, totalPrice);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successful insertion");
                JOptionPane.showMessageDialog(null,"Reservation succesfully created");
            } else {
                System.out.println("No insertion was made");
                JOptionPane.showMessageDialog(null,"Reservation was not created");
            }
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data insertion");
            e.printStackTrace();
        }
    }

    //This method modifies the status of a previously registered reservation in table "reservations"
    @Override
    public void update(int status, int id) {
        String updateSQL = "UPDATE reservations SET status = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setInt(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfull update");
                JOptionPane.showMessageDialog(null,"Reservation succesfully updated");
            } else {
                System.out.println("No update was made");
                JOptionPane.showMessageDialog(null,"No update was made");
            }

        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for data update");
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Object> selectReservatedRooms(java.sql.Date entry_date, java.sql.Date departure_date, int id_hotel, int namberPerson) {
        /*String selectSQL = "SELECT id_room FROM reservations WHERE id_hotel = " + id_hotel + 
                " NOT (entry_date BETWEEN " + entry_date + " AND " + departure_date + 
                " OR departure_date BETWEEN " + entry_date + " AND " + departure_date + ")";*/
        //ESTA PRIMERA CONSULTA ENCONTRARÍA LOS ID DE LAS HABITACIONES QUE SON DE UN HOTEL ESPECÍFICO QUE NO ESTÁN RESERVADAS EN ESE PERIODO DE TIEMPO
        //FABIÁN, ESTA FORMA DE HACER LA CONSULTA REQUERIRÍA LA CREACION INICIAL DE RESERVAS CON TODOS LOS ROOMS
        //PODRÍA HACERSE, AL CREAR UN ROOM, POR DEFECTO Y DE MANERA NO VISIBLE, LA CREACION DE UNA RESERVA "INICIAL" DE ESE ROOM
        //PARA QUE TODO ID DE ROOM ESTÉ EN LAS RESERVAS Y ESTO PUEDA FUNCIONAR
        //PARA QUE LOS PUEDA ENCONTRAR TODOS EN LAS RESERVAS
        //y LUEGO REQUERIRÍA UN JOIN CON LA TABLA ROOMS PARA OBTENER LA INFO DE LOS ROOMS DISPONIBLES
        
        //LA OTRA FORMA QUE SE ME OCURRE SERÍA CON UNA RESTA DE CONJUNTOS
        
        String selectSQL = "SELECT r.id, r.room_number, t.type_room, r.price_per_night, r.availability, r.amenities_details, h.name\n"
                + " FROM rooms r \n"
                + "JOIN type_rooms t ON r.id_type_room = t.id \n "
                + "JOIN hotels h ON r.id_hotel = h.id \n "
                + "WHERE r.id_hotel = "+ id_hotel + " AND r.id_type_room = "+namberPerson+" AND r.id NOT IN ( "
                + " SELECT reserve.id_room "
                + " FROM reservations  reserve " +
                "WHERE( reserve.id_hotel = "+ id_hotel + "\n"
                + " AND  (" 
                + "(reserve.entry_date BETWEEN '" + entry_date + "' AND '" + departure_date + "') \n"+
                " OR( reserve.departure_date BETWEEN '" + entry_date + "' AND '"+ departure_date +"')\n"
                   
                
                
                + ")))";
                
        
          
        
         System.out.println(selectSQL);
        //ESTA CONSULTA ENCONTRARÍA LOS ID DE LAS HABITACIONES QUE SON DE UN HOTEL ESPECÍFICO QUE SI ESTÁN RESERVADAS EN ESE PERIODO DE TIEMPO
        //ES DECIR, ES CONTRARIA A LA OTRA
        //LA VUELTA CON ESTA ES QUE FALTA ESCRIBIR LO DEMÁS, QUE SERÍA LA PROYECCIÓN DEL ID DE ROOMS DONDE ID_HOTEL SEA IGUAL A id_hotel
        //A ESA PROYECCION RESTARLE ESTA SELECTSQL, PORA QUE QUEDEN LOS ID DE LAS ROOMS QUE NO ESTÁN RESERVADAS EN ESE PERIODO DE TIEMPO
        //y AHÍ HACER UN JOIN CON ROOMS PARA SACAR TODOS LOS DATOS DE ESOS ROOMS.
        //oBVIAMENTE TODO ESO QUEDA EN UNA SOLA CONSULTA, PORQUE AQUÍ NO SE PUEDE HACER POR TEMPORALES, 
        //PERO ESTOY MUY TOSTADO Y EN ESTE MOMENTO NO ME DA PARA HACER ESO, PORQUE SE AGRANDA BASTANTE Y TOCA PENSARLA BIEN
        
        Map<String, Object> result = new HashMap<>();
        
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
    
    
    
    

    //This method returns a HashMap that contains data and metadata from table "reservations". The shown data is de corresponding to one client
    @Override
    public Map<String, Object> clientSelect(int id) {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = "SELECT id_user, id_hotel, id_room, entry_date, departure_date, total_price id_reservation_statuses FROM reservations WHERE id_user =" + id;
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
    //This method returns a HashMap that contains data and metadata from table "reservations". If status = 1, will show pending reservatiosn, if status = 2 will show confirmed reservations, if status = 3 will show canceled reservations
    public Map<String, Object> adminSelect(int status) {
        //Initialize result HashMap. This map wil contain column names, number of columns and table data
        //Map<keyDataType, valueDataType>
        Map<String, Object> result = new HashMap<>();
        String selectSQL = "SELECT id_user, id_hotel, id_room, entry_date, departure_date, total_price id_reservation_statuses FROM reservations WHERE id_reservation_statuses =" + status;
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
    
    

    //This method deletes a row of a previously registered user in table "reservations" searching by it's id
    @Override
    public void delete(int id) {
        String deleteSQL = "DELETE FROM reservations WHERE id = ?";
        try ( PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Reservation succesfully deleted");
        } catch (SQLException | NullConnectionException e) {
            System.out.println("An error occurred while connecting to database for deletion of data");
            e.printStackTrace();
        }
    }
}
