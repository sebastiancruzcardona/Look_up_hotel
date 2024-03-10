/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class Image {
    
    private int id;
    private String name;
    private String uri;

    //Constructor to create the object
    public Image(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    //Constructor that brings out the object from database
    public Image(int id, String name, String uri) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }   
       
}
