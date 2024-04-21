package upb.sgttp.model.domain;

import java.io.Serializable;
/**
 * Clase que representa el equipaje en un tren.
 * 
 * El equipaje tiene un identificador único, un peso y está asociado a un vagón.
 */
public class Luggage implements Serializable{
    
    // Identificador único para el equipaje
    private static int luggageId = 0;

    // Peso del equipaje
    private float weight;

    // Identificador del vagón asociado al equipaje
    private int wagonId;

    /**
     * Constructor de la clase Luggage.
     * 
     * Crea un equipaje con peso y vagón asociado.
     * Incrementa el identificador único de equipajes.
     * 
     * @param weight El peso del equipaje.
     * @param wagonId El identificador del vagón asociado al equipaje.
     */
    public Luggage(float weight, int wagonId){
        sumarId();
        this.weight = weight;
        this.wagonId = wagonId;
    }

    /**
     * Constructor de la clase Luggage.
     * 
     * Crea un equipaje nulo con identificador y peso predeterminados.
     */
    public Luggage(){
        sumarId();
        this.weight = -1;
        this.wagonId = -1;
    }

    /**
     * Incrementa el identificador único de equipajes.
     */
    @SuppressWarnings("static-access")
    private void sumarId(){
        this.luggageId ++;
    }

    /**
     * Obtiene el identificador único del equipaje.
     * 
     * @return El identificador único del equipaje.
     */
    public int getLuggageId() {
        return luggageId;
    }

    /**
     * Obtiene el identificador del vagón asociado al equipaje.
     * 
     * @return El identificador del vagón asociado al equipaje.
     */
    public int getWagonId() {
        return wagonId;
    }

    /**
     * Obtiene el peso del equipaje.
     * 
     * @return El peso del equipaje.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Establece el identificador único del equipaje.
     * 
     * @param luggageId El identificador único del equipaje.
     */
    @SuppressWarnings("static-access")
    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    /**
     * Establece el identificador del vagón asociado al equipaje.
     * 
     * @param wagonId El identificador del vagón asociado al equipaje.
     */
    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }

    /**
     * Establece el peso del equipaje.
     * 
     * @param weight El peso del equipaje.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Método estático para obtener un equipaje nulo.
     * 
     * @return Un equipaje nulo con identificador y peso predeterminados.
     */
    public static Luggage getNullLuggage(){
        return new Luggage();
    }
}
