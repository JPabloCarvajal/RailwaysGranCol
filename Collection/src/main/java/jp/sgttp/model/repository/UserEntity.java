package jp.sgttp.model.repository;

public class UserEntity {
    String person;
    String username;
    String password;
    int type;
  
    public UserEntity(String person, String username, String password,int type) {
      this.person = person;
      this.username = username;
      this.password = password;
      this.type = type;
    }
}
