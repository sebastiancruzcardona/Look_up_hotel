/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class NotAlphaNumericException extends RuntimeException{
    
    public NotAlphaNumericException(){
        super("You must enter alphanumeric characters and spaces");
    }
    
}
