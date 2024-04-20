package upb.sgttp.model.domain.trainUtilities;

import java.io.Serializable;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.TicketUtilites.Ticket;

public class Train implements Serializable{

    private String trainName;
    private String trainId;
    private float kilometers;
    private int loadingCapacity;
    private String brand;
    private Array<CustomersWagon> customersWagons;
    private Array<LuggageWagon> luggageWagons;
    private boolean available;

    public Train(String trainName, String trainId, float kilometers, int loadingCapacity, String brand, Array<CustomersWagon> customersWagons, Array<LuggageWagon> luggageWagons, boolean available) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        this.loadingCapacity = loadingCapacity;
        this.brand = brand;
        this.customersWagons = customersWagons;
        this.luggageWagons = luggageWagons;
        this.available = available;
    }

    public Train(String trainName, String trainId, float kilometers, String brand, int customersWagons, boolean available) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        setwagons(customersWagons);
        this.brand = brand;
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

    public void setLoadingCapacity(int loadingCapacity) {
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

    public int getLoadingCapacity() {
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
        return new Train("", "", 0, 0, "", new Array(1), new Array(1), true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Name: ").append(trainName).append("\n");
        sb.append("Train ID: ").append(trainId).append("\n");
        sb.append("Kilometers: ").append(kilometers).append("\n");
        sb.append("Loading Capacity: ").append(loadingCapacity).append("\n");
        sb.append("Brand: ").append(brand).append("\n");
        sb.append("Customers Wagons: ").append(customersWagons.toStringg()).append("\n");
        sb.append("Luggage Wagons: ").append(luggageWagons.toStringg()).append("\n");
        return sb.toString();
    }

    public void addkilometers(int kilometers) {
        this.kilometers += kilometers;
    }

    public Integer getLoadingCapacities(Integer nWagons) {
        Integer wagonsTotals = nWagons + luggagueWagon(nWagons);
        return wagonsTotals;
    }

    public Integer luggagueWagon(Integer nWagons) {
        int luggagueWagon = nWagons / 2;
        return luggagueWagon;
    }

    public void setwagons(int vagonesPasajeros) {
        loadingCapacity = getLoadingCapacities(vagonesPasajeros);
        customersWagons = new Array<>(vagonesPasajeros);
        luggageWagons = new Array<>(luggagueWagon(vagonesPasajeros));
        int c = 0;
        for (int i = 0; i < vagonesPasajeros; i++) {
            CustomersWagon customerwagon = new CustomersWagon(i, trainId, 18, 8, 4, new LinkedList<Ticket>());
            customersWagons.add(customerwagon);
            c++;
        }
        for (int i = c; i < loadingCapacity; i++) {
            LuggageWagon wagon = new LuggageWagon(new LinkedList<Luggage>(), trainId, 0, 0, i);
            luggageWagons.add(wagon);
        }
    }

}
