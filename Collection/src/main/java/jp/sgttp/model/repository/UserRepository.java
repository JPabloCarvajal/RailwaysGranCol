package jp.sgttp.model.repository;

import jp.sgttp.model.domain.persons.User;
import jp.sgttp.shared.filejsonadapter.FileJsonAdapter;
import jp.sgttp.shared.filejsonadapter.FileJsonInterface;

public class UserRepository {

  private FileJsonInterface<UserEntity> fileJson;
  private String pathFile;

  public UserRepository(String pathFile) {
    this.pathFile = pathFile;
    this.fileJson = FileJsonAdapter.getInstance();
  }

  public User getUser(String username) {
    UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
    EmployeeRepository employeeRepository = new EmployeeRepository("../../databas/employees.json");
    for (UserEntity userEntity : userEntities) {
      if (userEntity.username.equals(username)) {
        return new User(employeeRepository.getEmployee(userEntity.person), userEntity.username, userEntity.password);
      }
    }
    return User.getNullUser();
  }
  
}
