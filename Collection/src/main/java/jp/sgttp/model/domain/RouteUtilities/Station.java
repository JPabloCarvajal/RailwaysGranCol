package jp.sgttp.model.domain.RouteUtilities;

import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.trainUtilities.Train;

public class Station {
    
    private String stationName;
    private String cityStation;
    private LinkedList<Train> trains;

    public LinkedList<Train> getTrains() {
        return trains;
    }

    public void setTrains(LinkedList<Train> trains) {
        this.trains = trains;
    }

    public Station(String stationName, String cityStation) {
        this.stationName = stationName;
        this.cityStation = cityStation;
        this.trains = null;
    }

    public String getStationName() {
        return stationName;
    }

    public String getCityStation() {
        return cityStation;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setCityStation(String cityStation) {
        this.cityStation = cityStation;
    }
}
