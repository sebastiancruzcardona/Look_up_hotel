/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Cruz
 */
public class Hotel {
    
    private int id;
    private String name;
    private String address;
    private int classification;
    private String comforts;
    private ArrayList<String> images;

    
    //Construtor to emtpy
    public Hotel() {
    }

    


    //Constructor to create the object
    public Hotel(String name, String address, int classification, String comforts) {
        this.name = name;
        this.address = address;
        this.classification = classification;
        this.comforts = comforts;
        images = new ArrayList<>();
    }

    //Constructor that brings out the object from database
    public Hotel(int id, String name, String address, int classification, String comforts, ArrayList<String> images) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classification = classification;
        this.comforts = comforts;
        this.images = images;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getComforts() {
        return comforts;
    }

    public void setComforts(String comforts) {
        this.comforts = comforts;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
