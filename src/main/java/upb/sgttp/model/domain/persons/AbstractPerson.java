package upb.sgttp.model.domain.persons;

import java.io.Serializable;
import jp.array.Array;

/**
 * La clase AbstractPerson representa una persona abstracta con nombres, apellidos y números de teléfono.
 * Esta clase sirve como base para clases concretas de personas.
 */
public class AbstractPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    // Atributos
    private String names;
    private String lastNames;
    protected Array<String> phoneNumbers;

    // Constructores

    /**
     * Constructor por defecto de la clase AbstractPerson.
     * Inicializa los atributos con valores predeterminados.
     */
    public AbstractPerson() {
        this.names = "";
        this.lastNames = "";
        this.phoneNumbers = new Array<>(1);
    }

    /**
     * Constructor de la clase AbstractPerson con parámetros.
     * 
     * @param names       Los nombres de la persona.
     * @param lastNames   Los apellidos de la persona.
     * @param phoneNumbers Un Array de números de teléfono de la persona.
     */
    public AbstractPerson(String names, String lastNames, Array<String> phoneNumbers) {
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
    }

    // Métodos de acceso

    /**
     * Obtiene los nombres de la persona.
     * 
     * @return Los nombres de la persona.
     */
    public String getNames() {
        return names;
    }

    /**
     * Establece los nombres de la persona.
     * 
     * @param names Los nombres de la persona.
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * Obtiene los apellidos de la persona.
     * 
     * @return Los apellidos de la persona.
     */
    public String getLastNames() {
        return lastNames;
    }

    /**
     * Establece los apellidos de la persona.
     * 
     * @param lastNames Los apellidos de la persona.
     */
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    /**
     * Obtiene los números de teléfono de la persona.
     * 
     * @return Un Array de números de teléfono de la persona.
     */
    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Establece los números de teléfono de la persona.
     * 
     * @param phoneNumbers Un Array de números de teléfono de la persona.
     */
    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * Clona y retorna un objeto AbstractPerson con los mismos atributos.
     * 
     * @return Un nuevo objeto AbstractPerson clonado.
     */
    public AbstractPerson getPerson() {
        return new AbstractPerson(this.names, this.lastNames, this.getPhoneNumbers());
    }

    /**
     * Retorna una representación en cadena de caracteres de la persona.
     * 
     * @return Una cadena de caracteres que representa la persona.
     */
    @Override
    public String toString() {
        return "AbstractPerson{" + "names=" + names + ", lastNames=" + lastNames + ", phoneNumbers=" + phoneNumbers
                + '}';
    }
}
