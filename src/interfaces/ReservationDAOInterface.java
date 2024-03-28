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
    
    public void insert(int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, int status, double totalPrice);
    
    public void update(int status, int id);
    
    public Map<String,Object> clientSelect(int id);
    
    public Map<String,Object> adminSelect(int status);
    
    public void delete(int id);
}
