/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.HotelDAO;
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
    
    //This method calls update method from HotelDAO
    public void update(String name, String address, int classification, String comforts){
        hotelDAO.update(name, address, classification, comforts, classification);
    }
    
    //This method returns a HashMap calling HotelDAO select method
    public Map<String, Object> select(){
        return hotelDAO.select();
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
    
   
}
