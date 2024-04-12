package upb.sgttp.model.domain.persons;

import jp.array.Array;

public class Admin extends AbstractPerson {

    private String id;
    private final int type = 3;

    public Admin() {
        id = "N/A";
    }

    public Admin(String names, String lastNames, Array<String> phoneNumbers, String id) {
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

    public static Admin getNullAdmin() {
        return new Admin();
    }

    public int getType() {
        return type;
    }

}
