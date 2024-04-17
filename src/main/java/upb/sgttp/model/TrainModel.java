/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Trains.TrainRepository;

/**
 *
 * @author thewe
 */
public class TrainModel {

    DefaultTableModel tableModel = new DefaultTableModel();
    TrainRepository trains = new TrainRepository("src\\main\\java\\upb\\sgttp\\database\\train.json");

    public TrainModel() {
        initTableModel();
    }

    private void initTableModel() {
        // Inicializar el modelo de la tabla con las columnas necesarias
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Id");
        tableModel.addColumn("Kilómetros");
        tableModel.addColumn("Capacidad de carga");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Disponibilidad");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public LinkedList<Train> getTrainList() {
        return trains.getAllTrainsAsLinkedList();
    }

    // Métodos para la gestión de usuarios
    public void addTrain(Train train) {
        trains.addTrain(train);
        ReloadTable();
    }

    public void removeTrain(Train train) {
        trains.removeTrain(train.getTrainId());
        ReloadTable();

    }

    public void updateTrain(Train train) {
        trains.modifyTrain(train.getTrainId(), train);
        ReloadTable();
    }

    public void ReloadTable() {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
        LinkedList<Train> trainList = trains.getAllTrainsAsLinkedList();
        for (int i = 0; i < trainList.size(); i++) {
            Object u[] = new Object[6];
            u[0] = trainList.get(i).getTrainName();
            u[1] = trainList.get(i).getTrainId();
            u[2] = trainList.get(i).getKilometers();
            u[3] = trainList.get(i).getLoadingCapacity();
            u[4] = trainList.get(i).getBrand();
            u[5] = trainList.get(i).isAvailable();
            getTableModel().addRow(u);
        }
    }

    public String createIdTrain(int type) {
        String generatedId = "";
        int nextId = trains.getAllTrainsAsLinkedList().getSize() + 1;
        switch (type) {
            case 0://empleado
                generatedId = "M" + nextId;
                break;
            case 1://cliente
                generatedId = "A" + nextId;
                break;
        }
        nextId++;
        return generatedId;
    }
}
