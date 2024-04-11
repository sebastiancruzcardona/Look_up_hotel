/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ASUS - JOSE
 */
public class RegularExpressions {

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean validateAlpha(String string){
        Pattern pattern = Pattern.compile("^[A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    public static boolean validateAlphaNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    public static boolean validateNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
