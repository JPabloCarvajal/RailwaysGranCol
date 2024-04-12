package upb.sgttp.model.domain.trainUtilities;

import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.Ticket;

public class CustomersWagon extends Wagon {

    private int standarAmount;
    private int executiveAmount;
    private int premiunAmount;
    private LinkedList<Ticket> customers;

    public CustomersWagon(int wagonNum,String asociatedTrainID, int standarAmount, int executiveAmount, int premiunAmount, LinkedList<Ticket> customers) {
        super(wagonNum,asociatedTrainID);
        this.standarAmount = standarAmount;
        this.premiunAmount = premiunAmount;
        this.executiveAmount = executiveAmount;
        this.customers = customers;
    }

    public int getStandarAmount() {
        return standarAmount;
    }

    public int getExecutiveAmount() {
        return executiveAmount;
    }

    public int getPremiunAmount() {
        return premiunAmount;
    }

    public LinkedList<Ticket> getCustomers() {
        return customers;
    }

    public void setStandarAmount(int standarAmount) {
        this.standarAmount = standarAmount;
    }

    public void setExecutiveAmount(int executiveAmount) {
        this.executiveAmount = executiveAmount;
    }

    public void setPremiunAmount(int premiunAmount) {
        this.premiunAmount = premiunAmount;
    }

    public void setCustomers(LinkedList<Ticket> customers) {
        this.customers = customers;
    }
}

