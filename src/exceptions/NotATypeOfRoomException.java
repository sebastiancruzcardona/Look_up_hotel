/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class NotATypeOfRoomException extends RuntimeException{
    
    public NotATypeOfRoomException(){
        super("A correct type of room must be entered");
    }
    
}
