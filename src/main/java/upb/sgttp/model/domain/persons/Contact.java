package upb.sgttp.model.domain.persons;

import java.io.Serializable;

import jp.array.Array;

/**
 * La clase Contact representa a una persona de contacto en el sistema para el cliente. Un contacto es una persona que puede ser
 * contactada por otros usuarios del sistema.
 */
@SuppressWarnings("unused")
public class Contact extends AbstractPerson implements Serializable {

    // Atributo específico de la clase Contact
    private final int type = 2; // Tipo de usuario: 2 representa el tipo de contacto

    private String contactId; // Identificación única del contacto

    /**
     * Constructor de la clase Contact que inicializa todos los atributos.
     *
     * @param names         Nombres del contacto.
     * @param lastNames     Apellidos del contacto.
     * @param phoneNumbers  Números de teléfono del contacto.
     * @param contactId     Identificación única del contacto.
     */
    public Contact(String names, String lastNames, Array<String> phoneNumbers, String contactId) {
        super(names, lastNames, phoneNumbers);
        this.contactId = contactId;
    }

    /**
     * Método getter para obtener la identificación del contacto.
     *
     * @return La identificación única del contacto.
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Método setter para establecer la identificación del contacto.
     *
     * @param contactId La nueva identificación del contacto.
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     * Método getter para obtener el tipo de usuario.
     * El tipo de usuario 2 representa a un contacto.
     *
     * @return El tipo de usuario.
     */
    public int getType() {
        return type;
    }

}
