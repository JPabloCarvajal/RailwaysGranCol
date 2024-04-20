package upb.sgttp.model.repository.Users;

import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Admin;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.model.domain.persons.User;

public class UserEntity {
    AbstractPerson person;
    String username;
    String password;
    int type;
    String id;
  
//    public UserEntity(AbstractPerson person, String username, String password,int type) {
//      this.person = person;
//      this.username = username;
//      this.password = password;
//      this.type = type;
//    }

    public UserEntity(AbstractPerson person, String username, String password, int type, String id) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.type = type;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}


