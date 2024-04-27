/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package botones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author nicolasdurangarces
 */
public class botonesDinamicos extends javax.swing.JFrame {

    /**
     * Creates new form botonesDinamicos
     */
    public botonesDinamicos() {
        initComponents();
        
        
        // Obtén el número de registros de la base de datos
        int numRegistros = 100;
        
        // Crea un JPanel para contener las tarjetas
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));
        
        PanelPerron.setLayout(new GridLayout(numRegistros / 3 + 1, 3, 10, 10));

        // Crea las tarjetas dinámicamente y añádelas al JPanel
        for (int i = 0; i < numRegistros; i++) {
            // Crea un nuevo JPanel para la tarjeta
            JPanel card = new JPanel();
            card.setBorder(new EmptyBorder(10, 10, 10, 10));  // Agrega un borde vacío para simular un padding
            card.setBackground(Color.WHITE);  // Establece el color de fondo de la tarjeta
            card.setLayout(new BorderLayout());  // Establece el layout de la tarjeta

            // Crea un JLabel para el título de la tarjeta y añádelo al JPanel
            JLabel title = new JLabel("Tarjeta " + (i + 1));
            title.setFont(new Font("Arial", Font.BOLD, 14));  // Establece la fuente del título
            card.add(title, BorderLayout.NORTH);

            // Crea un JLabel para el contenido de la tarjeta y añádelo al JPanel
            JLabel content = new JLabel("Contenido de la tarjeta " + (i + 1));
            card.add(content, BorderLayout.CENTER);
            
            // Crea un JTextField para el campo de texto adicional y añádelo al JPanel
            JLabel textField = new JLabel("Texto adicional " + (i + 1));
            card.add(textField, BorderLayout.SOUTH);
            
            // Crea una variable final que contenga el valor de i
            final int index = i;
            
           // Crea un borde compuesto con un borde vacío y un borde de línea
            Border padding = new EmptyBorder(10, 10, 10, 10);
            Border borderLine = BorderFactory.createLineBorder(Color.BLACK, 1);
            Border border = new CompoundBorder(borderLine, padding);
            card.setBorder(border);
            
            // Agrega un MouseListener al JPanel
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Este código se ejecutará cuando se haga clic en el JPanel
                    System.out.println("Se hizo clic en la tarjeta " + (index + 1));
                    
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambia el color del borde a azul cuando el ratón entra en el JPanel
                    Border blueBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
                    Border compound = new CompoundBorder(blueBorder, padding);
                    card.setBorder(compound);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Cambia el color del borde al color inicial cuando el ratón sale del JPanel
                    card.setBorder(border);
                }
            });
            
            // Cambia el cursor a un puntero de mano cuando el ratón está sobre el JPanel
            card.setCursor(Cursor.getDefaultCursor().getPredefinedCursor(Cursor.HAND_CURSOR));

            cardsPanel.add(card);
        }
        
        

            // Crea un JScrollPane y añade el JPanel a él
            JScrollPane scrollPane = new JScrollPane(cardsPanel);
            scrollPane.setPreferredSize(new Dimension(PanelPerron.getWidth(), PanelPerron.getHeight()));

            // Añade el JScrollPane a tu panel principal
            PanelPerron.setLayout(new BorderLayout());
            PanelPerron.add(scrollPane, BorderLayout.CENTER);

            // Actualiza el JPanel para mostrar los nuevos botones
            PanelPerron.revalidate();
            PanelPerron.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPerron = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelPerronLayout = new javax.swing.GroupLayout(PanelPerron);
        PanelPerron.setLayout(PanelPerronLayout);
        PanelPerronLayout.setHorizontalGroup(
            PanelPerronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        PanelPerronLayout.setVerticalGroup(
            PanelPerronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(PanelPerron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(PanelPerron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(botonesDinamicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(botonesDinamicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(botonesDinamicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(botonesDinamicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new botonesDinamicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel PanelPerron;
    // End of variables declaration//GEN-END:variables
}
