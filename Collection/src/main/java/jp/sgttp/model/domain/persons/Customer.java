package jp.sgttp.model.domain.persons;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;


//tolis
public class Customer extends AbstractPerson {

    LinkedList<Luggage> luggages = new LinkedList<>();
    private final int type = 1;
    int customerId;   

    public Customer(Luggage luggage,String names, String lastNames, Array<String> phoneNumbers){
        super(names, lastNames, phoneNumbers);
        luggages.add(luggage);
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

    public static Customer getNullCustomer() {
      return new Customer(null,"","",null);
    }

    public int getType() {
        return type;
    }


}
