/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author lugo
 */
public interface ReservationDAOInterface {
    public void Insert(int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, String status, double totalPrice);
    
    public void Update(int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, String status, double totalPrice);
    
    public Map<String,Object> select();
    
    public void delete(int id);
}
