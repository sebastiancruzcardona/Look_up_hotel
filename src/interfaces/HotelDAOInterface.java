/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Hotel;

/**
 *
 * @author ASUS - JOSE
 */
public interface HotelDAOInterface {
    
    void insert(String name, String address, int classification, String comforts);
    
    void update(String name, String address, int classification, String comforts, int id);
    
    Map<String,Object> select();
    
    void delete(int id);
    
    ArrayList<String> selectNameHotels ();
}

