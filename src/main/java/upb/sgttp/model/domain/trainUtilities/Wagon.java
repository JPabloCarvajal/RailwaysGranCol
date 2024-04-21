package upb.sgttp.model.domain.trainUtilities;

import java.io.Serializable;

/**
 * Clase que representa un vagón en un tren.
 * 
 * Un vagón tiene un número único y está asociado a un tren mediante su identificación.
 */
public class Wagon implements Serializable{

    // Identificación del tren asociado al vagón
    private String asociatedTrainID;

    // Número único del vagón
    private int wagonNum;

    /**
     * Constructor de la clase Wagon.
     * 
     * @param wagonNum El número único del vagón.
     * @param asociatedTrainID La identificación del tren asociado al vagón.
     */
    public Wagon(int wagonNum, String asociatedTrainID){
        this.wagonNum = wagonNum;
        this.asociatedTrainID = asociatedTrainID;
    }

    /**
     * Obtiene la identificación del tren asociado al vagón.
     * 
     * @return La identificación del tren asociado al vagón.
     */
    public String getAsociatedTrainID() {
        return asociatedTrainID;
    }
    
    /**
     * Establece la identificación del tren asociado al vagón.
     * 
     * @param asociatedTrainID La identificación del tren asociado al vagón.
     */
    public void setAsociatedTrainID(String asociatedTrainID) {
        this.asociatedTrainID = asociatedTrainID;
    }

    /**
     * Obtiene el número único del vagón.
     * 
     * @return El número único del vagón.
     */
    public int getWagonNum() {
        return wagonNum;
    }

    /**
     * Establece el número único del vagón.
     * 
     * @param wagonNum El número único del vagón.
     */
    public void setWagonNum(int wagonNum) {
        this.wagonNum = wagonNum;
    }

}



