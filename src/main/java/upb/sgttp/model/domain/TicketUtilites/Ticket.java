package upb.sgttp.model.domain.TicketUtilites;

import java.io.Serializable;
import java.util.Date;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.RouteUtilities.CustomerRoute;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;

public class Ticket implements Serializable{
    
    private Customer customer; //

    private CustomerCategory customerCategory; //

    private String ticketId; //

    private Date purchaseDate; //

    private Date boardingDate; //

    private float value; //

    private Date arriveDate; //

    private Contact customerContact; //
        
    private StatusEnum status; //

    private LinkedList<CustomerRoute> customerRoute;

    private LinkedList<Station> stations;

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

    public LinkedList<CustomerRoute> getCustomerRoute() {
        return customerRoute;
    }

    public void setCustomerRoute(LinkedList<CustomerRoute> customerRoute) {
        this.customerRoute = customerRoute;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public LinkedList<Station> getStations() {
        return stations;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public void setBoardingDate(Date boardingDate) {
        this.boardingDate = boardingDate;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public void setCustomerCategory(CustomerCategory customerCategory) {
        this.customerCategory = customerCategory;
    }

    public void setCustomerContact(Contact customerContact) {
        this.customerContact = customerContact;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getBoardingDate() {
        return boardingDate;
    }

    public float getValue() {
        return value;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public CustomerCategory getCustomerCategory() {
        return customerCategory;
    }

    public Contact getCustomerContact() {
        return customerContact;
    }

    public StatusEnum getStatus() {
        return status;
    }
    
}
