/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class NullConnectionException extends RuntimeException{

    public NullConnectionException(){
        super("Couldn't connect to database");
    }
    
}
