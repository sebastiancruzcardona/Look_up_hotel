/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.HotelDAO;
import exceptions.EmptyFieldsException;
import exceptions.EmptySearchFieldException;
import exceptions.NoChangeWasMadeException;
import exceptions.NoClassificationOptionChosen;
import java.util.ArrayList;
import java.util.Map;
import model.Hotel;

/**
 *
 * @author lugo
 */
public class HotelService {
   HotelDAO hotelDAO;

    public HotelService() {        
        hotelDAO = new HotelDAO();
    }
   
   //This method calls insert method from HotelDAO
    public void insert(String name, String address, int classification, String comforts){
        hotelDAO.insert(name, address, classification, comforts);
    }
    
    //This method validates if there have been made changes to the values brought out from database.
    //If there have been made changes, calls update method from HotelDAO
    //If not, throws a NoChangeWasMadeException()
    public void update(String name, String address, int classification, String comforts, int id, Hotel hotel){
        if(!hotel.getName().equals(name) || !hotel.getAddress().equals(address) || hotel.getClassification() != classification || !hotel.getComforts().equals(comforts)){
            hotelDAO.update(name, address, classification, comforts, id);
        }else{
            throw new NoChangeWasMadeException();
        }
        
    }
    
    //This method returns a HashMap calling HotelDAO select method
    public Map<String, Object> select(){
        return hotelDAO.select();
    }
    
    public Map<String,Object> selectHotelSearch(String name){
        if(name.equals("")){
            throw new EmptySearchFieldException();
        }
        return hotelDAO.selectHotelSearch(name);
    }
    
    //This method calls delete method from HotelDAO
    public void delete(int id){
        hotelDAO.delete(id);
    }
    
    //This method calls findHotel method from HotelDAO
    public Hotel findHotel(int id){
        return hotelDAO.findHotel(id);
    }
    
    //This method calls selectHotelsName from HotelDAO
    public ArrayList<String> selectHotelsName(){
        return hotelDAO.selectNameHotels();
    }
    
    //This methd validates if all fields were filled out
    public void validateFilledFields(String name, String address, int classification, String comforts){
        if(name.equals("") || address.equals("") || comforts.equals("")){
            throw new EmptyFieldsException();
        }
        
        if(classification == 0){
            throw new NoClassificationOptionChosen();
        }
    }
    
    //This method calls validateHotelNameAvailability from HotelDAO
    public boolean validateHotelNameAvailability(String name){
        return hotelDAO.validateHotelNameAvailability(name);
    }
    
    //This method overloads validateHotelNameAvailability. This one validates if the name brought out from database has been changed
    //If the name has been changed, it calls validateHotelNameAvailability method from HotelDAO
    public boolean validateHotelNameAvailability(String name, Hotel hotel) {
        if (!hotel.getName().equals(name)) {
            hotelDAO.validateHotelNameAvailability(name);
        }
        return true;
    }
   
}
