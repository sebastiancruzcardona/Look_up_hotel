/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class Room {
    
    private int id;
    private String number;
    private String type;
    private double pricePerNight;
    private String amenities;

    //Constructor to create the object
    public Room(String number, String type, double pricePerNight, String amenities) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
    }

    //Constructor that brings out the object from database
    public Room(int id, String number, String type, double pricePerNight, String amenities) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
    
    
    
    
    
}
