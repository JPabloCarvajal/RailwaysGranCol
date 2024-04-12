package upb.sgttp.model.repository.Admins;

import jp.array.Array;
import upb.sgttp.model.domain.persons.AbstractPerson;

public class AdminEntity extends AbstractPerson{
    
    private String id;
    private final int type = 3;

    public AdminEntity() {
        id = "N/A";
    }

    public AdminEntity(String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public AdminEntity getNullAdmin() {
        return new AdminEntity();
    }

    public int getType() {
        return type;
    }
}
