/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Map;
import model.Room;

/**
 *
 * @author lugo
 */
public interface RoomDAOInterface {
    
    public void insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, String idHotel);
    
    public void update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails,  int id);
    
    public Map<String,Object> select(String query);
    
    public void delete(int id);
    
    Room findRoom(int id);
}
