/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.ReservationDAO;
import java.util.Map;

/**
 *
 * @author lugo
 */
public class ReservationService {
    ReservationDAO reservationDAO;

    public ReservationService() {
        reservationDAO = new ReservationDAO();
    }
    
     public Map<String, Object> select(java.sql.Date entry_date, java.sql.Date departure_date, int id_hotel, int numberPerson){
        return reservationDAO.selectReservatedRooms(entry_date, departure_date, id_hotel, numberPerson);
    }
}
