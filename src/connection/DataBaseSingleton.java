/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @authors Fabián Lugo - Sebastián Cruz
 */
public class DataBaseSingleton {
    
    private static DataBaseSingleton instance;
    private Connection connection;
    
    //MySQL library
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //Database name
    //private static final String DATABASE = "my-first-mysql";

    //Host
    //private static final String HOSTNAME = "localhost";

    //Port
    //private static final String PORT = "3306";

    //Path to our database (disable SSL use with "?useSSL=false")
    private static final String URL = "jdbc:mysql://bkzs0rxzta3lj7qswadx-mysql.services.clever-cloud.com:3306/bkzs0rxzta3lj7qswadx?useSSL=false&allowPublicKeyRetrieval=True";

    //User name
    private static final String USERNAME = "ucchmicdw0vrgpmh";

    //User password
    private static final String PASSWORD = "FSlWZ6sTop6XdlbnjXqB";

    
    private DataBaseSingleton(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static DataBaseSingleton getInstance(){
        if(instance == null){
            instance = new DataBaseSingleton();
        }
        return instance;
    }
    
    
    public Connection getConnection(){
        return connection;
    }
    
    
    public void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
