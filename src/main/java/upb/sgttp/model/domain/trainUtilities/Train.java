package upb.sgttp.model.domain.trainUtilities;

import jp.array.Array;
import upb.sgttp.model.domain.RouteUtilities.Station;

public class Train {

    private String trainName;
    private String trainId;
    private int kilometers;
    private float loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    private Station ubication;
    private boolean available;

    public Train(String trainName, String trainId, int kilometers, 
                 float loadingCapacity, String brand,
                 Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
        this.available = true;
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
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Name: ").append(trainName).append("\n");
        sb.append("Train ID: ").append(trainId).append("\n");
        sb.append("Kilometers: ").append(kilometers).append("\n");
        sb.append("Loading Capacity: ").append(loadingCapacity).append("\n");
        sb.append("Brand: ").append(brand).append("\n");
        sb.append("Ubication: ").append(ubication.toString()).append("\n");
        sb.append("Customers Wagons: ").append(customersWagons.toStringg()).append("\n");
        sb.append("Luggage Wagons: ").append(luggageWagons.toStringg()).append("\n");
        return sb.toString();
    }
}
