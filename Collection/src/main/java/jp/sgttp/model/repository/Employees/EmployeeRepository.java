package jp.sgttp.model.repository.Employees;

import jp.array.Array;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.shared.filejsonadapter.FileJsonAdapter;
import jp.sgttp.shared.filejsonadapter.FileJsonInterface;

public class EmployeeRepository {

  private FileJsonInterface<EmployeeEntity> fileJson;
  private String pathFile;

  public EmployeeRepository(String pathFile) {
    this.pathFile = pathFile;
    this.fileJson = FileJsonAdapter.getInstance();
  }

  public Employee getEmployee(String id) {
    EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
    for (EmployeeEntity employeeEntity : employeeEntities) {
      if (employeeEntity.id.equals(id)) {
        return new Employee(
            employeeEntity.names,
            employeeEntity.lastNames,
            new Array<>(employeeEntity.phoneNumbers.split(",")),
            employeeEntity.id);
      }
    }
    return Employee.getNullEmployee();
  }
}
