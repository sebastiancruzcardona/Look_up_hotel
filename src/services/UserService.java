/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import daos.UserDAO;
import exceptions.EmailNotExistException;
import exceptions.EmptyFieldsException;
import exceptions.EmptySearchFieldException;
import exceptions.IncorrectPasswordException;
import exceptions.JustSpacesException;
import exceptions.NoChangeWasMadeException;
import exceptions.NotAlphaException;
import exceptions.NotAlphaNumericException;
import exceptions.NotAnEmailException;
import helper.RegularExpressions;
import java.util.Map;
import javax.swing.JOptionPane;
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
        validateAlpha(name);
        validateAlphaNumericPointComma(contact);
        validateNotJustSpaces(name);
        validateNotJustSpaces(password);
        validateNotJustSpaces(contact);
        validateInsertion(userDAO.insert(name, email, password, contact));
    }
    
    //This method calls update method from UserDAO
    public void update(String name, String email, String password, String contact){
        validateEmail(email);
        validateAlpha(name);
        validateAlphaNumericPointComma(contact);
        validateNotJustSpaces(name);
        validateNotJustSpaces(password);
        validateNotJustSpaces(contact);
        validateUpdate( userDAO.update(name, email, password, contact));
    }
    
    //This method calls update method from UserDAO from view manage , he can edit rol
    public void update(String name, String email, String password, String contact, int rol, User user){
         if(!user.getUserName().equals(name) || !user.getEmail().equals(email) || !user.getPassword().equals(password) || !user.getDetails().equals(contact)|| user.getRol()!=rol){   
            validateEmail(email);
            validateAlphaNumeric(name);
            validateAlphaNumeric(contact);
            validateNotJustSpaces(name);
            validateNotJustSpaces(password);
            validateNotJustSpaces(contact);
             validateUpdate(userDAO.update(name, email, password, contact,  rol));
         }else{
                 throw new NoChangeWasMadeException();
         }    
            
    }
   
    //This method returns a HashMap calling userDAO select method
    public Map<String, Object> select(String name){
        return userDAO.select(createSelectQuery(name));
    }
    
    //This method calls delete method from UserDAO
    public void delete(int id){
        validateDelete(userDAO.delete(id));
    }
    
   //This method calls insert method from UserDAO
    public void insertManage(String name, String email, String password, String contact, int rol){
        validateEmail(email);
        validateAlphaNumeric(name);
        validateAlphaNumeric(contact);
        validateNotJustSpaces(name);
        validateNotJustSpaces(password);
        validateNotJustSpaces(contact);
        validateInsertion(userDAO.insertManage(name, email, password, contact, rol));
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
    
    //This method calls validateAlpha from helper.RegularExpressions
    public void validateAlpha(String string){
        if(!RegularExpressions.validateAlpha(string)){
            throw new NotAlphaException();
        }
    }
    
    //This method calls validateAlphaNumeric from helper.RegularExpressions
    public void validateAlphaNumeric(String string){
        if(!RegularExpressions.validateAlphaNumeric(string)){
            throw new NotAlphaNumericException();
        }
    }
    
    //This method calls validateAlphaNumericPointComma from helper.RegularExpressions
    public void validateAlphaNumericPointComma(String string){
        if(!RegularExpressions.validateAlphaNumericPointComma(string)){
            throw new NotAlphaNumericException();
        }
    }
    
    //This method calls validateNotJustSpaces from helper.RegularExpressions
    public void validateNotJustSpaces(String string){
        if(RegularExpressions.validateJustSpaces(string)){
            throw new JustSpacesException();
        }
    }

    //This method calls find email method from userDAO
    public boolean findEmail(String email){
        validateEmail(email);
        boolean result = userDAO.findEmail(email);
       
            return  result;
       
         
        
    }
    
    
    
    //this method validate if answer is true or false from getion data base
    public void validateInsertion ( boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"User successfully created");
        }else{
            JOptionPane.showMessageDialog(null,"No insertion was made");
        }
    }
    
    //this method validate if answer is true or false from getion data base
    public void validateUpdate ( boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"User successfully Update");
        }else{
            JOptionPane.showMessageDialog(null,"No update was made");
        }
    }
    
    //this method validate if answer is true or false from getion data base
    public void validateDelete ( boolean answer){
        if(answer){
            JOptionPane.showMessageDialog(null,"User successfully delete user");
        }else{
            JOptionPane.showMessageDialog(null,"No delete was made");
        }
    }
    
    //This method calls  findUser method from userDAO
    public User findUser (String email, String password){
       validateEmail(email);
       if(userDAO.findEmail(email)){
           User user = userDAO.findUser(email, password);
           
           if(user!=null){
               return  user;
           }else{
               throw  new IncorrectPasswordException();
           }
       }else{
           throw  new EmailNotExistException();//Exception if email dont exist in Data base
       }
      
    }
    
    //This method calls  findUser method from userDAO
    public User findUser (int id){
       User user = userDAO.findUser(id);
       return user;
    }
    
     /**
     * This method creates the appropriate query for the select method
     * 
     * @param String name
     * @return The standar select query if name == null. The select query with a LIKE condition if !name == null.
     * If name.equals(""), thows an EmptySearchFieldException
     */
    public String createSelectQuery(String email){
        String query =  "SELECT u.id, u.full_name, u.email, u.password, u.contact, r.name"
                + " FROM users u "
                + "JOIN rols r on u.id_rol = r.id";
        if(email == null){
            return query;
        }else {
                validateEmail(email);
        }
        return query += " AND u.email ="  +"'"+ email + "'"; 
                
                //query += " WHERE name LIKE '%" + name + "%'";        
    }
   
}
