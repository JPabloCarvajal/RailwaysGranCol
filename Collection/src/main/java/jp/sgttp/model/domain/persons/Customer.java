package jp.sgttp.model.domain.persons;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;

public class Customer extends AbstractPerson {

//    private static int nextId = jp.sgttp.model.domain.Main.getCustomers().getSize();

//    public static String generateNextId() {
//        String generatedId = "C" + nextId;
//        nextId++;
//        return generatedId;
//    }
    LinkedList<Luggage> luggages = new LinkedList<>();
    private final int type = 1;
    String customerId;   

    public Customer(LinkedList<Luggage> luggage,String names, String lastNames, Array<String> phoneNumbers, String id){
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
      return new Customer(null,"","",null,"");
    }

    public int getType() {
        return type;
    }
}
