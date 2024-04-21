package upb.sgttp.model.domain.trainUtilities;

import java.io.Serializable;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Luggage;

/**
 * Representa un vagón de equipaje que contiene una lista de equipajes, el peso total del vagón y la cantidad de equipajes.
 */
@SuppressWarnings("unused")
public class LuggageWagon extends Wagon implements Serializable{

    /**
     * Lista de equipajes en el vagón.
     */
    private LinkedList<Luggage> luggagesWagon;
    
    /**
     * Peso total del vagón.
     */
    private float wagonWeight;
    
    /**
     * Cantidad de equipajes en el vagón.
     */
    private int luggagesAmount;

    /**
     * Constructor de la clase LuggageWagon.
     * 
     * @param luggagesWagon La lista de equipajes en el vagón.
     * @param asociatedTrainID El ID del tren asociado.
     * @param wagonWeight El peso total del vagón.
     * @param luggagesAmount La cantidad de equipajes en el vagón.
     * @param wagonNum El número de vagón.
     */
    public LuggageWagon(LinkedList<Luggage> luggagesWagon,String asociatedTrainID, float wagonWeight, int luggagesAmount, int wagonNum) {
        super(wagonNum,asociatedTrainID);
        this.luggagesWagon = luggagesWagon;
        this.wagonWeight = wagonWeight;
        this.luggagesAmount = luggagesAmount;
    }

    /**
     * Obtiene la lista de equipajes en el vagón.
     * 
     * @return La lista de equipajes.
     */
    public LinkedList<Luggage> getLuggagesWagon() {
        return luggagesWagon;
    }

    /**
     * Obtiene el peso total del vagón.
     * 
     * @return El peso total del vagón.
     */
    public float getWagonWeight() {
        return wagonWeight;
    }

    /**
     * Obtiene la cantidad de equipajes en el vagón.
     * 
     * @return La cantidad de equipajes.
     */
    public int getLuggagesAmount() {
        return luggagesAmount;
    }

    /**
     * Establece la lista de equipajes en el vagón.
     * 
     * @param luggagesWagon La lista de equipajes a establecer.
     */
    public void setLuggagesWagon(LinkedList<Luggage> luggagesWagon) {
        this.luggagesWagon = luggagesWagon;
    }

    /**
     * Establece el peso total del vagón.
     * 
     * @param wagonWeight El peso total a establecer.
     */
    public void setWagonWeight(float wagonWeight) {
        this.wagonWeight = wagonWeight;
    }

    /**
     * Establece la cantidad de equipajes en el vagón.
     * 
     * @param luggagesAmount La cantidad de equipajes a establecer.
     */
    public void setLuggagesAmount(int luggagesAmount) {
        this.luggagesAmount = luggagesAmount;
    }

}
