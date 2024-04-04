/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author lugo
 */
public class HotelNameAlreadyInDataBase extends RuntimeException {

    public HotelNameAlreadyInDataBase() {
    
        super("The name entered already exist in database. You must enter a different name");
    }
    
    
    
}
