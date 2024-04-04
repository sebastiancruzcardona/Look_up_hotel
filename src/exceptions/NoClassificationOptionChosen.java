/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author ASUS - JOSE
 */
public class NoClassificationOptionChosen extends RuntimeException{
    
    public NoClassificationOptionChosen(){
        super("You must choose an option for hotel's classification");
    }
    
}
