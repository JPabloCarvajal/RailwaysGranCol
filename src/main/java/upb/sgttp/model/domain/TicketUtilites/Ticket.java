package upb.sgttp.model.domain.TicketUtilites;

import java.util.Date;

import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.trainUtilities.Train;

public class Ticket {
    
    Customer customer;
    private int ticketId;
    private Date purchaseDate;
    private Date boardingDate;
    private Train train;
    private float value;
    private Date arriveDate;
    private String boardingHour;
    private String arriveHour;
    private CustomerCategory customerCategory;
    private Contact customerContact;
    private StatusEnum status;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setBoardingDate(Date boardingDate) {
        this.boardingDate = boardingDate;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public void setBoardingHour(String boardingHour) {
        this.boardingHour = boardingHour;
    }

    public void setArriveHour(String arriveHour) {
        this.arriveHour = arriveHour;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getBoardingDate() {
        return boardingDate;
    }

    public Train getTrain() {
        return train;
    }

    public float getValue() {
        return value;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public String getBoardingHour() {
        return boardingHour;
    }

    public String getArriveHour() {
        return arriveHour;
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
