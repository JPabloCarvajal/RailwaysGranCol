/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import upb.sgttp.gui.TrainView;
import upb.sgttp.model.TrainModel;

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
        // Asociar eventos de la vista con métodos del controlador
//        this.view.addButtonActionListener(new AddButtonListener());
//        this.view.modifyButtonActionListener(new ModifyButtonListener());
//        this.view.deleteButtonActionListener(new DeleteButtonListener());
//        this.view.prevButtonActionListener(new PrevButtonListener());
        // Inicializar la vista con los datos del modelo
//        this.view.setTrainTableData(this.model.getTrainData());
    }

    // Listeners para los botones de la vista
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para agregar un tren
            String name = view.getTrainName();
            int wagons = view.getPassengerWagons();
            String brand = view.getSelectedBrand();
            model.addTrain(name, wagons, brand);
            view.displaySuccessMessage("Tren agregado correctamente.");
            view.clearFields();
//            view.setTrainTableData(model.getTrainData());
        }
    }

    // Agregar otros listeners aquí para los otros botones
}
