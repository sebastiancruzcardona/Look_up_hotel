/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.User;


/**
 *
 * @author lugo
 */
public class AdminHome extends javax.swing.JFrame {

    User user;
    public AdminHome(User user) {
        
        this.user = user;
        
        initComponents();
        setLocationRelativeTo(this);
        admin_name_label.setText(user.getUserName());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nav = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_setting = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        info_panel = new javax.swing.JPanel();
        admin_name_label = new javax.swing.JLabel();
        lb_username = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sing_off = new javax.swing.JButton();
        btn_hotel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        btn_rooms = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_hotel2 = new javax.swing.JLabel();
        btn_users = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_hotel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        search = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nav.setBackground(new java.awt.Color(54, 37, 89));
        nav.setPreferredSize(new java.awt.Dimension(294, 1000));
        nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(54, 37, 89));
        btn_home.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_homeMouseMoved(evt);
            }
        });
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/home-regular-24.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Home");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        nav.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 320, 70));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Screenshot from 2024-03-27 23-35-26.png"))); // NOI18N
        jLabel3.setText("Look up hotel");
        nav.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        btn_setting.setBackground(new java.awt.Color(54, 37, 89));
        btn_setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_settingMouseExited(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cog-regular-24.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("settings");

        javax.swing.GroupLayout btn_settingLayout = new javax.swing.GroupLayout(btn_setting);
        btn_setting.setLayout(btn_settingLayout);
        btn_settingLayout.setHorizontalGroup(
            btn_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_settingLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        btn_settingLayout.setVerticalGroup(
            btn_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        nav.add(btn_setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 310, 70));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        nav.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 820, 260, 20));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        nav.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 20));

        info_panel.setBackground(new java.awt.Color(78, 52, 115));
        info_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin_name_label.setForeground(new java.awt.Color(204, 204, 204));
        admin_name_label.setText("Welcome");
        info_panel.add(admin_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        lb_username.setBackground(new java.awt.Color(54, 37, 89));
        lb_username.setText("Administrator");
        info_panel.add(lb_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 131, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-circle-solid-24.png"))); // NOI18N
        info_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nav.add(info_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 860, -1, 60));

        sing_off.setBackground(new java.awt.Color(54, 37, 89));
        sing_off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/log-out-solid-24.png"))); // NOI18N
        sing_off.setToolTipText("seccion close");
        sing_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sing_offActionPerformed(evt);
            }
        });
        nav.add(sing_off, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 950, -1, -1));

        btn_hotel.setBackground(new java.awt.Color(54, 37, 89));
        btn_hotel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_hotelMouseMoved(evt);
            }
        });
        btn_hotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hotelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hotelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hotelMousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/building-house-regular-24.png"))); // NOI18N

        lbl.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lbl.setForeground(new java.awt.Color(204, 204, 204));
        lbl.setText("Manage hotels");

        javax.swing.GroupLayout btn_hotelLayout = new javax.swing.GroupLayout(btn_hotel);
        btn_hotel.setLayout(btn_hotelLayout);
        btn_hotelLayout.setHorizontalGroup(
            btn_hotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hotelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(45, 45, 45)
                .addComponent(lbl)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        btn_hotelLayout.setVerticalGroup(
            btn_hotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hotelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_hotelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        nav.add(btn_hotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 70));

        btn_rooms.setBackground(new java.awt.Color(54, 37, 89));
        btn_rooms.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_roomsMouseMoved(evt);
            }
        });
        btn_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_roomsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_roomsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_roomsMousePressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hotel-regular-24.png"))); // NOI18N

        btn_hotel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_hotel2.setForeground(new java.awt.Color(204, 204, 204));
        btn_hotel2.setText("Manage rooms");

        javax.swing.GroupLayout btn_roomsLayout = new javax.swing.GroupLayout(btn_rooms);
        btn_rooms.setLayout(btn_roomsLayout);
        btn_roomsLayout.setHorizontalGroup(
            btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_roomsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(46, 46, 46)
                .addComponent(btn_hotel2)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        btn_roomsLayout.setVerticalGroup(
            btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_roomsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hotel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        nav.add(btn_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, 70));

        btn_users.setBackground(new java.awt.Color(54, 37, 89));
        btn_users.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_usersMouseMoved(evt);
            }
        });
        btn_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_usersMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_usersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_usersMousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user-circle-solid-24.png"))); // NOI18N

        btn_hotel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btn_hotel1.setForeground(new java.awt.Color(204, 204, 204));
        btn_hotel1.setText("Manage users");

        javax.swing.GroupLayout btn_usersLayout = new javax.swing.GroupLayout(btn_users);
        btn_users.setLayout(btn_usersLayout);
        btn_usersLayout.setHorizontalGroup(
            btn_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usersLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(46, 46, 46)
                .addComponent(btn_hotel1)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        btn_usersLayout.setVerticalGroup(
            btn_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hotel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        nav.add(btn_users, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, 70));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(2690, 1000));

        search.setBackground(new java.awt.Color(166, 118, 163));

        jLabel10.setBackground(new java.awt.Color(54, 37, 89));
        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("What do you want to do today?");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel10))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel10)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nav, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nav, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseMoved
        setColor(btn_home);
    }//GEN-LAST:event_btn_homeMouseMoved

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        resetColor(btn_home);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        AdminHome adminHome = new AdminHome(user);
        adminHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_hotelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hotelMouseMoved
     setColor(btn_hotel);
    }//GEN-LAST:event_btn_hotelMouseMoved

    private void btn_hotelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hotelMouseExited
         resetColor(btn_hotel);
    }//GEN-LAST:event_btn_hotelMouseExited

    private void btn_hotelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hotelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hotelMousePressed

    private void btn_roomsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseMoved
        setColor(btn_rooms);
    }//GEN-LAST:event_btn_roomsMouseMoved

    private void btn_roomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseExited
        resetColor(btn_rooms);
    }//GEN-LAST:event_btn_roomsMouseExited

    private void btn_roomsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_roomsMousePressed

    private void sing_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sing_offActionPerformed
       UserLogin userLogin = new UserLogin();
       userLogin.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_sing_offActionPerformed

    private void btn_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseClicked
        
        
        ShowJPanel(new AdminGestionRoom()); 
    }//GEN-LAST:event_btn_roomsMouseClicked

    private void btn_settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_settingMouseEntered
        setColor(btn_setting);
    }//GEN-LAST:event_btn_settingMouseEntered

    private void btn_settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_settingMouseExited
         resetColor(btn_setting);
    }//GEN-LAST:event_btn_settingMouseExited

    private void btn_hotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hotelMouseClicked
        ShowJPanel(new AdminManageHotel());
    }//GEN-LAST:event_btn_hotelMouseClicked

    private void btn_usersMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usersMouseMoved
        setColor(btn_users);
    }//GEN-LAST:event_btn_usersMouseMoved

    private void btn_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usersMouseClicked
        ShowJPanel(new AdminManageUser());
    }//GEN-LAST:event_btn_usersMouseClicked

    private void btn_usersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usersMouseExited
       resetColor(btn_users);
    }//GEN-LAST:event_btn_usersMouseExited

    private void btn_usersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usersMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_usersMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin_name_label;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_hotel;
    private javax.swing.JLabel btn_hotel1;
    private javax.swing.JLabel btn_hotel2;
    private javax.swing.JPanel btn_rooms;
    private javax.swing.JPanel btn_setting;
    private javax.swing.JPanel btn_users;
    private javax.swing.JPanel content;
    private javax.swing.JPanel info_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_username;
    private javax.swing.JLabel lbl;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel search;
    private javax.swing.JButton sing_off;
    // End of variables declaration//GEN-END:variables
//This methods change color in the nav buttons
    private void setColor(JPanel panel) {
        panel.setBackground(new Color(67,45,115));    
    }

    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(54,37,89));
    }
    
    //This method show the new  panel in content
    private void ShowJPanel(JPanel panel){
        panel.setSize(1140, 1024);
        panel.setLocation(0, 0);
        
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
}
