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
import exceptions.NotAlphaException;
import exceptions.NotAlphaNumericException;
import exceptions.NotAnAddressException;
import exceptions.NotValidClassificationExcpetion;
import helper.RegularExpressions;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
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
        validateAlphaNumeric(name);
        validateAlphaNumericPointComma(comforts);
        validateAddress(address);
        validateClassification(classification);
        validateInsertion(hotelDAO.insert(name, address, classification, comforts));
    }
    
    //This method validates if there have been made changes to the values brought out from database.
    //If there have been made changes, calls update method from HotelDAO
    //If not, throws a NoChangeWasMadeException()
    public void update(String name, String address, int classification, String comforts, int id, Hotel hotel){
        if(!hotel.getName().equals(name) || !hotel.getAddress().equals(address) || hotel.getClassification() != classification || !hotel.getComforts().equals(comforts)){
            validateAlphaNumeric(name);
            validateAlphaNumericPointComma(comforts);
            validateAddress(address);
            validateClassification(classification);
            validateUpdate(hotelDAO.update(name, address, classification, comforts, id));
        }else{
            throw new NoChangeWasMadeException();
        }
        
    }
    
    //This method returns a HashMap calling HotelDAO select method
    public Map<String, Object> selectUserHome(String name){
        return hotelDAO.select(createSelectQueryClient(name));
    }
    
//This method returns a HashMap calling HotelDAO select method
    public Map<String, Object> select(String name){
        return hotelDAO.select(createSelectQuery(name));
    }
    
    //This method calls delete method from HotelDAO
    public void delete(int id){
        validateDelete(hotelDAO.delete(id));
    }
    
    //This method calls findHotel method from HotelDAO
    public Hotel findHotel(String hotelName){
        return hotelDAO.findHotel(hotelName);
    }
    
    //This method calls findHotel method from HotelDAO
    public Hotel findHotel(int id){
        return hotelDAO.findHotel(id);
    }
    
    //This method calls selectHotelsName from HotelDAO
    public ArrayList<String> selectHotelsName(){
        return hotelDAO.selectNameHotels();
    }
    
    //This method calls validateAlphaNumeric from helper.RegularExpressions
    public void validateAlphaNumeric(String string){
        if(!RegularExpressions.validateAlphaNumeric(string)){
            throw new NotAlphaNumericException();
        }
    }
    
    //This method calls validateAlphaNumericPontComma from helper.RegularExpressions
    public void validateAlphaNumericPointComma(String string){
        if(!RegularExpressions.validateAlphaNumericPointComma(string)){
            throw new NotAlphaNumericException();
        }
    }
    
    //This method calls validateAddress from helper.RegularExpressions
    public void validateAddress(String string){
        if(!RegularExpressions.validateAddress(string)){
            throw new NotAnAddressException();
        }
    }
    
    //This method calls validateClassiHotelRoomfication from helper.RegularExpressions
    public void validateClassification(int number){
        if(!RegularExpressions.validateHotelRoomClassification(number)){
            throw new NotValidClassificationExcpetion();
        }
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
    
    //this method validates if answer is true or false for insertion
    public void validateInsertion(boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"Hotel successfully created");
        }else{
            JOptionPane.showMessageDialog(null,"No insertion was made");
        }
    }
    
    //this method validates if answer is true or false for update
    public void validateUpdate(boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"Hotel successfully updated");
        }else{
            JOptionPane.showMessageDialog(null,"No update was made");
        }
    }
    
    //this method validates if answer is true or false for deletion
    public void validateDelete(boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"Hotel successfully deleted");
        }else{
            JOptionPane.showMessageDialog(null,"No deletion was made");
        }
    }
    
    public ArrayList<Hotel> selectHotels(){
        return hotelDAO.selectHotels();
    }
    
    /**
     * This method creates the appropriate query for the select method
     * 
     * @param String name
     * @return The standar select query if name == null. The select query with a LIKE condition if !name == null.
     * If name.equals(""), thows an EmptySearchFieldException
     */
    public String createSelectQuery(String name){
        String query = "SELECT id, name, address, classification, comforts FROM hotels";
        if(name == null){
            return query;
        }else if (name.equals("")){
            throw new EmptySearchFieldException();
        }
        //This query allows finding non-exact matches
        return query += " WHERE name LIKE '%" + name + "%'";
                
                //This query is only for exact matches
                //query += " WHERE name ="  +"'"+ name + "'";        
    }
   
    
    /**
     * This method creates the appropriate query for the select method
     * 
     * @param String name
     * @return The standar select query if name == null. The select query with a LIKE condition if !name == null.
     * If name.equals(""), thows an EmptySearchFieldException
     */
    public String createSelectQueryClient(String name){
        String query = "SELECT  name, address, classification, comforts FROM hotels";
        if(name == null){
            return query;
        }else if (name.equals("")){
            throw new EmptySearchFieldException();
        }
        //This query allows finding non-exact matches
        return query += " WHERE name LIKE '%" + name + "%'";
                
                //This query is only for exact matches
                //query += " WHERE name ="  +"'"+ name + "'";        
    }
}
