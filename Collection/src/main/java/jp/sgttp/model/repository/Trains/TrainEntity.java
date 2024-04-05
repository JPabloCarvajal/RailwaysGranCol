package jp.sgttp.model.repository.Trains;

import jp.array.Array;
import jp.sgttp.model.domain.RouteUtilities.Station;
import jp.sgttp.model.domain.trainUtilities.CustomersWagon;
import jp.sgttp.model.domain.trainUtilities.LuggageWagon;
import jp.sgttp.model.domain.trainUtilities.Train;

public class TrainEntity {

    private String trainName;
    private String trainId;
    private int kilometers;
    private float loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    private Station ubication;
    
    
    public Station getUbication() {
        return ubication;
    }

    public void setUbication(Station ubication) {
        this.ubication = ubication;
    }

    public TrainEntity(String trainName, String trainId, int kilometers, float loadingCapacity, String brand,
                 Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons,Station ubication) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
        this.ubication = ubication;
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
        return new Train("", "", 0, 0, "", null, null,null);
    }
}

