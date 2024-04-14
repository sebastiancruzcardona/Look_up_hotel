/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class NoSuchRoomExcpetion extends RuntimeException{
    
    public NoSuchRoomExcpetion(){
        super("There is not a room whith that id");
    }
    
}
