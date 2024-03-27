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
public interface ImageDAOInterface {
    
    public void insert(String name, String url, int idHotel);
    
    public void update(String name, String url, int idHotel);
    
    public Map<String,Object> select();
    
    public void delete(int id);
}
