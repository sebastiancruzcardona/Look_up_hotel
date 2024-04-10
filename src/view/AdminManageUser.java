/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import helper.TextPrompt;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Room;
import model.User;
import services.UserService;

/**
 *
 * @author lugo
 */
public class AdminManageUser extends javax.swing.JPanel {
    
    int idTable;
    UserService userService;
    public AdminManageUser() {
       userService = new UserService();
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

        back_ground = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        users_table = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_allfilter = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_insert = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1150, 1024));

        back_ground.setBackground(new java.awt.Color(255, 255, 255));
        back_ground.setPreferredSize(new java.awt.Dimension(1050, 1024));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel10.setBackground(new java.awt.Color(54, 37, 89));
        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Manage user");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(593, Short.MAX_VALUE))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(43, 43, 43))
        );

        users_table.setBackground(new java.awt.Color(255, 255, 255));
        users_table.setForeground(new java.awt.Color(0, 0, 0));
        users_table.setModel(new javax.swing.table.DefaultTableModel(
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
        users_table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        users_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                users_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(users_table);

        txt_search.setBackground(new java.awt.Color(255, 255, 255));
        txt_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_search.setName(""); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        btn_allfilter.setBackground(new java.awt.Color(54, 37, 89));
        btn_allfilter.setForeground(new java.awt.Color(255, 255, 255));
        btn_allfilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/filter-regular-24.png"))); // NOI18N
        btn_allfilter.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_allfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allfilterActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(54, 37, 89));
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/edit-alt-regular-24.png"))); // NOI18N
        btn_update.setText("Edit");
        btn_update.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_update.setMaximumSize(new java.awt.Dimension(100, 30));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_insert.setBackground(new java.awt.Color(54, 37, 89));
        btn_insert.setForeground(new java.awt.Color(255, 255, 255));
        btn_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/plus-regular-24.png"))); // NOI18N
        btn_insert.setText("Add");
        btn_insert.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
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

        jButton2.setBackground(new java.awt.Color(54, 37, 89));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search-regular-24.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout back_groundLayout = new javax.swing.GroupLayout(back_ground);
        back_ground.setLayout(back_groundLayout);
        back_groundLayout.setHorizontalGroup(
            back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back_groundLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(back_groundLayout.createSequentialGroup()
                        .addGroup(back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(back_groundLayout.createSequentialGroup()
                                .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete))
                            .addComponent(jScrollPane1))
                        .addGap(47, 47, 47))
                    .addGroup(back_groundLayout.createSequentialGroup()
                        .addComponent(txt_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_allfilter)
                        .addGap(39, 39, 39))))
        );
        back_groundLayout.setVerticalGroup(
            back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back_groundLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_allfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(back_groundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back_ground, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back_ground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void users_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_users_tableMousePressed
        DefaultTableModel tblMode1 = (DefaultTableModel) users_table.getModel();

        idTable = (int) tblMode1.getValueAt(users_table.getSelectedRow(), 0);

    }//GEN-LAST:event_users_tableMousePressed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_allfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allfilterActionPerformed
        reloadTable();
    }//GEN-LAST:event_btn_allfilterActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        validateUpdateId(idTable);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        ShowJPanel(new AdminInsertUser());
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        validateDeleteId(idTable);
    }//GEN-LAST:event_btn_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back_ground;
    private javax.swing.JButton btn_allfilter;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel search;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTable users_table;
    // End of variables declaration//GEN-END:variables


    public void reloadTable() {
        //Call the select method from tvDao. This method returns a map with the column names, the number of columns, and the table data.
        Map<String, Object> result = userService.select();

        //Get the names of the columns from the results map. The column names are returned as a list of strings.
        List<String> columnNames = (List<String>) result.get("columnNames");

        //Get data from the result map table. The table data is returned as a list of lists of objects. Each inner list represents a row in the table and contains the data for that row.
        List<List<Object>> tableData = (List<List<Object>>) result.get("tableData");
         
        //Create a new tableModel. A tableModel is an object that manages the data in a table
        DefaultTableModel model = new DefaultTableModel(){
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
        users_table.setModel(model);
        
        //Make table cells uneditable
        users_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     
        
        
     }
        //this methods reload all methods when start jpanel 
        public void initTable(){
             reloadTable();
            TextPrompt tp7 = new TextPrompt("Enter user name's ", txt_search);
         
        }
        
        private void ShowJPanel(JPanel panel){
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);
        
        back_ground.removeAll();
        back_ground.add(panel, BorderLayout.CENTER);
        back_ground.revalidate();
        back_ground.repaint();
    }
        
        //This method validate if there is a select arrow from table
     public void validateDeleteId(int id){
         if(idTable == 0){
             JOptionPane.showMessageDialog(null, "Please select the table row you want to delete");
         }else{
              int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this room?","Answer",JOptionPane.YES_NO_CANCEL_OPTION );
              if (answer ==JOptionPane.YES_OPTION) {
                 userService.delete(id);
                 reloadTable();
             }
             
             
         }
     }
     
     //This method validate if there is a selecto arrow from table and show panel AdminUpdateUser
     public void validateUpdateId(int id){
         if(idTable == 0){
             JOptionPane.showMessageDialog(null, "Please select the table row you want to Update");
         }else{
              
             
                User user  =userService.findUser(id);
                 // System.out.println(room.getNumber()+ room.getId());
                   ShowJPanel(new AdminUpdateUser(user));
                 
                 
             
             
             
         }
     } 
}

