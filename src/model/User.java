/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private String details;
    private int rol;

//Constructor to create the object
    public User(String userName, String email, String password, String details) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.details = details;
    }

//Constructor that brings out the object from database
    public User(int id, String userName, String email, String password, String details, int rol) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.details = details;
        this.rol = rol;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRol() {
        return rol;
    }

}
