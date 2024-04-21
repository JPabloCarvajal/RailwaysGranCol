package upb.sgttp.model.domain.persons;

import java.io.Serializable;

/**
 * La clase User representa un usuario en el sistema.
 * Un usuario puede tener un perfil de persona asociado (un empleado o admin),
 * un nombre de usuario, una contraseña y un tipo de usuario.
 */
public class User implements Serializable {

    private AbstractPerson person; // El perfil de persona asociado al usuario
    private String username; // El nombre de usuario
    private String password; // La contraseña
    private int type; // El tipo de usuario

    /**
     * Constructor de la clase User que inicializa los atributos con valores predeterminados.
     */
    public User() {
        this.person = new AbstractPerson(); // Perfil de persona vacío por defecto
        this.username = "N/A"; // Nombre de usuario predeterminado
        this.password = "N/A"; // Contraseña predeterminada
        this.type = -1; // Tipo de usuario indefinido por defecto
    }

    /**
     * Constructor de la clase User que inicializa los atributos con los valores proporcionados.
     * @param person El perfil de persona asociado al usuario.
     * @param username El nombre de usuario.
     * @param password La contraseña.
     * @param type El tipo de usuario.
     */
    public User(AbstractPerson person, String username, String password, int type) {
        this.person = person;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * Método para obtener el perfil de persona asociado al usuario.
     * @return El perfil de persona asociado al usuario.
     */
    public AbstractPerson getPerson() {
        return person;
    }

    /**
     * Método para establecer el perfil de persona asociado al usuario.
     * @param person El perfil de persona a establecer.
     */
    public void setPerson(AbstractPerson person) {
        this.person = person;
    }

    /**
     * Método para obtener el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método para establecer el nombre de usuario.
     * @param username El nombre de usuario a establecer.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método para obtener la contraseña.
     * @return La contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método para establecer la contraseña.
     * @param password La contraseña a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método estático que devuelve una instancia de User con valores nulos.
     * @return Una instancia de User con valores nulos.
     */
    public static User getNullUser() {
        return new User(new AbstractPerson() {}, "", "", -1);
    }

    /**
     * Método para obtener el tipo de usuario.
     * @return El tipo de usuario.
     */
    public int getType() {
        return type;
    }

    /**
     * Método para establecer el tipo de usuario.
     * @param type El tipo de usuario a establecer.
     */
    public void setType(int type) {
        this.type = type;
    }

}
