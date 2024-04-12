package upb.sgttp.model.domain.persons;

import jp.array.Array;

//tolis
public class Contact extends AbstractPerson{
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
    
}
