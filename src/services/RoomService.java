/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.RoomDAO;
import exceptions.EmptyFieldsException;
import exceptions.EmptySearchFieldException;
import exceptions.NotATypeOfRoomException;
import exceptions.NotAlphaNumericException;
import exceptions.NotDoubleNumberException;
import helper.RegularExpressions;
import java.util.Map;
import model.Room;

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
    public void insert(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, String idHotel){
        validateAlphaNumeric(roomNumber);
        validateTypeRoom(typeRoom);
        validateNumericDouble(String.valueOf(pricePerNigth));
        roomDAO.insert(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails,idHotel);
    }
    
    //This method calls update method from RoomDAO
    public void update(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails,int id){
        validateAlphaNumeric(roomNumber);
        validateTypeRoom(typeRoom);
        validateNumericDouble(String.valueOf(pricePerNigth));
        roomDAO.update(roomNumber, typeRoom, pricePerNigth, availability, amenitiesDetails,id);
    }
    
    //This method returns a HashMap calling RoomDAO select method
    public Map<String, Object> select(String name){
        return roomDAO.select(createSelectQuery(name));
    }
    
    //This method calls delete method from RoomDAO
    public void delete(int id){
        roomDAO.delete(id);
    }
    //This method calls findRoom method from RoomDAO
    public Room findRoom(int id){
        return roomDAO.findRoom(id);
    }
    
    //This methd validates if all fields were filled out
    public void validateFilledFields(String roomNumber, String typeRoom, double pricePerNigth, boolean availability, String amenitiesDetails, String idHotel){
        if(roomNumber.equals("") || typeRoom.equals("") || amenitiesDetails.equals("") || idHotel.equals("") || pricePerNigth == 0) {
                
                throw new EmptyFieldsException();
        }
     }
    
    //This method calls validateAlphaNumeric from helper.RegularExpressions
    public void validateAlphaNumeric(String string){
        if(!RegularExpressions.validateAlphaNumeric(string)){
            throw new NotAlphaNumericException();
        }
    }
    
    //This method calls validateTypeRoom from helper.RegularExpressions
    public void validateTypeRoom(String string){
        if(!RegularExpressions.validateTypeRoom(string)){
            throw new NotATypeOfRoomException();
        }
    }
    
    //This method calls validateTypeRoom from helper.RegularExpressions
    public void validateNumericDouble(String string){
        if(!RegularExpressions.validateNumeric(string)){
            throw new NotDoubleNumberException();
        }
    }
    /**
      * This method creates the appropriate query for the select method
     * 
     * @param String name
     * @return The standar select query if name == null. The select query with a LIKE condition if !name == null.
     * If name.equals(""), thows an EmptySearchFieldException
     */
    public String createSelectQuery(String name){
        String query = " SELECT r.id, r.room_number, t.type_room, r.price_per_night, r.availability, r.amenities_details, h.name  "
                + "FROM rooms  "
                + "r JOIN type_rooms t ON r.id_type_room = t.id  "
                + "JOIN hotels h ON r.id_hotel = h.id ";
        if(name == null){
            return query;
        }else if (name.equals("")){
            throw new EmptySearchFieldException();
        }
      
        query += " AND h.name ="+ "'"+name + "'";
         
          System.out.println(query);
          return query;
    }
   
}