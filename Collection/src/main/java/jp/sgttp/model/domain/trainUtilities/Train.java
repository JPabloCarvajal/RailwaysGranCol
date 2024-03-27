package jp.sgttp.model.domain.trainUtilities;

import jp.array.Array;

public class Train {

    private String trainName;
    private int trainId;
    private int kilometers;
    private float loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    
    public Train(String trainName, int trainId, int kilometers, float loadingCapacity, String brand,
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

    public void setTrainId(int trainId) {
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

    public int getTrainId() {
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

}
