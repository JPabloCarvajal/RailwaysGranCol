package jp.sgttp.model.domain.TicketUtilites;

import java.time.LocalTime;
import java.util.Date;

import jp.queue.array.QueueArray;
import jp.sgttp.model.domain.RouteUtilities.Route;
import jp.sgttp.model.domain.RouteUtilities.Station;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.trainUtilities.Train;

public class Ticket {
    Customer customer;

    private int ticketId;
    private String purchaseDate;
    private String boardingDate;
    private Route route;
    private float value;
    private String arriveDate;
    private String boardingHour;
    private String arriveHour;
    private CustomerCategory customerCategory;
    private Contact customerContact;
    private StatusEnum status;


    
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getBoardingHour() {
        return boardingHour;
    }

    public void setBoardingHour(String boardingHour) {
        this.boardingHour = boardingHour;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getArriveHour() {
        return arriveHour;
    }

    public void setArriveHour(String arriveHour) {
        this.arriveHour = arriveHour;
    }

    public String getBoardingDate() {
        return boardingDate;
    }

    public void setBoardingDate(String boardingDate) {
        this.boardingDate = boardingDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setValue(float value) {
        this.value = value;
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

    public int getTicketId() {
        return ticketId;
    }

    public float getValue() {
        return value;
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

    public float totalTravelValue(float km) {
        switch (customerCategory) {
            case EXECUTIVE:
                return km * 1200;
            case STANDARD:
                return km * 1000;
            case PREMIUM:
                return km * 1800;
            default:
                return -1f;
        }
    }
    
}
