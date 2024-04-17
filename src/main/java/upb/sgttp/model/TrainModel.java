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
//    private LinkedList<Train> trainList;
    TrainRepository trains = new TrainRepository("src\\main\\java\\upb\\sgttp\\database\\train.json");

    public TrainModel() {
        // Inicializar los datos del modelo
//        this.trainList = trains.getAllTrainsAsLinkedList();
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

    // Otros métodos para manejar la lógica de gestión de usuarios aquí
    // Métodos para la gestión de usuarios
    public void addTrain(Train train) {
//        trainList.add(train);
        trains.addTrain(train);
//        users.addUser(user);
//        userList.add(user);
        ReloadTable();
    }

    public void removeTrain(Train train) {
//        trainList.remove(train);
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
//            Train train = list.get(i).getPerson;
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
}
