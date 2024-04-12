package upb.sgttp.model.domain.persons;

import jp.array.Array;

public class Employee extends AbstractPerson {
    private String id;
    private final int type = 0;

    public int getType() {
        return type;
    }
    public Employee(String names, String lastNames, Array<String> phoneNumbers, String id) {
      super(names, lastNames, phoneNumbers);
      this.id = id;
    }
  
    public String getId() {
      return id;
    }
  
    public void setId(String id) {
      this.id = id;
    }
  
    public static Employee getNullEmployee() {
      return new Employee("", "", new Array<>(new String[]{""}), "");
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
