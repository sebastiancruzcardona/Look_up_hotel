/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import exceptions.DepartureDateException;
import exceptions.EmptyFieldsException;
import exceptions.EntryDateException;
import exceptions.HotelNameAlreadyInDataBase;
import exceptions.NoChangeWasMadeException;
import exceptions.NotAlphaNumericException;
import exceptions.NotAnAddressException;
import exceptions.NotSelectedDatesException;
import exceptions.NotValidClassificationExcpetion;
import java.awt.BorderLayout;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Hotel;
import model.Reservation;
import model.Room;
import model.User;
import services.HotelService;

/**
 *
 * @author Fabián Lugo - Sebastián Cruz
 */
public class UserPreReservation extends javax.swing.JPanel {
    Reservation preReservation;
    User user;
    Hotel hotel;
    Room room;
    java.sql.Date today_date;
    HotelService hotelService; //Here will be ReservationService

    public UserPreReservation(User user, Hotel hotel) {
        hotelService = new HotelService();
        this.user = user;
        this.hotel = hotel;
        //Get today's DATE
        Date today = new Date();
        long today_long = today.getTime();
        today_date = new java.sql.Date(today_long);
        initComponents();
        initPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_full_name = new javax.swing.JTextField();
        lbl_full_name = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_number_guests = new javax.swing.JLabel();
        lbl_entry_date = new javax.swing.JLabel();
        btn_find_room = new javax.swing.JButton();
        combobox_number_guests = new javax.swing.JComboBox<>();
        lbl_contact_number = new javax.swing.JLabel();
        txt_contact_number = new javax.swing.JTextField();
        lbl_hotel = new javax.swing.JLabel();
        txt_hotel = new javax.swing.JTextField();
        lbl_address = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        calendar_entry_date = new com.toedter.calendar.JDateChooser();
        lbl_entry_date1 = new javax.swing.JLabel();
        calendar_departure_date = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1140, 1024));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1140, 1024));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel11.setBackground(new java.awt.Color(54, 37, 89));
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pre-reservation");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addGap(784, 784, 784))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(33, 33, 33))
        );

        jLabel10.setBackground(new java.awt.Color(54, 37, 89));
        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Your information");

        txt_full_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_full_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_full_name.setFocusable(false);
        txt_full_name.setName(""); // NOI18N
        txt_full_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_full_nameKeyTyped(evt);
            }
        });

        lbl_full_name.setForeground(new java.awt.Color(153, 153, 153));
        lbl_full_name.setText("Full name");

        lbl_email.setForeground(new java.awt.Color(153, 153, 153));
        lbl_email.setText("email");

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_email.setFocusable(false);
        txt_email.setName(""); // NOI18N
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });

        lbl_number_guests.setForeground(new java.awt.Color(153, 153, 153));
        lbl_number_guests.setText("Number of guests");

        lbl_entry_date.setForeground(new java.awt.Color(153, 153, 153));
        lbl_entry_date.setText("Entry date");

        btn_find_room.setBackground(new java.awt.Color(54, 37, 89));
        btn_find_room.setForeground(new java.awt.Color(255, 255, 255));
        btn_find_room.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search-regular-24.png"))); // NOI18N
        btn_find_room.setText("Find a room");
        btn_find_room.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_find_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_find_roomActionPerformed(evt);
            }
        });

        combobox_number_guests.setBackground(new java.awt.Color(255, 255, 255));
        combobox_number_guests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combobox_number_guestsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combobox_number_guestsMousePressed(evt);
            }
        });
        combobox_number_guests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_number_guestsActionPerformed(evt);
            }
        });

        lbl_contact_number.setForeground(new java.awt.Color(153, 153, 153));
        lbl_contact_number.setText("Contact number");

        txt_contact_number.setBackground(new java.awt.Color(255, 255, 255));
        txt_contact_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_contact_number.setFocusable(false);
        txt_contact_number.setName(""); // NOI18N
        txt_contact_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contact_numberKeyTyped(evt);
            }
        });

        lbl_hotel.setForeground(new java.awt.Color(153, 153, 153));
        lbl_hotel.setText("Hotel");

        txt_hotel.setBackground(new java.awt.Color(255, 255, 255));
        txt_hotel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_hotel.setFocusable(false);
        txt_hotel.setName(""); // NOI18N
        txt_hotel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hotelKeyTyped(evt);
            }
        });

        lbl_address.setForeground(new java.awt.Color(153, 153, 153));
        lbl_address.setText("Address");

        txt_address.setBackground(new java.awt.Color(255, 255, 255));
        txt_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_address.setFocusable(false);
        txt_address.setName(""); // NOI18N
        txt_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_addressKeyTyped(evt);
            }
        });

        lbl_entry_date1.setForeground(new java.awt.Color(153, 153, 153));
        lbl_entry_date1.setText("Departure date");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_full_name, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txt_contact_number, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txt_hotel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btn_find_room, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addComponent(txt_address, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(combobox_number_guests, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_full_name)
                                    .addComponent(lbl_email)
                                    .addComponent(lbl_contact_number)
                                    .addComponent(lbl_hotel)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_entry_date)
                                            .addComponent(calendar_entry_date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(70, 70, 70)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calendar_departure_date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_entry_date1)))
                                    .addComponent(lbl_address)
                                    .addComponent(lbl_number_guests))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(512, 512, 512))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(lbl_full_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_contact_number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_contact_number, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_hotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hotel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_entry_date)
                            .addComponent(lbl_entry_date1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendar_entry_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calendar_departure_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(lbl_number_guests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combobox_number_guests, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btn_find_room, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1351, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1025, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_find_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_find_roomActionPerformed
        /*try{
            String name = txt_full_name.getText();
            String address = txt_email.getText();
            int classification = combobox_number_guests.getSelectedIndex() + 1;
            //String comforts = txt_comforts.getText();
            
            //hotelService.validateFilledFields(name, address, classification, comforts);
            hotelService.validateHotelNameAvailability(name, hotel);            
            
            //hotelService.update(name, address, classification, comforts, hotel.getId(), hotel);
            clear();
            ShowJPanel(new AdminManageHotel());
            
        }catch (EmptyFieldsException | HotelNameAlreadyInDataBase | NoChangeWasMadeException | NotAlphaNumericException | NotAnAddressException | NotValidClassificationExcpetion e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/

        //Capture entry and departure dates and formate them in sql format
        try {
            Date entry = calendar_entry_date.getDate();
            Date departure = calendar_departure_date.getDate();
            long entry_long = 0;
            long departure_long = 0;
            try {
                entry_long = entry.getTime();
                departure_long = departure.getTime();
            } catch (NullPointerException e) {
                throw new NotSelectedDatesException();
            }

            java.sql.Date entry_date = new java.sql.Date(entry_long);
            java.sql.Date departure_date = new java.sql.Date(departure_long);            
            int number_of_guests = combobox_number_guests.getSelectedIndex() + 1;

            if (entry_date.before(today_date) || entry_date.toString().equals(today_date.toString())) {
                throw new EntryDateException();
            } else if (departure_date.before(entry_date) || departure_date.toString().equals(entry_date.toString())) {
                throw new DepartureDateException();
            }
            
            preReservation = new Reservation(user, hotel, room, entry, departure,"pending" ,1);
            ShowJPanel(new UserReserveRoom(preReservation,number_of_guests));

        } catch (EntryDateException | DepartureDateException | NotSelectedDatesException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btn_find_roomActionPerformed

    private void combobox_number_guestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combobox_number_guestsMouseClicked

    }//GEN-LAST:event_combobox_number_guestsMouseClicked

    private void combobox_number_guestsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combobox_number_guestsMousePressed
        fillComboBox();
    }//GEN-LAST:event_combobox_number_guestsMousePressed

    private void combobox_number_guestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_number_guestsActionPerformed

    }//GEN-LAST:event_combobox_number_guestsActionPerformed

    private void txt_full_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_full_nameKeyTyped
        int key = evt.getKeyChar();
        //Validate if pressed key is a number, upper case, lower case or space
        boolean caracter = key >= 48 && key <= 57 || key >= 65 && key <= 90 || key >= 97 && key <= 122 || key == 32;
        //If is another thing do not put the character in the text field
        if (!caracter) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_full_nameKeyTyped

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        int key = evt.getKeyChar();
        //Validate if pressed key is a number, upper case, lower case, space, "#", ",", "-", "." or "/"
        boolean caracter = key >= 48 && key <= 57 || key >= 65 && key <= 90 || key >= 97 && key <= 122 || key == 32 || key == 35 || key >= 44 && key <= 47;
        //If is another thing do not put the character in the text field
        if (!caracter) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_emailKeyTyped

    private void txt_contact_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contact_numberKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact_numberKeyTyped

    private void txt_hotelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hotelKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hotelKeyTyped

    private void txt_addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addressKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_find_room;
    private com.toedter.calendar.JDateChooser calendar_departure_date;
    private com.toedter.calendar.JDateChooser calendar_entry_date;
    private javax.swing.JComboBox<String> combobox_number_guests;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_contact_number;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_entry_date;
    private javax.swing.JLabel lbl_entry_date1;
    private javax.swing.JLabel lbl_full_name;
    private javax.swing.JLabel lbl_hotel;
    private javax.swing.JLabel lbl_number_guests;
    private javax.swing.JPanel search;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_contact_number;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_full_name;
    private javax.swing.JTextField txt_hotel;
    // End of variables declaration//GEN-END:variables

//This methods fill dates in hotel_comboBox
    public void fillComboBox() {
        String[] classificationNumbers = new String[]{"1", "2", "3", "4", "5"};
        combobox_number_guests.removeAllItems();
        for (String number : classificationNumbers) {
            combobox_number_guests.addItem(number);
        }
    }

//This method fills the test fields with the current hotel information
    public void initPanel() {
        txt_full_name.setText(user.getUserName());
        txt_email.setText(user.getEmail());
        txt_contact_number.setText(user.getDetails());
        txt_hotel.setText(hotel.getName());
        txt_address.setText(hotel.getAddress());
        fillComboBox();
        combobox_number_guests.setSelectedIndex(0);
        //txt_comforts.setText(hotel.getComforts());
    }

    //This method cleans txtfields after update
    public void clear() {
        txt_full_name.setText("");
        txt_email.setText("");
        //txt_comforts.setText("");
    }

    private void ShowJPanel(JPanel panel) {
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);

        bg.removeAll();
        bg.add(panel, BorderLayout.CENTER);
        bg.revalidate();
        bg.repaint();
    }
}
