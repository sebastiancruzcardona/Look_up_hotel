/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.Map;
import model.User;

/**
 *
 * @author lugo
 */
public interface UserDAOInterface {
    
    boolean insert(String name, String email, String password, String contact);
    
    boolean update(String name, String email, String password, String contact);
    
    boolean update(String name, String email, String password, String contact, int rol);
    
    Map<String, Object> select(String query );
    
    boolean delete(int id);    
    
    boolean findEmail(String email);
    
    User findUser(String email, String password);
    
    User findUser(int id);
    
    boolean insertManage(String name, String email, String password, String contact,int rol);
}
