package upb.sgttp.model.repository.Contacts;

import java.io.Serializable;

import jp.array.Array;
import upb.sgttp.model.domain.persons.AbstractPerson;

@SuppressWarnings("unused")
public class ContactEntity extends AbstractPerson implements Serializable{
    
    String contactId;

    public ContactEntity(String names, String lastNames, Array<String> phoneNumbers,String contactId) {
        super(names, lastNames, phoneNumbers);
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
