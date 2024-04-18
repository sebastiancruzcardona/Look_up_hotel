/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.ReservationDAO;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lugo
 */
public class ReservationService {

    ReservationDAO reservationDAO;

    public ReservationService() {
        reservationDAO = new ReservationDAO();
    }
    //This method calls insert method from ReservationDAO  
    public Map<String, Object> select(java.sql.Date entry_date, java.sql.Date departure_date, int id_hotel, int numberPerson) {
        return reservationDAO.selectReservatedRooms(entry_date, departure_date, id_hotel, numberPerson);
    }

    
    //This method calls insert method from ReservactionDAO
    public void insert (int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, int status, double totalPrice){
        long entry_long = entryDate.getTime();
        long departure_long = departureDate.getTime();
        
         java.sql.Date entry_date = new java.sql.Date(entry_long);
         java.sql.Date departure_date = new java.sql.Date(departure_long);       
            
            
        validateInsertion(reservationDAO.insert(idUser, idHotel, idRoom, entry_date, departure_date, status, totalPrice));
    }
    
    
    //this method validate if answer is true or false from getion data base
    public void validateInsertion(boolean answer) {
        if (answer) {
            JOptionPane.showMessageDialog(null, "User successfully created");
        } else {
            JOptionPane.showMessageDialog(null, "No insertion was made");
        }
    }
    
    
    // this method calculate the total price to reservation
    
    public double calculateTotalPrice(double pricePorNight, int totalDays){
            
        return pricePorNight*totalDays;
        
    }
}
