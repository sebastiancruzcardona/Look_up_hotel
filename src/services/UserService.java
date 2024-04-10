/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.UserDAO;
import exceptions.EmptyFieldsException;
import exceptions.NotAnEmailException;
import helper.RegularExpressions;
import java.util.Map;
import model.User;

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
        validateEmail(email);
        userDAO.insert(name, email, password, contact);
    }
    
    //This method calls update method from UserDAO
    public void update(String name, String email, String password, String contact){
        validateEmail(email);
        userDAO.update(name, email, password, contact);
    }
    
    //This method calls update method from UserDAO
    public void update(String name, String email, String password, String contact, int rol){
        validateEmail(email);
        userDAO.update(name, email, password, contact,  rol);
    }
   
    //This method returns a HashMap calling userDAO select method
    public Map<String, Object> select(){
        return userDAO.select();
    }
    
    //This method calls delete method from UserDAO
    public void delete(int id){
        userDAO.delete(id);
    }
    
   //This method calls insert method from UserDAO
    public void insertManage(String name, String email, String password, String contact, int rol){
        validateEmail(email);
        userDAO.insertManage(name, email, password, contact, rol);
    }
    
    
////This method validates if the provided text is an email
//    public void validateEmail(String email){
//        //First look for an "@", if there is not such character, throw a NotAnEmailException
//        if(!email.contains("@")){
//            throw new NotAnEmailException();
//        }
//        
//        //If there is an "@" find its index in text
//        int index = email.indexOf("@");
//        
//        //If befor the "@" there is nothing, throw a NotAnEmailException
//        //.substring(start, end -1)
//        if(email.substring(0, index).equals("")){
//            throw new NotAnEmailException();
//        }
//        
//        //If after the "@" there is nothing or there is not a "." or there is another "@", throw a NotAnEmailException
//        if(email.substring(index + 1).equals("")  || !email.substring(index).contains(".") || email.substring(index + 1).contains("@")){
//            throw new NotAnEmailException();
//        }
//        
//        //If there is something, there is not another "@" and there is a ".", find the "." index
//        int index2 = email.substring(index).indexOf(".");
//        
//        //If there is nothing between "@" and ".", throw a NotAnEmailException
//        if(email.substring(index, index + index2 + 1).equals("@.")){
//            throw new NotAnEmailException();
//        }
//        
//        //If after the "." there is nothing or there is another ".", throw a NotAnEmailException
//        if(email.substring(index + index2 + 1).equals("") || email.substring(index + index2 + 1).contains(".")){
//            throw new NotAnEmailException();
//        }       
//    }
    
    public void validateEmail(String email){
        if(!RegularExpressions.validateEmail(email)){
            throw new NotAnEmailException();
        }
    }
    
    //This methd validates if all fields were filled out
    public void validateFilledFields(String username, String email, String password, String contact){
        if(username.equals("") || email.equals("") || password.equals("") || contact.equals("")){
            throw new EmptyFieldsException();
        }
    }
    //this method override
    public void validateFilledFields( String email, String password){
        if(email.equals("") || password.equals("")){
            throw new EmptyFieldsException();
        }
    }

    //This method calls find email method from userDAO
    public boolean findEmail(String email){
        validateEmail(email);
        boolean result = userDAO.findEmail(email);
        return result;
    }
    
    //This method calls  findUser method from userDAO
    public User findUser (String email, String password){
       validateEmail(email);
       User user = userDAO.findUser(email, password);
       return user;
    }
    
    //This method calls  findUser method from userDAO
    public User findUser (int id){
       User user = userDAO.findUser(id);
       return user;
    }
}
