package upb.sgttp.model.repository.Employees;

import java.io.Serializable;

import jp.array.Array;
import upb.sgttp.model.domain.persons.AbstractPerson;

public class EmployeeEntity extends AbstractPerson implements Serializable{

    private String id;
    private final int type = 0;

    public int getType() {
        return type;
    }

    public EmployeeEntity(String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static EmployeeEntity getNullEmployee() {
        return new EmployeeEntity("", "", new Array<>(new String[]{""}), "");
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
