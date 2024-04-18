/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class NotSelectedDatesException extends RuntimeException{
    
    public NotSelectedDatesException(){
        super("You must choose an entry date and a departure date");
    }
    
}
