package upb.sgttp.model.domain.trainUtilities;

import java.io.Serializable;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
/**
 * Representa un tren que puede transportar pasajeros y equipaje a través de diferentes rutas.
 */
public class Train implements Serializable{

    // Nombre del tren.
    private String trainName;
    
    // Identificación única del tren.
    private String trainId;
    
    // Kilómetros recorridos por el tren.
    private float kilometers;
    
    // Capacidad de carga del tren.
    private int loadingCapacity;
    
    // Marca del tren.
    private String brand;
    
    // Lista de vagones para pasajeros.
    private Array<CustomersWagon> customersWagons;
    
    // Lista de vagones para equipaje.
    private Array<LuggageWagon> luggageWagons;
    
    // Indica si el tren está disponible para ser utilizado.
    private boolean available;

    /**
     * Constructor de la clase Train.
     * 
     * @param trainName Nombre del tren.
     * @param trainId Identificación única del tren.
     * @param kilometers Kilómetros recorridos por el tren.
     * @param loadingCapacity Capacidad de carga del tren.
     * @param brand Marca del tren.
     * @param customersWagons Lista de vagones para pasajeros.
     * @param luggageWagons Lista de vagones para equipaje.
     * @param available Indica si el tren está disponible.
     */
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

    /**
     * Constructor de la clase Train con menos parámetros.
     * 
     * @param trainName Nombre del tren.
     * @param trainId Identificación única del tren.
     * @param kilometers Kilómetros recorridos por el tren.
     * @param brand Marca del tren.
     * @param customersWagons Cantidad de vagones para pasajeros.
     * @param available Indica si el tren está disponible.
     */
    public Train(String trainName, String trainId, float kilometers, String brand, int customersWagons, boolean available) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.kilometers = kilometers;
        setwagons(customersWagons);
        this.brand = brand;
        this.available = available;
    }
    /**
     * Comprueba si el tren está disponible.
     * 
     * @return Verdadero si el tren está disponible, falso de lo contrario.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Establece si el tren está disponible.
     * 
     * @param available Verdadero si el tren está disponible, falso de lo contrario.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Establece el nombre del tren.
     * 
     * @param trainName Nombre del tren.
     */
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    /**
     * Establece la identificación única del tren.
     * 
     * @param trainId Identificación única del tren.
     */
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    /**
     * Establece los kilómetros recorridos por el tren.
     * 
     * @param kilometers Kilómetros recorridos por el tren.
     */
    public void setKilometers(float kilometers) {
        this.kilometers = kilometers;
    }

    /**
     * Establece la capacidad de carga del tren.
     * 
     * @param loadingCapacity Capacidad de carga del tren.
     */
    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    /**
     * Establece la marca del tren.
     * 
     * @param brand Marca del tren.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Establece la lista de vagones para pasajeros.
     * 
     * @param customersWagons Lista de vagones para pasajeros.
     */
    public void setCustomersWagons(Array<CustomersWagon> customersWagons) {
        this.customersWagons = customersWagons;
    }

    /**
     * Establece la lista de vagones para equipaje.
     * 
     * @param luggageWagons Lista de vagones para equipaje.
     */
    public void setLuggageWagons(Array<LuggageWagon> luggageWagons) {
        this.luggageWagons = luggageWagons;
    }

    // Getters
    /**
     * Obtiene el nombre del tren.
     * 
     * @return El nombre del tren.
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * Obtiene la identificación única del tren.
     * 
     * @return La identificación única del tren.
     */
    public String getTrainId() {
        return trainId;
    }

    /**
     * Obtiene los kilómetros recorridos por el tren.
     * 
     * @return Los kilómetros recorridos por el tren.
     */
    public float getKilometers() {
        return kilometers;
    }

    /**
     * Obtiene la capacidad de carga del tren.
     * 
     * @return La capacidad de carga del tren.
     */
    public int getLoadingCapacity() {
        return loadingCapacity;
    }

    /**
     * Obtiene la marca del tren.
     * 
     * @return La marca del tren.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Obtiene la lista de vagones para pasajeros.
     * 
     * @return La lista de vagones para pasajeros.
     */
    public Array<CustomersWagon> getCustomersWagons() {
        return customersWagons;
    }

    /**
     * Obtiene la lista de vagones para equipaje.
     * 
     * @return La lista de vagones para equipaje.
     */
    public Array<LuggageWagon> getLuggageWagons() {
        return luggageWagons;
    }

    /**
     * Obtiene un objeto Train nulo.
     * 
     * @return Un objeto Train sin valores.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Train getNullTrain() {
        return new Train("", "", 0, 0, "", new Array(1), new Array(1), true);
    }

    /**
     * Devuelve una representación de cadena del objeto tren, que incluye su nombre, identificación, kilómetros recorridos, capacidad de carga, marca y detalles de los vagones de pasajeros y equipaje.
     * 
     * @return Una cadena que representa el objeto tren y sus atributos.
     */
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

    /**
     * Añade una cantidad específica de kilómetros a los kilómetros recorridos por el tren.
     * 
     * @param kilometers La cantidad de kilómetros a añadir.
     */
    public void addkilometers(int kilometers) {
        this.kilometers += kilometers;
    }

    /**
     * Calcula la capacidad de carga total del tren, incluyendo los vagones para pasajeros y equipaje.
     * 
     * @param nWagons El número total de vagones para pasajeros.
     * @return La capacidad de carga total del tren.
     */
    public Integer getLoadingCapacities(Integer nWagons) {
        Integer wagonsTotals = nWagons + luggagueWagon(nWagons);
        return wagonsTotals;
    }

    /**
     * Calcula el número de vagones para equipaje que necesita el tren, basándose en el número total de vagones para pasajeros.
     * 
     * @param nWagons El número total de vagones para pasajeros.
     * @return El número de vagones para equipaje necesarios.
     */
    public Integer luggagueWagon(Integer nWagons) {
        int luggagueWagon = nWagons / 2;
        return luggagueWagon;
    }

    /**
     * Configura los vagones del tren, tanto para pasajeros como para equipaje, basándose en el número total de vagones para pasajeros proporcionado.
     * 
     * @param vagonesPasajeros El número total de vagones para pasajeros.
     */
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
