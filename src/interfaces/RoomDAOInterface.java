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
    
    boolean insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, String idHotel);
    
    boolean update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails,  int id);
    
    Map<String,Object> select(String query);
    
    boolean delete(int id);
    
    boolean deleteByHotel(int id_hotel);
    
    Room findRoom(int id);
}
