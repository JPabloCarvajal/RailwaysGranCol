package jp.sgttp.model.repository.Customers;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;
import jp.sgttp.model.domain.persons.AbstractPerson;

public class CustomerEntity extends AbstractPerson {
    
    LinkedList<Luggage> luggages = new LinkedList<>();
    int customerId;   

    public CustomerEntity(LinkedList<Luggage> luggage,String names, String lastNames, Array<String> phoneNumbers,int id){
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

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public static CustomerEntity getNullCustomer() {
      return new CustomerEntity(null,"","",null,-1);
    }

}
