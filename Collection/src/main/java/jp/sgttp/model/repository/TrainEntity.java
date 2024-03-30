package jp.sgttp.model.repository;

import jp.array.Array;
import jp.sgttp.model.domain.trainUtilities.CustomersWagon;
import jp.sgttp.model.domain.trainUtilities.LuggageWagon;

public class TrainEntity {

    private String trainName;
    private String trainId;
    private int kilometers;
    private float loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;

    public TrainEntity(String trainName, String trainId, int kilometers, float loadingCapacity, String brand,
            Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
    }

    // Getters and setters
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public float getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(float loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Array<CustomersWagon> getCustomersWagons() {
        return customersWagons;
    }

    public void setCustomersWagons(Array<CustomersWagon> customersWagons) {
        this.customersWagons = customersWagons;
    }

    public Array<LuggageWagon> getLuggageWagons() {
        return luggageWagons;
    }

    public void setLuggageWagons(Array<LuggageWagon> luggageWagons) {
        this.luggageWagons = luggageWagons;
    }
    
}

