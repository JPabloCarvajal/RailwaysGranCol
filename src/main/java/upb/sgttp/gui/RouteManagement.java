/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package upb.sgttp.gui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Main;
import upb.sgttp.model.domain.RouteUtilities.Route;
import upb.sgttp.model.domain.RouteUtilities.RoutesMap;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.Train;

/**
 *
 * @author thewe
 */
public class RouteManagement extends javax.swing.JFrame {

    RoutesMap mapa = new RoutesMap();
    DefaultTableModel model = new DefaultTableModel();
    LinkedList<Route> list = new LinkedList<>();

    /**
     * Creates new form RouteManagement
     */
    public RouteManagement() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestion de rutas");

        jLabel2.setText("Estacion de inicio");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Estacion de destino");

        jLabel4.setText("Fecha y hora de salida");

        jLabel5.setText("ID tren");

        jButton3.setText("agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("dar de baja");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addGap(88, 88, 88))
        );

        jScrollPane3.setViewportView(jTable3);

        jButton4.setText("prev");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String station1 = jTextField1.getText();
        String station2 = jTextField2.getText();
        String fecha = jTextField3.getText();
        String idtren = jTextField4.getText();
        Train train = Main.getTrain(idtren);
        if (train.isAvailable()) {
            LinkedList<Station> stations = mapa.stationsToTravel(mapa.getStation(station1), mapa.getStation(station2));
            Route route = new Route(stations, mapa.getStation(station1), mapa.getStation(station2), Main.DateConverter(fecha), mapa.calculateEstimatedArrivalTime(Main.DateConverter(fecha), stations), mapa.calculateTotalDistance(stations), train, Main.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
            train.setAvailable(false);
            Main.modifyJsonTrain(train.getTrainId(), Main.getTrain(idtren), train);
            list.add(route);
            upb.sgttp.model.domain.Main.modifyListRoutes(list);
            upb.sgttp.model.domain.Main.addJsonRoute(route);
            reloadTable();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if (selectedRow != -1) {
            // modificar la fila del modelo de la tabla
//            list.get(selectedRow);
//            String sType = (String) jComboBox1.getSelectedItem();
            list = upb.sgttp.model.domain.Main.getRoutes();
            String station1 = jTextField1.getText();
            String station2 = jTextField2.getText();
            String fecha = jTextField3.getText();
            String idtren = jTextField4.getText();
            Train train = Main.getTrain(idtren);
            // Obtener la fecha y hora actual
            LocalDateTime currentDateTime = LocalDateTime.now();
            // Formatear la fecha y hora según tus necesidades
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            // Convertir la fecha de partida de la lista a LocalDateTime
            Date departureDate = list.get(selectedRow).getDepartureTime();
            Instant instant = departureDate.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime departureDateTime = instant.atZone(zoneId).toLocalDateTime();
//            if (departureDateTime.isAfter(currentDateTime) && (list.get(selectedRow).getTrainToDoRoute().isAvailable() || idtren.equals(upb.sgttp.model.domain.Main.getTrain(idtren).getTrainId()))) {

            LinkedList<Station> stations = mapa.stationsToTravel(mapa.getStation(station1), mapa.getStation(station2));
            Route route = new Route(stations, mapa.getStation(station1), mapa.getStation(station2), Main.DateConverter(fecha), mapa.calculateEstimatedArrivalTime(Main.DateConverter(fecha), stations), mapa.calculateTotalDistance(stations), train, Main.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
            String id = list.get(selectedRow).getRouteId();
            String idt = list.get(selectedRow).getTrainToDoRoute().getTrainId();
            list.get(selectedRow).setStations(stations);
            list.get(selectedRow).setStartPoint(mapa.getStation(station1));
            list.get(selectedRow).setDestinationPoint(mapa.getStation(station2));
            list.get(selectedRow).setDepartureTime(Main.DateConverter(fecha));
            list.get(selectedRow).setEstimatedArrivalTime(mapa.calculateEstimatedArrivalTime(Main.DateConverter(fecha), stations));
            list.get(selectedRow).setTotalKmToTravel(mapa.calculateTotalDistance(stations));
            list.get(selectedRow).setTrainToDoRoute(train);
            list.get(selectedRow).setRouteId(Main.createIdRoute(mapa.getStation(station1), mapa.getStation(station2)));
            if (!idtren.equals(id)) {
                System.out.println("train set available");
//                train.setAvailable(true);
                upb.sgttp.model.domain.Main.modifyTrainIsAvailable(idt, train.getTrainId());
//                upb.sgttp.model.domain.Main.modifyJsonTrain(id, train, list.get(selectedRow).getTrainToDoRoute());
            }
            upb.sgttp.model.domain.Main.modifyListRoutes(list);
            upb.sgttp.model.domain.Main.modifyRoute(route, id);
            reloadTable();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");

//            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminPage ventanaPrincipal = new AdminPage();
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable3.getSelectedRow();
        System.out.println("selectedRow = " + selectedRow);
        Train train = list.get(selectedRow).getTrainToDoRoute();
        String id = list.get(selectedRow).getRouteId();
        // Verificar si se ha seleccionado una fila
        if (selectedRow != -1) {
            // Eliminar la fila del modelo de la tabla
            if (list.size() > 1) {
                list.remove(list.get(selectedRow));
                reloadTable();
            }
        }
        upb.sgttp.model.domain.Main.modifyListRoutes(list);
        upb.sgttp.model.domain.Main.DeleteRoute(id);
        Main.modifyTrainIsAvailable(train.getTrainId());
    }//GEN-LAST:event_jButton7ActionPerformed
    public void addRoute() {
        model.addColumn("Estacion inicio");
        model.addColumn("Estacion destino");
        model.addColumn("Fecha de salida");
        model.addColumn("Fecha de llegada ");
        model.addColumn("KM");
        model.addColumn("Id tren");
        model.addColumn("Id ruta");
        reloadTable();
    }

    private void reloadTable() {
        //borrar los elementos del modelo
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        list = upb.sgttp.model.domain.Main.getRoutes();
        for (int i = 0; i < list.size(); i++) {
            Object u[] = new Object[7];
            u[0] = list.get(i).getStartPoint().getStationName();
            u[1] = list.get(i).getDestinationPoint().getStationName();
            u[2] = list.get(i).getDepartureTime();
            u[3] = list.get(i).getArrivalTime();
            u[4] = list.get(i).getTotalKmToTravel();
            u[5] = list.get(i).getTrainToDoRoute().getTrainId();
            u[6] = list.get(i).getRouteId();
            model.addRow(u);
        }
        jTable3.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
