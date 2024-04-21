package upb.sgttp.model.domain.trainUtilities;

import java.io.Serializable;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.Ticket;

/**
 * Representa un vagón de clientes, que contiene información sobre la cantidad de clientes en cada categoría (estándar, ejecutivo, premium)
 * y una lista de los tickets de los clientes en el vagón.
 */
@SuppressWarnings("unused")
public class CustomersWagon extends Wagon implements Serializable {

    /**
     * Cantidad de asientos estándar en el vagón.
     */
    private int standarAmount;
    
    /**
     * Cantidad de asientos ejecutivos en el vagón.
     */
    private int executiveAmount;
    
    /**
     * Cantidad de asientos premium en el vagón.
     */
    private int premiunAmount;
    
    /**
     * Lista de tickets de los clientes en el vagón.
     */
    private LinkedList<Ticket> customers;

    /**
     * Constructor de la clase CustomersWagon.
     * 
     * @param wagonNum El número de vagón.
     * @param asociatedTrainID El ID del tren asociado.
     * @param standarAmount La cantidad de asientos estándar.
     * @param executiveAmount La cantidad de asientos ejecutivos.
     * @param premiunAmount La cantidad de asientos premium.
     * @param customers La lista de tickets de los clientes en el vagón.
     */
    public CustomersWagon(int wagonNum,String asociatedTrainID, int standarAmount, int executiveAmount, int premiunAmount, LinkedList<Ticket> customers) {
        super(wagonNum,asociatedTrainID);
        this.standarAmount = standarAmount;
        this.premiunAmount = premiunAmount;
        this.executiveAmount = executiveAmount;
        this.customers = customers;
    }

    /**
     * Obtiene la cantidad de asientos estándar en el vagón.
     * 
     * @return La cantidad de asientos estándar.
     */
    public int getStandarAmount() {
        return standarAmount;
    }

    /**
     * Obtiene la cantidad de asientos ejecutivos en el vagón.
     * 
     * @return La cantidad de asientos ejecutivos.
     */
    public int getExecutiveAmount() {
        return executiveAmount;
    }

    /**
     * Obtiene la cantidad de asientos premium en el vagón.
     * 
     * @return La cantidad de asientos premium.
     */
    public int getPremiunAmount() {
        return premiunAmount;
    }

    /**
     * Obtiene la lista de tickets de los clientes en el vagón.
     * 
     * @return La lista de tickets de los clientes.
     */
    public LinkedList<Ticket> getCustomers() {
        return customers;
    }

    /**
     * Establece la cantidad de asientos estándar en el vagón.
     * 
     * @param standarAmount La cantidad de asientos estándar a establecer.
     */
    public void setStandarAmount(int standarAmount) {
        this.standarAmount = standarAmount;
    }

    /**
     * Establece la cantidad de asientos ejecutivos en el vagón.
     * 
     * @param executiveAmount La cantidad de asientos ejecutivos a establecer.
     */
    public void setExecutiveAmount(int executiveAmount) {
        this.executiveAmount = executiveAmount;
    }

    /**
     * Establece la cantidad de asientos premium en el vagón.
     * 
     * @param premiunAmount La cantidad de asientos premium a establecer.
     */
    public void setPremiunAmount(int premiunAmount) {
        this.premiunAmount = premiunAmount;
    }

    /**
     * Establece la lista de tickets de los clientes en el vagón.
     * 
     * @param customers La lista de tickets de los clientes a establecer.
     */
    public void setCustomers(LinkedList<Ticket> customers) {
        this.customers = customers;
    }
}