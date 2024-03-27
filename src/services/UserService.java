/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.UserDAO;
import java.util.Map;

/**
 *
 * @author ASUS - JOSE
 */
public class UserService {
    
    UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }
    
    //This method calls insert method from UserDAO
    public void insert(String name, String email, String password, String contact){
        userDAO.insert(name, email, password, contact);
    }
    
    //This method calls update method from UserDAO
    public void update(String name, String email, String password, String contact){
        userDAO.update(name, email, password, contact);
    }
    
    //This method returns a HashMap calling userDAO select method
    public Map<String, Object> select(){
        return userDAO.select();
    }
    
    //This method calls delete method from UserDAO
    public void delete(int id){
        userDAO.delete(id);
    }
    
    
    
    
}
