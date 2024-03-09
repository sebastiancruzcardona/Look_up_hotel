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
public class MySQLConnection {
    //MySQL library
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //Database name
    private static final String DATABASE = "my-first-mysql";

    //Host
    private static final String HOSTNAME = "localhost";

    //Port
    private static final String PORT = "3306";

    //Path to our database (desable SSL use with "?useSSL=false")
    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=True";

    //User name
    private static final String USERNAME = "root";

    //User password
    private static final String PASSWORD = "clavecita1357";

    /**
     * This method stablishes the connection to database
     * @return Connection to database.
     */
    public static Connection conectarMySQL() {
        Connection conn = null;

        try {
            //Load MySQL driver
            Class.forName(DRIVER);
            //Stablish connection to database
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            //If can't connect to databas print out the exception trace
            e.printStackTrace();
        }

        // Devolvemos la conexión
        return conn;
    }
}
