package upb.sgttp.model.domain.persons;

import jp.array.Array;
/**
 * La clase Admin representa a un administrador en el sistema. Un administrador es una persona con privilegios especiales
 * que puede realizar tareas administrativas dentro del sistema.
 */
public class Admin extends AbstractPerson {

    // Atributos específicos de la clase Admin
    private String id; // Identificación única del administrador
    private final int type = 3; // Tipo de usuario: 3 representa el tipo de administrador

    /**
     * Constructor por defecto de la clase Admin.
     * Crea un administrador con valores predeterminados para todos los atributos.
     */
    public Admin() {
        id = "N/A"; // Valor predeterminado para el ID del administrador
    }

    /**
     * Constructor de la clase Admin que inicializa todos los atributos.
     *
     * @param names         Nombres del administrador.
     * @param lastNames     Apellidos del administrador.
     * @param phoneNumbers  Números de teléfono del administrador.
     * @param id            Identificación única del administrador.
     */
    public Admin(String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        this.id = id;
    }

    /**
     * Método getter para obtener el ID del administrador.
     *
     * @return El ID del administrador.
     */
    public String getId() {
        return id;
    }

    /**
     * Método setter para establecer el ID del administrador.
     *
     * @param id El nuevo ID del administrador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método estático que devuelve un objeto Admin con valores predeterminados.
     *
     * @return Un objeto Admin con valores predeterminados.
     */
    public static Admin getNullAdmin() {
        return new Admin();
    }

    /**
     * Método getter para obtener el tipo de usuario.
     * El tipo de usuario 3 representa a un administrador.
     *
     * @return El tipo de usuario.
     */
    public int getType() {
        return type;
    }

}