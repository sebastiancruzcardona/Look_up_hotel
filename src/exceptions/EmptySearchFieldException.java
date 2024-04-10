/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class EmptySearchFieldException extends RuntimeException{
    
    public EmptySearchFieldException(){
        super("You must write something to search");
    }
    
}
