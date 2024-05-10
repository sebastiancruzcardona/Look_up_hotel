/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import daos.ReservationDAO;
import exceptions.JustSpacesException;
import helper.RegularExpressions;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Reservation;

/**
 *
 * @author lugo
 */
public class ReservationService {

    ReservationDAO reservationDAO;

    public ReservationService() {
        reservationDAO = new ReservationDAO();
    }

    //This method calls insert method from ReservationDAO  
    public Map<String, Object> select(java.sql.Date entry_date, java.sql.Date departure_date, int id_hotel, int numberPerson) {
        return reservationDAO.selectReservatedRooms(entry_date, departure_date, id_hotel, numberPerson);
    }

    //This method callas clientSelect from ReservationDAO
    public Map<String, Object> clientSelect(int id) {
        return reservationDAO.clientSelect(id);
    }

    //This method calls insert method from ReservactionDAO
    public void insert(int idUser, int idHotel, int idRoom, Date entryDate, Date departureDate, int status, double totalPrice) {
        long entry_long = entryDate.getTime();
        long departure_long = departureDate.getTime();

        java.sql.Date entry_date = new java.sql.Date(entry_long);
        java.sql.Date departure_date = new java.sql.Date(departure_long);

        validateInsertion(reservationDAO.insert(idUser, idHotel, idRoom, entry_date, departure_date, status, totalPrice));
    }
    
    //this method generate report in pdf between dates
   public void createReportBetweenDates(Date entryDate, Date departureDate){
       
        long entry_long = entryDate.getTime();
        long departure_long = departureDate.getTime();

        java.sql.Date entry_date = new java.sql.Date(entry_long);
        java.sql.Date departure_date = new java.sql.Date(departure_long);
        
        ArrayList<Reservation> reservations = reservationDAO.findReservationsBetweenDates(entry_date, departure_date);
        
          if (reservations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "there are no reservations between those dates");
        } else {
            try {
                String ruta = System.getProperty("user.home");
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Report_Reservations.pdf" + entry_date + " and " + departure_date));

                document.open();

                // Agregar título al documento
                Paragraph tittle = new Paragraph("Reservations of " +  entry_date + " and " + departure_date);
                document.add(tittle);
                PdfPTable table = new PdfPTable(12);
                table.addCell("id");
                table.addCell("full_name");
                table.addCell("email");
                table.addCell("contact");
                table.addCell("hotel");
                table.addCell("address");
                table.addCell("conforts");
                table.addCell("room_number");
                table.addCell("entry_date");
                table.addCell("departure_date");
                table.addCell("total_price");
                table.addCell("status");
                for (Reservation reservation : reservations) {

                    table.addCell(String.valueOf(reservation.getId()));
                    table.addCell(reservation.getUser().getUserName());
                    table.addCell(reservation.getUser().getEmail());
                    table.addCell(reservation.getUser().getDetails());
                    table.addCell(reservation.getHotel().getName());
                    table.addCell(reservation.getHotel().getAddress());
                    table.addCell(reservation.getHotel().getComforts());
                    table.addCell(reservation.getRoom().getNumber());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    table.addCell(format.format(reservation.getEntryDate()));
                    table.addCell(format.format(reservation.getDepartureDate()));
                    table.addCell(String.valueOf(reservation.getTotalPrice()));
                    table.addCell(reservation.getReservationStatus());

                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null, "the report was created.");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            }
        }
        
       
   }
    
    //This method calls delete from reservationDAO
    public void deleteReservation(int id) {
        validateDelete(reservationDAO.delete(id));
    }

    //this method validate if answer is true or false from getion data base
    public void validateInsertion(boolean answer) {
        if (answer) {
            JOptionPane.showMessageDialog(null, "Reservation successfully created");
        } else {
            JOptionPane.showMessageDialog(null, "No insertion was made");
        }
    }

    public void validateDelete(boolean answer) {
        if (answer) {
            JOptionPane.showMessageDialog(null, "the reservation was canceled");
        } else {
            JOptionPane.showMessageDialog(null, "the reservation was not canceled");
        }
    }

    // this method calculate the total price to reservation
    public double calculateTotalPrice(double pricePorNight, int totalDays) {

        return pricePorNight * totalDays;

    }

    //this method create report in pdf for hotel name
    public void generateReportPdfReservation(String hotelName) {
        validateNotJustSpaces(hotelName);
        ArrayList<Reservation> reservations = reservationDAO.findReservationsForHotelName(hotelName);

        if (reservations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "the hotel was not found try again");
        } else {
            try {
                String ruta = System.getProperty("user.home");
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Report_Reservations.pdf" + hotelName));

                document.open();

                // Agregar título al documento
                Paragraph tittle = new Paragraph("Reservations of " + reservations.getFirst().getHotel().getName());
                document.add(tittle);
                PdfPTable table = new PdfPTable(12);
                table.addCell("id");
                table.addCell("full_name");
                table.addCell("email");
                table.addCell("contact");
                table.addCell("hotel");
                table.addCell("address");
                table.addCell("conforts");
                table.addCell("room_number");
                table.addCell("entry_date");
                table.addCell("departure_date");
                table.addCell("total_price");
                table.addCell("status");
                for (Reservation reservation : reservations) {

                    table.addCell(String.valueOf(reservation.getId()));
                    table.addCell(reservation.getUser().getUserName());
                    table.addCell(reservation.getUser().getEmail());
                    table.addCell(reservation.getUser().getDetails());
                    table.addCell(reservation.getHotel().getName());
                    table.addCell(reservation.getHotel().getAddress());
                    table.addCell(reservation.getHotel().getComforts());
                    table.addCell(reservation.getRoom().getNumber());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    table.addCell(format.format(reservation.getEntryDate()));
                    table.addCell(format.format(reservation.getDepartureDate()));
                    table.addCell(String.valueOf(reservation.getTotalPrice()));
                    table.addCell(reservation.getReservationStatus());

                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null, "the report was created.");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            }
        }
    }
        
         

    public void generateReportPdfAllReservation() {
        
        ArrayList<Reservation> reservations = reservationDAO.selectAllReservations();

        if (reservations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "the hotel was not found try again");
        } else {
            try {
                String ruta = System.getProperty("user.home");
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Report_All_Reservations.pdf"));

                document.open();

                // Agregar título al documento
                Paragraph tittle = new Paragraph("All Reservations ");
                document.add(tittle);
                PdfPTable table = new PdfPTable(12);
                table.addCell("id");
                table.addCell("full_name");
                table.addCell("email");
                table.addCell("contact");
                table.addCell("hotel");
                table.addCell("address");
                table.addCell("conforts");
                table.addCell("room_number");
                table.addCell("entry_date");
                table.addCell("departure_date");
                table.addCell("total_price");
                table.addCell("status");
                for (Reservation reservation : reservations) {

                    table.addCell(String.valueOf(reservation.getId()));
                    table.addCell(reservation.getUser().getUserName());
                    table.addCell(reservation.getUser().getEmail());
                    table.addCell(reservation.getUser().getDetails());
                    table.addCell(reservation.getHotel().getName());
                    table.addCell(reservation.getHotel().getAddress());
                    table.addCell(reservation.getHotel().getComforts());
                    table.addCell(reservation.getRoom().getNumber());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    table.addCell(format.format(reservation.getEntryDate()));
                    table.addCell(format.format(reservation.getDepartureDate()));
                    table.addCell(String.valueOf(reservation.getTotalPrice()));
                    table.addCell(reservation.getReservationStatus());

                }
                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null, "the report was created.");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            }
        }

    }

    //This method calls validateNotJustSpaces from helper.RegularExpressions
    public void validateNotJustSpaces(String string) {
        if (RegularExpressions.validateJustSpaces(string)) {
            throw new JustSpacesException();
        }
    }
}
