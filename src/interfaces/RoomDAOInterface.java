/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Map;

/**
 *
 * @author lugo
 */
public interface RoomDAOInterface {
    
    public void Insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails);
    
    public void Update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails);
    
    public Map<String,Object> select();
    
    public void delete(int id);
}