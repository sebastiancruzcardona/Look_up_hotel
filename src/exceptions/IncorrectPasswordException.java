/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author lugo
 */
public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException(){
        super("The password entered is incorrect, please try again");
    }
}
