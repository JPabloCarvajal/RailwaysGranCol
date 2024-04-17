/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.gui.AdminPage;
import upb.sgttp.gui.TrainView;
import upb.sgttp.model.TrainModel;
import upb.sgttp.model.domain.trainUtilities.Train;

/**
 *
 * @author thewe
 */
public class TrainController {

    private TrainModel model;
    private TrainView view;
    
    public TrainController(TrainModel model, TrainView view) {
        this.model = model;
        this.view = view;
        initView();
        initController();
    }

    private void initView() {
        model.ReloadTable();
        reloadTable();
    }

    private void initController() {
        JButton addButton = view.getjButton3();
        JButton deleteButton = view.getjButton7();
        JButton updateButton = view.getjButton5();
        JButton backButton = view.getjButton4();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //agregar tren
                String sType = (String) view.getjComboBox1().getSelectedItem();
                String nombre = view.getjTextField1().getText();
                int kilometros = 0;
                int vagonesPasajeros = Integer.parseInt(view.getjTextField2().getText());
                int tipo = 0;
                int vagonesMax = 0;
                if (!view.getjTextField2().getText().isBlank()) {
                    String marca = "";
                    if (sType.equals("Mercedez-Benz")) {
                        marca = "Mercedez-Benz";
                        tipo = 0;
                        vagonesMax = 19;//o 19 si no se cuenta la locomotora
                    } else {
                        if (sType.equals("Arnold")) {
                            marca = "Arnold";
                            tipo = 1;
                            vagonesMax = 21;//si pongo 22 tocaria agregar otro vagon de carga y no se puede grave
                        }
                    }
                    if (vagonesMax >= vagonesPasajeros) {
                        Train train = new Train(nombre, model.createIdTrain(tipo), kilometros, marca, vagonesPasajeros, true);
                        model.addTrain(train);
                        reloadTable();
                        view.getjTextField1().setText("");
                        view.getjTextField2().setText("");
                    }
                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar tren
                int selectedRow = view.getjTable().getSelectedRow();
                LinkedList<Train> list = model.getTrainList();
                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1 && list.get(selectedRow).isAvailable()) {
                    // Eliminar la fila del modelo de la tabla
                    if (list.size() > 1) {
                        model.removeTrain(list.get(selectedRow));
                        reloadTable();
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //actualizar tren
                int selectedRow = view.getjTable().getSelectedRow();
                LinkedList<Train> list = model.getTrainList();
                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1 && list.get(selectedRow).isAvailable()) {
                    // modificar la fila del modelo de la tabla
                    list.get(selectedRow);
                    String sType = (String) view.getjComboBox1().getSelectedItem();
                    String nombre = view.getjTextField1().getText();
                    int vagonesPasajeros = Integer.parseInt(view.getjTextField2().getText());
                    if (!view.getjTextField2().getText().isBlank()) {
                        list.get(selectedRow).setTrainName(nombre);
                        list.get(selectedRow).setwagons(vagonesPasajeros);
                        model.updateTrain(list.get(selectedRow));
                        reloadTable();
                        view.getjTextField1().setText("");
                        view.getjTextField2().setText("");
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retroceder (botón de atrás)
                view.dispose();
                AdminPage ventanaPrincipal = new AdminPage();
                ventanaPrincipal.setVisible(true);
                ventanaPrincipal.setLocationRelativeTo(null);
            }
        });
    }

    private void reloadTable() {
        view.getjTable().setModel(model.getTableModel());
    }
}
