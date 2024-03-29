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

    public RoomService() {
        roomDAO = new RoomDAO();
    }
    
     //This method calls insert method from RoomDAO
    public void insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, int idHotel){
        roomDAO.insert(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails,idHotel);
    }
    
    //This method calls update method from RoomDAO
    public void update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, int idHotel,int id){
        roomDAO.update(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails,idHotel,id);
    }
    
    //This method returns a HashMap calling RoomDAO select method
    public Map<String, Object> select(){
        return roomDAO.select();
    }
    
    //This method calls delete method from RoomDAO
    public void delete(int id){
        roomDAO.delete(id);
    }
}
