package upb.sgttp.model.domain.RouteUtilities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa una estación en el sistema de gestión de rutas y el mapa como nodo de un grafo.
 */
public class Station implements Serializable{
    
    private String stationName; // El nombre de la estación
    private String cityStation; // La ciudad donde se encuentra la estación

    /**
     * Constructor de la clase Station.
     * @param stationName El nombre de la estación.
     * @param cityStation La ciudad donde se encuentra la estación.
     */
    public Station(String stationName, String cityStation) {
        this.stationName = stationName;
        this.cityStation = cityStation;
    }

    /**
     * Obtiene el nombre de la estación.
     * @return El nombre de la estación.
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Obtiene la ciudad donde se encuentra la estación.
     * @return La ciudad donde se encuentra la estación.
     */
    public String getCityStation() {
        return cityStation;
    }

    /**
     * Establece el nombre de la estación.
     * @param stationName El nombre de la estación.
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Establece la ciudad donde se encuentra la estación.
     * @param cityStation La ciudad donde se encuentra la estación.
     */
    public void setCityStation(String cityStation) {
        this.cityStation = cityStation;
    }

    /**
     * Compara esta estación con otro objeto para determinar si son iguales.
     * Dos estaciones son iguales si tienen el mismo nombre.
     * @param estacion El objeto con el que se va a comparar.
     * @return true si las estaciones son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object estacion) {
        if (this == estacion) {
            return true;
        }
        if (estacion == null || getClass() != estacion.getClass()) {
            return false;
        }
        Station other = (Station) estacion;
        return Objects.equals(stationName, other.stationName);
    }
}
