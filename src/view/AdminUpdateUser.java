/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import exceptions.EmptyFieldsException;
import exceptions.NotAnEmailException;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.User;
import services.UserService;
import view.AdminManageUser;

/**
 *
 * @author lugo
 */
public class AdminUpdateUser extends javax.swing.JPanel {

    User user;
    UserService userService;
    
    public AdminUpdateUser(User user) {
        userService = new UserService();
        this.user=user;
        
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

        bg = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_contact = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combox_rol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1150, 1024));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel11.setBackground(new java.awt.Color(54, 37, 89));
        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Manage user");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
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
        jLabel10.setText("Update user");

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

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Password:");

        txa_contact.setBackground(new java.awt.Color(255, 255, 255));
        txa_contact.setColumns(20);
        txa_contact.setRows(5);
        jScrollPane1.setViewportView(txa_contact);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Contact details:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Username:");

        txt_username.setBackground(new java.awt.Color(255, 255, 255));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setFocusable(false);
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(255, 255, 255));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        combox_rol.setBackground(new java.awt.Color(255, 255, 255));
        combox_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Client" }));
        combox_rol.setSelectedIndex(-1);
        combox_rol.setToolTipText("");
        combox_rol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        combox_rol.setPreferredSize(new java.awt.Dimension(64, 24));
        combox_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_rolActionPerformed(evt);
            }
        });

        jLabel2.setText("Rol:");

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
                        .addGap(393, 393, 393)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(combox_rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(389, 389, 389)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_username)
                            .addComponent(jLabel5)
                            .addComponent(txt_password)
                            .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)))
                    .addGap(389, 389, 389)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combox_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(313, 313, 313)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        try {
            String userName = txt_username.getText();
            String password = txt_password.getText();
            String contact = txa_contact.getText();
            int index = combox_rol.getSelectedIndex()+1;
           
            userService.validateEmail(txt_email.getText());
            userService.validateFilledFields(userName, user.getEmail(), password, contact);
            userService.update(userName, user.getEmail(), password, contact,index);
            clear();

            ShowJPanel(new AdminManageUser());

       } catch (EmptyFieldsException | NotAnEmailException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void combox_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_rolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_edit;
    private javax.swing.JComboBox<String> combox_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel search;
    private javax.swing.JTextArea txa_contact;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
    //This method show the new  panel in content
    private void ShowJPanel(JPanel panel){
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);
        
        bg.removeAll();
        bg.add(panel, BorderLayout.CENTER);
        bg.revalidate();
        bg.repaint();
    }
 
     //This method change txtField for date from room about edit
    public void initPanel() {
        txt_username.setText(user.getUserName());
        txt_password.setText(user.getPassword());
        txa_contact.setText(user.getDetails());
        combox_rol.setSelectedIndex(user.getRol()-1);
        txt_email.setText(user.getEmail());
    }
    
 //This method clean txtfields then do update
    public void clear() {
        txt_username.setText("");
        txt_email.setText("");
        txt_password.setText("");

        txa_contact.setText("");
    }
}
