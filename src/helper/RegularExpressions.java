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
    
    //This method returns true if the evaluated string is an email
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just letters (upper and lower case) and/or spaces
    public static boolean validateAlpha(String string){
        Pattern pattern = Pattern.compile("^[A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just letters (upper and lower case) and/or spaces and if the number of characters matches
    public static boolean validateAlpha(String string, int number){
        Pattern pattern = Pattern.compile("^[A-Za-z\\s]{" + number + "}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers, letters (upper and lower case) and/or spaces
    public static boolean validateAlphaNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z\\s]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers, letters (upper and lower case) and/or spaces and if the number of characters matches
    public static boolean validateAlphaNumeric(String string, int number){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z\\s]{" + number + "}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers and/or letters (upper and lower case)
    public static boolean validateStrictAlphaNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers and/or letters (upper and lower case) and if the number of characters matches
    public static boolean validateStrictAlphaNumeric(String string, int number){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z]{" + number + "}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers, letters (upper and lower case) and/or dashes
    public static boolean validateDashAlphaNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z-]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers, letters (upper and lower case) and/or dashes and if the number of characters matches
    public static boolean validateDashAlphaNumeric(String string, int number){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z-]{" + number + "}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers, letters (upper and lower case), spaces, ".", "," and/or "-"
    public static boolean validateAlphaNumericPointComma(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z\\s.,-]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers
    public static boolean validateNumeric(String string){
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers and if the number of characters matches
    public static boolean validateNumeric(String string, int number){
        Pattern pattern = Pattern.compile("^[0-9]{" + number + "}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string contains just numbers
    public static boolean validateNumericDouble(String string){
        Pattern pattern = Pattern.compile("^?\\d+(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evualuated string just contains spaces
    public static boolean validateJustSpaces(String string){
        Pattern pattern = Pattern.compile("^\\s+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evualuated string is an address
    //Alows values for colombian and american type addresses
    //Values suported are like:
    //"123 EverGreen Avenue, Springfield"
    //"12 Main St, Chicago, Il"
    //"12 Main St, Chi"
    //"carrera 14 no. 123"
    //"Calle 1 # 12-23"
    //"cr 13 no. 20-32, Armenia, Colombia"
    //"cr 13 no. 1-32, Armenia"
    //Notice that in american type addresses, City (or a 3 letter prefix) is needed to succede the validation
    //By the way, in colombian type addresses, address does not need to mention the city, but is better to include it, and country can be also included for clarity 
    //Bear in mind that nonsense values like "fg gg p1 , ." can succede the validation, because caracters and spaces are suitable for the Regular expression
    //However, as that kind of values are nonsense for bussiness logic, presumably admins will not enter them. Just if one of that kynd of value gets registered
    //it can alwas be updated and anyway will not affect database  
    public static boolean validateAddress(String string){
        Pattern pattern = Pattern.compile("^[0-9A-Za-z]{1,7}\\s{1}[0-9A-Za-z#-/.,]{1,}\\s{1}[0-9A-Za-z#-/,]{1,}\\s{1}[0-9A-Za-z\\s#-/,]{3,}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated int is 1 <= number <= 5 
    public static boolean validateHotelRoomClassification(int number){
        Pattern pattern = Pattern.compile("^[1-5]$");
        Matcher matcher = pattern.matcher(String.valueOf(number));
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string is equal to "single room", "double room", "triple room", "quadruple room" or "family room"
    public static boolean validateTypeRoom(String string){
        Pattern pattern = Pattern.compile("^(single room|double room|triple room|quadruple room|family room)$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
    
    //This method returns true if the evaluated string is equal to "single room", "double room", "triple room", "quadruple room" or "family room"
    public static boolean validateHotel(String string, String RegularExpression){
        Pattern pattern = Pattern.compile(RegularExpression);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
