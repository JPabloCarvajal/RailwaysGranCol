package upb.sgttp.model.domain.trainUtilities;

import jp.array.Array;
import upb.sgttp.model.domain.RouteUtilities.Station;

public class Train {

    private String trainName;
    private String trainId;
    private float kilometers;
    private Array<Integer> loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    private boolean available;

    public Train(String trainName, String trainId, float kilometers, Array<Integer> loadingCapacity, String brand, Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons, boolean available) {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Name: ").append(trainName).append("\n");
        sb.append("Train ID: ").append(trainId).append("\n");
        sb.append("Kilometers: ").append(kilometers).append("\n");
        sb.append("Loading Capacity: ").append(loadingCapacity.toStringg()).append("\n");
        sb.append("Brand: ").append(brand).append("\n");
        sb.append("Customers Wagons: ").append(customersWagons.toStringg()).append("\n");
        sb.append("Luggage Wagons: ").append(luggageWagons.toStringg()).append("\n");
        return sb.toString();
    }

    public void addkilometers(int kilometers) {
        this.kilometers += kilometers;
    }

    private Integer loadingCapacity(Integer nWagons) {
        int luggagueWagon = luggagueWagon = nWagons / 2;
        Integer wagonsTotals = nWagons + luggagueWagon;
        return wagonsTotals;
    }

}
