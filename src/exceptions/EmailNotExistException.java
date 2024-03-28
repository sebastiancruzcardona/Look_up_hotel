/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author lugo
 */
public class EmailNotExistException extends RuntimeException {

    public EmailNotExistException() {
    
        super("The email entered does not exist in the database");
    }
    
    
    
}
