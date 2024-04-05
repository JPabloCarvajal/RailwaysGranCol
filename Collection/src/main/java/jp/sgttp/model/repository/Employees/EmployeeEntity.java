package jp.sgttp.model.repository.Employees;

import jp.array.Array;
import jp.sgttp.model.domain.persons.AbstractPerson;

public class EmployeeEntity extends AbstractPerson {
    private String id;

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
}
