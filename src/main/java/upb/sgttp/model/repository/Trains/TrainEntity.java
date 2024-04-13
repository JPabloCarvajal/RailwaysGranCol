package upb.sgttp.model.repository.Trains;

import jp.array.Array;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.trainUtilities.CustomersWagon;
import upb.sgttp.model.domain.trainUtilities.LuggageWagon;
import upb.sgttp.model.domain.trainUtilities.Train;

public class TrainEntity {

    private String trainName;
    private String trainId;
    private float kilometers;
    private Array<Integer> loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    private boolean available;

    public TrainEntity(String trainName, String trainId, float kilometers, Array<Integer> loadingCapacity, String brand,
                 Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons, boolean available) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setKilometers(float kilometers) {
        this.kilometers = kilometers;
    }

    public void setLoadingCapacity(Array<Integer> loadingCapacity) {
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

    public float getKilometers() {
        return kilometers;
    }

    public Array<Integer> getLoadingCapacity() {
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
        return new Train("", "", 0, new Array(1), "", new Array(1), new Array(1), true);
    }
}

