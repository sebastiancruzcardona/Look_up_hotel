/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import exceptions.NoSuchRoomExcpetion;
import helper.TextPrompt;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Hotel;
import model.Reservation;
import model.Room;
import model.User;
import services.ReservationService;
import services.RoomService;

/**
 *
 * @author lugo
 */
public class UserReserveRoom extends javax.swing.JPanel {
     int idTable;
    int typeRoom; 
   User user;
   Hotel hotel;
   Reservation preReservation;
   ReservationService reservationService;
    RoomService roomService;
    public UserReserveRoom(Reservation preReservation,int typeRoom) {
        this.preReservation = preReservation;
       this.typeRoom = typeRoom;
        roomService=new RoomService();
        reservationService = new ReservationService();
        initComponents();
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rooms_table = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_reserve = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1140, 1024));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel10.setBackground(new java.awt.Color(54, 37, 89));
        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reserve room");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(44, 44, 44))
        );

        rooms_table.setBackground(new java.awt.Color(255, 255, 255));
        rooms_table.setForeground(new java.awt.Color(0, 0, 0));
        rooms_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        rooms_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        rooms_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rooms_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(rooms_table);

        btn_back.setBackground(new java.awt.Color(54, 37, 89));
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/log-out-solid-24.png"))); // NOI18N
        btn_back.setText("back");
        btn_back.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_back.setMaximumSize(new java.awt.Dimension(100, 30));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_reserve.setBackground(new java.awt.Color(54, 37, 89));
        btn_reserve.setForeground(new java.awt.Color(255, 255, 255));
        btn_reserve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/plus-regular-24.png"))); // NOI18N
        btn_reserve.setText("Reserve");
        btn_reserve.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_reserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reserveActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(54, 37, 89));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/x-regular-24.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(54, 37, 89));
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Choose room");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(754, 754, 754)
                        .addComponent(btn_reserve)
                        .addGap(18, 18, 18)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addGap(103, 103, 103)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reserve, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rooms_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rooms_tableMousePressed
        DefaultTableModel tblMode1 = (DefaultTableModel) rooms_table.getModel();

        idTable = (int) tblMode1.getValueAt(rooms_table.getSelectedRow(), 0);
    }//GEN-LAST:event_rooms_tableMousePressed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       UserHome userHome = new UserHome(preReservation.getUser());
        userHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_reserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reserveActionPerformed
        //ShowJPanel(new InsertRoom());
        validateRoomid(idTable);
    }//GEN-LAST:event_btn_reserveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       // validateDeleteId(idTable);
    }//GEN-LAST:event_btn_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reserve;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rooms_table;
    private javax.swing.JPanel search;
    // End of variables declaration//GEN-END:variables

    public void reloadTable( Reservation reservation) {
        
         long entry_long = reservation.getEntryDate().getTime();
         long departure_long = reservation.getDepartureDate().getTime();
         
         java.sql.Date entry_date = new java.sql.Date(entry_long);
         java.sql.Date departure_date = new java.sql.Date(departure_long); 
         
         System.out.println(entry_date );
         System.out.println(departure_date);
    //Call the select method from tvDao. This method returns a map with the column names, the number of columns, and the table data.
        
        Map<String, Object> result = reservationService.select(entry_date, departure_date, reservation.getHotel().getId(),typeRoom);

        //Get the names of the columns from the results map. The column names are returned as a list of strings.
        List<String> columnNames = (List<String>) result.get("columnNames");

        //Get data from the result map table. The table data is returned as a list of lists of objects. Each inner list represents a row in the table and contains the data for that row.
        List<List<Object>> tableData = (List<List<Object>>) result.get("tableData");

        //Create a new tableModel. A tableModel is an object that manages the data in a table
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            //Override isCellEditable method making all cells uneditables
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //Iterate through the list of column names
        for (String columnName : columnNames) {
            //Add each column name to the tableModel. This creates table's columns.
            model.addColumn(columnName);
        }

        //Iterate through the list of table date
        for (List<Object> rowData : tableData) {
            //Add each row of data to the tableModel. This adds the data to the corresponding columns in the table
            
            model.addRow(rowData.toArray());
        }
        
        //Set tableModel. This updates the table to show data stored in tableModel
        rooms_table.setModel(model);

        //Make table cells uneditable
        rooms_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if(model.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "no available rooms found");
            
            ShowJPanel(new UserPreReservation(preReservation.getUser(), preReservation.getHotel()));
            
        }
    }
    
    public void initTable() {
        reloadTable(preReservation);
      //  TextPrompt tp7 = new TextPrompt("Enter hotel name's ", txt_search);

    }

    //This method validate if there is a selecto arrow from table and show panel AdminUpdateRoom
    public void validateRoomid(int id) {
     
        if (idTable == 0) {
            JOptionPane.showMessageDialog(null, "Please select the room you wish to reserve");
        } else {
            try {
                Room room = roomService.findRoom(id);
                System.out.println(room.getNumber() + room.getId());
                room.setHotel(hotel);
                preReservation.setRoom(room);
                
                ShowJPanel(new UserConfirmReservation(preReservation));
            } catch (NoSuchRoomExcpetion e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }
    
    private void ShowJPanel(JPanel panel) {
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);

        bg.removeAll();
        bg.add(panel, BorderLayout.CENTER);
        bg.revalidate();
        bg.repaint();
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


