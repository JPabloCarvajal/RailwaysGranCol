/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thewe
 */
public class TrainModel {
    private DefaultTableModel trainData;

    public TrainModel() {
        // Inicializar los datos del modelo
        this.trainData = new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "Nombre", "Id", "Kilómetros", "Capacidad de carga", "Marca", "Disponibilidad"
            }
        );
    }

    // Agregar un tren al modelo
    public void addTrain(String name, int wagons, String brand) {
        // Aquí iría la lógica para agregar un tren al modelo
        // Por ahora, solo se agrega un nuevo tren a la tabla
        trainData.addRow(new Object[]{name, wagons, brand});
    }

    // Obtener los datos de los trenes
    public DefaultTableModel getTrainData() {
        return trainData;
    }
}
