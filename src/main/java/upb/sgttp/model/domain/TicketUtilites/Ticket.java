package upb.sgttp.model.domain.TicketUtilites;

import java.io.Serializable;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.CustomerRoute;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
/**
 * Representa un boleto de viaje en el sistema.
 */
public class Ticket implements Serializable{
    
    private Customer customer; // Cliente asociado al boleto

    private CustomerCategory customerCategory; // Categoría del cliente

    private String ticketId; // Identificador del boleto

    private Date purchaseDate; // Fecha de compra del boleto

    private Date boardingDate; // Fecha de embarque

    private float value; // Valor del boleto

    private Date arriveDate; // Fecha de llegada al destino

    private Contact customerContact; // Información de contacto del cliente
        
    private StatusEnum status; // Estado del boleto

    private LinkedList<CustomerRoute> customerRoute; // Rutas del cliente asociadas al boleto

    private LinkedList<Station> stations; // Estaciones incluidas en el boleto

    /**
     * Constructor de la clase Ticket.
     * 
     * @param customer Cliente asociado al boleto.
     * @param customerCategory Categoría del cliente.
     * @param ticketId Identificador del boleto.
     * @param purchaseDate Fecha de compra del boleto.
     * @param boardingDate Fecha de embarque.
     * @param arriveDate Fecha de llegada al destino.
     * @param value Valor del boleto.
     * @param customerContact Información de contacto del cliente.
     * @param status Estado del boleto.
     * @param customerRoute Rutas del cliente asociadas al boleto.
     * @param stations Estaciones incluidas en el boleto.
     */
    public Ticket(Customer customer, CustomerCategory customerCategory, String ticketId, Date purchaseDate, 
                  Date boardingDate,Date arriveDate, float value, Contact customerContact, StatusEnum status, 
                  LinkedList<CustomerRoute> customerRoute,LinkedList<Station> stations) {
        this.customer = customer;
        this.customerCategory = customerCategory;
        this.ticketId = ticketId;
        this.purchaseDate = purchaseDate;
        this.boardingDate = boardingDate;
        this.value = value;
        this.arriveDate = arriveDate;
        this.customerContact = customerContact;
        this.status = status;
        this.customerRoute = customerRoute;
        this.stations = stations;
    }

    /**
     * Obtiene la lista de rutas asociadas al cliente en el ticket.
     * 
     * @return La lista de rutas asociadas al cliente en el ticket.
     */
    public LinkedList<CustomerRoute> getCustomerRoute() {
        return customerRoute;
    }

    /**
     * Establece la lista de rutas asociadas al cliente en el ticket.
     * 
     * @param customerRoute La lista de rutas a establecer.
     */
    public void setCustomerRoute(LinkedList<CustomerRoute> customerRoute) {
        this.customerRoute = customerRoute;
    }

    /**
     * Establece el cliente asociado al ticket.
     * 
     * @param customer El cliente a establecer.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Establece el ID del ticket.
     * 
     * @param ticketId El ID del ticket a establecer.
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * Establece la fecha de compra del ticket.
     * 
     * @param purchaseDate La fecha de compra a establecer.
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Obtiene la lista de estaciones asociadas al ticket.
     * 
     * @return La lista de estaciones asociadas al ticket.
     */
    public LinkedList<Station> getStations() {
        return stations;
    }

    /**
     * Establece la lista de estaciones asociadas al ticket.
     * 
     * @param stations La lista de estaciones a establecer.
     */
    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    /**
     * Establece la fecha de embarque del ticket.
     * 
     * @param boardingDate La fecha de embarque a establecer.
     */
    public void setBoardingDate(Date boardingDate) {
        this.boardingDate = boardingDate;
    }

    /**
     * Establece el valor del ticket.
     * 
     * @param value El valor del ticket a establecer.
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Establece la fecha de llegada del ticket.
     * 
     * @param arriveDate La fecha de llegada a establecer.
     */
    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    /**
     * Establece la categoría de cliente del ticket.
     * 
     * @param customerCategory La categoría de cliente del ticket a establecer.
     */
    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

    /**
     * Establece el contacto del cliente asociado al ticket.
     * 
     * @param customerContact El contacto del cliente a establecer.
     */
    public void setCustomerContact(Contact customerContact) {
        this.customerContact = customerContact;
    }

    /**
     * Establece el estado del ticket.
     * 
     * @param status El estado del ticket a establecer.
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Obtiene el cliente asociado al ticket.
     * 
     * @return El cliente asociado al ticket.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Obtiene el ID del ticket.
     * 
     * @return El ID del ticket.
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Obtiene la fecha de compra del ticket.
     * 
     * @return La fecha de compra del ticket.
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Obtiene la fecha de embarque del ticket.
     * 
     * @return La fecha de embarque del ticket.
     */
    public Date getBoardingDate() {
        return boardingDate;
    }

    /**
     * Obtiene el valor del ticket.
     * 
     * @return El valor del ticket.
     */
    public float getValue() {
        return value;
    }

    /**
     * Obtiene la fecha de llegada del ticket.
     * 
     * @return La fecha de llegada del ticket.
     */
    public Date getArriveDate() {
        return arriveDate;
    }

    /**
     * Obtiene la categoría de cliente del ticket.
     * 
     * @return La categoría de cliente del ticket.
     */
    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    /**
     * Obtiene el contacto del cliente asociado al ticket.
     * 
     * @return El contacto del cliente asociado al ticket.
     */
    public Contact getCustomerContact() {
        return customerContact;
    }

    /**
     * Obtiene el estado del ticket.
     * 
     * @return El estado del ticket.
     */
    public StatusEnum getStatus() {
        return status;
    }
    
}
