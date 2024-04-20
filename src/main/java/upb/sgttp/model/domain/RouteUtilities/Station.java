package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Objects;

public class Station implements Serializable{
    
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Station other = (Station) obj;
        return Objects.equals(stationName, other.stationName);
    }
}
