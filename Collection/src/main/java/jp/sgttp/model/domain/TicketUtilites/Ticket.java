package jp.sgttp.model.domain.TicketUtilites;

import java.time.LocalTime;

import jp.queue.array.QueueArray;
import jp.sgttp.model.domain.RouteUtilities.Station;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.trainUtilities.Train;

public class Ticket {
    
    Customer customer;

    private int ticketId;
    private LocalTime purchaseDate;
    private LocalTime boardingDate;
    private QueueArray<Train> trains;
    private QueueArray<Station> stations;

    private float value;
    private LocalTime arriveDate;
    private LocalTime boardingHour;
    private LocalTime arriveHour;
    private CustomerCategory customerCategory;
    private Contact customerContact;
    private StatusEnum status;

    public Ticket(Customer customer, int ticketId, LocalTime purchaseDate, 
                  LocalTime boardingDate, QueueArray<Train> trains,QueueArray<Station> stations, 
                  float value, LocalTime arriveDate, LocalTime boardingHour, 
                  LocalTime arriveHour, CustomerCategory customerCategory, 
                  Contact customerContact, StatusEnum status) {
        this.customer = customer;
        this.ticketId = ticketId;
        this.purchaseDate = purchaseDate;
        this.boardingDate = boardingDate;
        this.trains = trains;
        this.value = value;
        this.arriveDate = arriveDate;
        this.boardingHour = boardingHour;
        this.arriveHour = arriveHour;
        this.customerCategory = customerCategory;
        this.customerContact = customerContact;
        this.status = status;
        this.stations = stations;
    }

    public QueueArray<Station> getStations() {
        return stations;
    }

    public void setStations(QueueArray<Station> stations) {
        this.stations = stations;
    }


    public LocalTime getBoardingHour() {
        return boardingHour;
    }

    public void setBoardingHour(LocalTime boardingHour) {
        this.boardingHour = boardingHour;
    }

    public LocalTime getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalTime arriveDate) {
        this.arriveDate = arriveDate;
    }

    public LocalTime getArriveHour() {
        return arriveHour;
    }

    public void setArriveHour(LocalTime arriveHour) {
        this.arriveHour = arriveHour;
    }

    public LocalTime getBoardingDate() {
        return boardingDate;
    }

    public void setBoardingDate(LocalTime boardingDate) {
        this.boardingDate = boardingDate;
    }

    public QueueArray<Train> getTrains() {
        return trains;
    }

    public void setTrains(QueueArray<Train> trains) {
        this.trains = trains;
    }

    public LocalTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalTime purchaseDate) {
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
