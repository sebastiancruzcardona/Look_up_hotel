/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import exceptions.EmptyFieldsException;
import exceptions.HotelNameAlreadyInDataBase;
import exceptions.JustSpacesException;
import exceptions.NoClassificationOptionChosen;
import exceptions.NotAlphaNumericException;
import exceptions.NotAnEmailException;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import services.UserService;

/**
 *
 * @author lugo
 */
public class AdminInsertUser extends javax.swing.JPanel {

    UserService userService;
    public AdminInsertUser() {
        userService = new UserService();
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_contact = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
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
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jLabel10.setText("Registre new user");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Password:");

        txt_contact.setBackground(new java.awt.Color(255, 255, 255));
        txt_contact.setColumns(20);
        txt_contact.setForeground(new java.awt.Color(0, 0, 0));
        txt_contact.setRows(5);
        txt_contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_contact);

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Contact details:");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Username:");

        txt_username.setBackground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(255, 255, 255));
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Email:");

        btn_add.setBackground(new java.awt.Color(54, 37, 89));
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/plus-regular-24.png"))); // NOI18N
        btn_add.setText("Add");
        btn_add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

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
                        .addComponent(jLabel4))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combox_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(346, 346, 346))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(389, 389, 389)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addComponent(txt_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addComponent(txt_username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
                    .addContainerGap(347, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combox_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(313, 313, 313)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try{
            String name = txt_username.getText();
            String email = txt_email.getText();
            int rol = combox_rol.getSelectedIndex() + 1;
            String password = txt_password.getText();
            String contact = txt_contact.getText();
            
            userService.validateFilledFields(name, email, password, contact);
            userService.validateEmail(email);
            
            userService.insertManage(name, email, password, contact, rol);
            
            clear();

        }catch (NotAnEmailException | EmptyFieldsException | NotAlphaNumericException | JustSpacesException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void combox_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_rolActionPerformed

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        int key = evt.getKeyChar();
        ///Validate if pressed key is a letter (upper case or lower case) or space
        boolean caracter = key >= 65 && key <= 90 || key >= 97 && key <= 122 ||key == 32;
        //If is another thing do not put the character in the text field
        if(!caracter){
            evt.consume();
        }
    }//GEN-LAST:event_txt_usernameKeyTyped

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        
    }//GEN-LAST:event_txt_emailKeyTyped

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyTyped
        int key = evt.getKeyChar();
       //Validate if pressed key is a number, upper case, lower case or space, ",", "-" or "."
        boolean caracter = key >= 48 && key <= 57 || key >= 65 && key <= 90 || key >= 97 && key <= 122 ||key == 32 || key >= 44 && key <= 46;
        //If is another thing do not put the character in the text field
        if(!caracter){
            evt.consume();
        }
    }//GEN-LAST:event_txt_contactKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_add;
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
    private javax.swing.JTextArea txt_contact;
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
 
 //This method clean txtfields then do update
    public void clear() {
        txt_username.setText("");
        txt_email.setText("");
        txt_password.setText("");
        combox_rol.setSelectedIndex(-1);
        txt_contact.setText("");
    }
}
