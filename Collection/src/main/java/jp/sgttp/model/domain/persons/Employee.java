package jp.sgttp.model.domain.persons;

import jp.array.Array;

public class Employee extends AbstractPerson {
    private String id;
  
    public Employee(String names, String lastNames, Array<String> phoneNumbers, String id) {
      super(names, lastNames, phoneNumbers);
      this.id = id;
    }
  
    public Employee(String id) {
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
}
