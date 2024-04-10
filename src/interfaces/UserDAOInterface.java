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
    
    void insert(String name, String email, String password, String contact);
    
    void update(String name, String email, String password, String contact);
    
    Map<String, Object> select();
    
    void delete(int id);    
    
    boolean findEmail(String email);
    
    User findUser(String email, String password);
    
    void insertManage(String name, String email, String password, String contact,int rol);
}
