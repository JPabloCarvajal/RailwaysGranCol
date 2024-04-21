/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author thewe
 */
public class TicketView extends javax.swing.JFrame{

    public TicketView() {
        initComponents();
//        addImageToPanel();
        setImagen();
    }

//    private void addImageToPanel() {
//        // Cargar la imagen desde el archivo
//        ImageIcon icon = new ImageIcon("grafo.jpg");
//
//        // Crear un JLabel para mostrar la imagen
//        JLabel imageLabel = new JLabel(icon);
//
//        // Crear un JPanel para contener la imagen
//        JPanel imagePanel = new JPanel(new GridBagLayout());
//
//        // Configurar las restricciones para colocar la imagen en la esquina inferior derecha
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.anchor = GridBagConstraints.SOUTHEAST; // Alineación en la esquina inferior derecha
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        imagePanel.add(imageLabel, gbc);
//
//        // Agregar el JPanel al JFrame
//        getContentPane().add(imagePanel);
//    }
    // Método para configurar la imagen
    private void setImagen() {
        // Crea un JLabel para mostrar la imagen
        JLabel labelImagen = new JLabel();
        
        // Carga la imagen desde un archivo
        ImageIcon icono = new ImageIcon("grafo.jpg");
        
        // Escala la imagen para que se ajuste al tamaño del JLabel
        ImageIcon imagen = new ImageIcon(icono.getImage().getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH));
        
        // Establece la imagen escalada en el JLabel
        labelImagen.setIcon(imagen);
        
        // Configurar restricciones para el posicionamiento
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Columna 0
        gbc.gridy = GridBagConstraints.REMAINDER; // Última fila
        gbc.anchor = GridBagConstraints.SOUTHWEST; // Esquina inferior izquierda
        gbc.weightx = 1.0; // Estirar el componente horizontalmente
        gbc.weighty = 1.0; // Estirar el componente verticalmente
        
        // Agrega el JLabel al JPanel
        jPanel1.add(labelImagen, gbc);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
