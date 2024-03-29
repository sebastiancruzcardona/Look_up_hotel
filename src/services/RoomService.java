/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.RoomDAO;
import java.util.Map;

/**
 *
 * @author lugo
 */
public class RoomService {
    RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }
    
     //This method calls insert method from UserDAO
    public void insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails){
        roomDAO.insert(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails);
    }
    
    //This method calls update method from UserDAO
    public void update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails){
        roomDAO.update(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails, 0);
    }
    
    //This method returns a HashMap calling userDAO select method
    public Map<String, Object> select(){
        return roomDAO.select();
    }
    
    //This method calls delete method from UserDAO
    public void delete(int id){
        roomDAO.delete(id);
    }
}
