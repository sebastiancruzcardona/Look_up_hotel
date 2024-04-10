/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import exceptions.EmptyFieldsException;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Room;
import services.RoomService;

/**
 *
 * @author lugo
 */
public class AdminUpdateRoom extends javax.swing.JPanel {

    Room room;
    RoomService roomService;

    public AdminUpdateRoom(Room room) {
        roomService = new RoomService();
        this.room = room;
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
        txt_room_number = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_type_room = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        availabilit_check = new java.awt.Checkbox();
        btn_edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_details = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(1140, 1024));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(2690, 1000));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel11.setBackground(new java.awt.Color(54, 37, 89));
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Manage room");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
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
        jLabel10.setText("Update room");

        txt_room_number.setBackground(new java.awt.Color(255, 255, 255));
        txt_room_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_room_number.setName(""); // NOI18N
        txt_room_number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_room_numberKeyTyped(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Room number");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Type room");

        txt_type_room.setBackground(new java.awt.Color(255, 255, 255));
        txt_type_room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_type_room.setName(""); // NOI18N
        txt_type_room.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_type_roomKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Price per night");

        txt_price.setBackground(new java.awt.Color(255, 255, 255));
        txt_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_price.setName(""); // NOI18N
        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_priceKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Amentities_details");

        availabilit_check.setForeground(new java.awt.Color(51, 51, 51));
        availabilit_check.setLabel("Availability");
        availabilit_check.setState(true);

        btn_edit.setBackground(new java.awt.Color(54, 37, 89));
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit-alt-regular-24.png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        txt_details.setBackground(new java.awt.Color(255, 255, 255));
        txt_details.setColumns(20);
        txt_details.setRows(5);
        txt_details.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_detailsKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_details);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_type_room)
                            .addComponent(txt_price)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_room_number)
                            .addComponent(jLabel4)
                            .addComponent(availabilit_check, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(311, 311, 311))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_room_number, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_type_room, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(availabilit_check, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
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
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        try {
            String roomNumber = txt_room_number.getText();
            String typeRoom = txt_type_room.getText();
            double priceNight = Double.parseDouble(txt_price.getText());
            boolean availability = availabilit_check.getState();
            String amenitiesDetails = txt_details.getText();
            roomService.validateFilledFields(roomNumber, typeRoom, priceNight, availability, amenitiesDetails, typeRoom);
            roomService.update(roomNumber, typeRoom, priceNight, availability, amenitiesDetails, room.getId());
            clear();
            
            ShowJPanel(new AdminGestionRoom());
            
        } catch (EmptyFieldsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_room_numberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_room_numberKeyTyped
        int key = evt.getKeyChar();
        //Validate if pressed key is a number, upper case or lower case
        boolean caracter = key >= 48 && key <= 57 || key >= 65 && key <= 90 || key >= 97 && key <= 122;
        //If is another thing do not put the character in the text field
        if(!caracter){
            evt.consume();
        }
    }//GEN-LAST:event_txt_room_numberKeyTyped

    private void txt_type_roomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_type_roomKeyTyped
        int key = evt.getKeyChar();
        //Validate if pressed key is a number, upper case or lower case
        boolean caracter = key >= 65 && key <= 90 || key >= 97 && key <= 122;
        //If is another thing do not put the character in the text field
        if(!caracter){
            evt.consume();
        }
    }//GEN-LAST:event_txt_type_roomKeyTyped

    private void txt_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyTyped
        int key = evt.getKeyChar();
        //Numbers in ASCII
        //Validate if pressed key is a number
        boolean numero = key >= 48 && key <= 57;
        //If is another thing do not put the character in the text field
        if(!numero){
            evt.consume();
        }
    }//GEN-LAST:event_txt_priceKeyTyped

    private void txt_detailsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_detailsKeyTyped
       int key = evt.getKeyChar();
        //Validate if pressed key is a number, upper case, lower case or space
        boolean caracter = key >= 65 && key <= 90 || key >= 97 && key <= 122 ||key == 32;
        //If is another thing do not put the character in the text field
        if(!caracter){
            evt.consume();
        }     
    }//GEN-LAST:event_txt_detailsKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox availabilit_check;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel search;
    private javax.swing.JTextArea txt_details;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_room_number;
    private javax.swing.JTextField txt_type_room;
    // End of variables declaration//GEN-END:variables

    //This method change txtField for date from room about edit
    public void initPanel() {
        txt_room_number.setText(room.getNumber());
        txt_type_room.setText(room.getType());
        txt_price.setText(String.valueOf(room.getPricePerNight()));
        availabilit_check.setState(room.isAvailability());
        txt_details.setText(room.getAmenities());
    }

    //This method clean txtfields then do update
    public void clear() {
        txt_room_number.setText("");
        txt_type_room.setText("");
        txt_price.setText("");

        txt_details.setText("");
    }
    
    private void ShowJPanel(JPanel panel){
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);
        
        bg.removeAll();
        bg.add(panel, BorderLayout.CENTER);
        bg.revalidate();
        bg.repaint();
    }
}
