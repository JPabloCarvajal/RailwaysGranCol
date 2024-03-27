package jp.sgttp.model.domain.persons;

public class User {

    private AbstractPerson person;
    private String username;
    private String password;
    private final int type;
    public User(AbstractPerson person, String username, String password, int type) {
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
  
    
    
  }
