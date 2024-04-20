package upb.sgttp.model.domain.persons;

import java.io.Serializable;

public class User implements Serializable {

    private AbstractPerson person;
    private String username;
    private String password;
    private int type;

    public User() {
        this.person = new AbstractPerson();
        this.username = "N/A";
        this.password = "N/A";
        this.type = -1;
    }

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
        return new User(new AbstractPerson() {
        }, "", "", -1);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
