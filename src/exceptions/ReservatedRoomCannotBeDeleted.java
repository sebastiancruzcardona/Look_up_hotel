/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class ReservatedRoomCannotBeDeleted extends RuntimeException{
    
    public ReservatedRoomCannotBeDeleted(){
        super("Now you can not delete this room, because there are rooms reservated");
    }
    
}
