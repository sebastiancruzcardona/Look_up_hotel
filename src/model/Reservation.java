/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class Reservation {

    private int id;
    private User user;
    private Hotel hotel;
    private Room room;
    private Date entryDate;
    private Date departureDate;
    private String reservationStatus;
    private double totalPrice;

    public Reservation() {
    }
 
    
    
//Constructor to create the object
    public Reservation(User user, Hotel hotel, Room room, Date entryDate, Date departureDate, String reservationStatus, double totalPrice) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.reservationStatus = reservationStatus;
        this.totalPrice = totalPrice;
    }

    //Constructor that brings out the object from database
    public Reservation(int id, User user, Hotel hotel, Room room, Date entryDate, Date departureDate, String reservationStatus, double totalPrice) {
        this.id = id;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.reservationStatus = reservationStatus;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
