package upb.sgttp.model.domain.persons;

import java.io.Serializable;

import jp.array.Array;

//tolis
public class Contact extends AbstractPerson implements Serializable{
    private final int type = 2;

    private String contactId;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Contact(String names, String lastNames, Array<String> phoneNumbers,String contactId) {
        super(names, lastNames, phoneNumbers);
        this.contactId = contactId;
    }

    public int getType() {
        return type;
    }

    public static void main(String[] args) {
        Array<String> phoneNumbers = new Array<>(2);
        phoneNumbers.add("1234567890");
        phoneNumbers.add("0987654321");
        System.out.println(phoneNumbers.toStringg());
        Contact contact = new Contact("Tolis","Kalkounis",new Array<>(2), "1");
        System.out.println(contact.getNames());
        System.out.println(contact.getLastNames());
        System.out.println(contact.getContactId());
    }
    
}
