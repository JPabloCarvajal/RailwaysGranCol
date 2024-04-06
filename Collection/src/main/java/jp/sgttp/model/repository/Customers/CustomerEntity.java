package jp.sgttp.model.repository.Customers;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;
import jp.sgttp.model.domain.persons.AbstractPerson;
import jp.sgttp.model.domain.persons.Customer;

public class CustomerEntity extends AbstractPerson {

    LinkedList<Luggage> luggages = new LinkedList<>();
    private final int type = 1;
    String customerId;

    public CustomerEntity(LinkedList<Luggage> luggage, String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        luggages.add(luggage);
        this.customerId = id;
    }

    public LinkedList<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(LinkedList<Luggage> luggages) {
        this.luggages = luggages;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public static Customer getNullCustomer() {
        return new Customer(null, "", "", null, "");
    }

    public int getType() {
        return type;
    }
}
