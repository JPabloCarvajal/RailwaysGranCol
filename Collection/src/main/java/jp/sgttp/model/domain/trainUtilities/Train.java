package jp.sgttp.model.domain.trainUtilities;

import jp.array.Array;

public class Train {

    private String trainName;
    private String trainId;
    private int kilometers;
    private float loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    
    public Train(String trainName, String trainId, int kilometers, float loadingCapacity, String brand,
                 Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
    }
    
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void setLoadingCapacity(float loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCustomersWagons(Array<CustomersWagon> customersWagons) {
        this.customersWagons = customersWagons;
    }

    public void setLuggageWagons(Array<LuggageWagon> luggageWagons) {
        this.luggageWagons = luggageWagons;
    }

    // Getters
    public String getTrainName() {
        return trainName;
    }

    public String getTrainId() {
        return trainId;
    }

    public int getKilometers() {
        return kilometers;
    }

    public float getLoadingCapacity() {
        return loadingCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public Array<CustomersWagon> getCustomersWagons() {
        return customersWagons;
    }

    public Array<LuggageWagon> getLuggageWagons() {
        return luggageWagons;
    }

    public static Train getNullTrain() {
        return new Train("", "", 0, 0, "", null, null);
    }

    /*Nombre: Gestión de trenes. 
    Como empleado, quiero un sistema de gestión de trenes, para garantizar una 
    buena operación. 
    Criterio de aceptación: 
    el administrador podrá agregar un tren, darlo de baja, consultar, modificar 
    los datos de los trenes, cada tren debe tener los siguientes datos nombre, 
    identificador, capacidad de carga y kilometraje.
    Prioridad: Alto.  */

}
