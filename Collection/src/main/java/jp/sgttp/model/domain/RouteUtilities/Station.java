package jp.sgttp.model.domain.RouteUtilities;

public class Station {
    
    private String stationName;
    private String cityStation;

    public Station(String stationName, String cityStation) {
        this.stationName = stationName;
        this.cityStation = cityStation;
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
