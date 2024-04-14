/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class ThisHotelDoesNotExistException extends RuntimeException{
    
    public ThisHotelDoesNotExistException(){
        super("This hotel does not exist in database");
    }
    
}
