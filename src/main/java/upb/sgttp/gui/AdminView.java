/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.gui;
import javax.swing.*;

/**
 *
 * @author thewe
 */
public class AdminView extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

    /**
     * Creates new form AdminPage
     */
    public AdminView() {
        initComponents(); // Inicializar componentes
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");

        jButton1.setText("Main Menu");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Panel");

        jButton2.setText("Train Management");

        jButton3.setText("Route Management");

        jButton4.setText("User Management");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    // Acción del botón "Main menu"
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Acción del botón "Gestion de trenes"
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Acción del botón "Gestion de rutas"
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Acción del botón "Gestion de usuarios"
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Método para obtener el botón "Main menu"
    public JButton getjButton1() {
        return jButton1;
    }

    // Método para establecer el botón "Main menu"
    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    // Método para obtener el botón "Gestion de trenes"
    public JButton getjButton2() {
        return jButton2;
    }

    // Método para establecer el botón "Gestion de trenes"
    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    // Método para obtener el botón "Gestion de rutas"
    public JButton getjButton3() {
        return jButton3;
    }

    // Método para establecer el botón "Gestion de rutas"
    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    // Método para obtener el botón "Gestion de usuarios"
    public JButton getjButton4() {
        return jButton4;
    }

    // Método para establecer el botón "Gestion de usuarios"
    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    // Método para obtener la etiqueta "Admin"
    public JLabel getjLabel1() {
        return jLabel1;
    }

    // Método para establecer la etiqueta "Admin"
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    // Método para obtener el panel
    public JPanel getjPanel1() {
        return jPanel1;
    }

    // Método para establecer el panel
    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
}
