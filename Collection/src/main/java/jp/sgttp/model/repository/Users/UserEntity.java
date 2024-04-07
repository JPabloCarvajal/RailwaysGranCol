package jp.sgttp.model.repository.Users;

import jp.sgttp.model.domain.persons.AbstractPerson;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.model.domain.persons.User;

public class UserEntity {
    AbstractPerson person;
    String username;
    String password;
    int type;
  
    public UserEntity(AbstractPerson person, String username, String password,int type) {
      this.person = person;
      this.username = username;
      this.password = password;
      this.type = type;
    }

    public AbstractPerson getPerson() {
      return person;
    }
    public void setPerson(AbstractPerson person) {
      this.person = person;
    }

    public String getUsername() {
      return username;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
  
    public static User getNullUser() {
      return new User(new AbstractPerson(){}, "", "",-1);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
