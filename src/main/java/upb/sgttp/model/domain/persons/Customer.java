 package upb.sgttp.model.domain.persons;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.Luggage;

/**
 * La clase Customer representa a un cliente en el sistema. Un cliente es una persona que utiliza los servicios
 * ofrecidos por la empresa.
 */
public class Customer extends AbstractPerson {

    // Atributos específicos de la clase Customer
    LinkedList<Luggage> luggages = new LinkedList<>(); // Lista de equipajes del cliente
    private final int type = 1; // Tipo de usuario: 1 representa el tipo de cliente
    String customerId; // Identificación única del cliente

    /**
     * Constructor de la clase Customer que inicializa todos los atributos.
     *
     * @param luggage      Lista de equipajes del cliente.
     * @param names        Nombres del cliente.
     * @param lastNames    Apellidos del cliente.
     * @param phoneNumbers Números de teléfono del cliente.
     * @param id           Identificación única del cliente.
     */
    public Customer(LinkedList<Luggage> luggage, String names, String lastNames, Array<String> phoneNumbers, String id) {
        super(names, lastNames, phoneNumbers);
        luggages.add(luggage);
        this.customerId = id;
    }

    /**
     * Método getter para obtener la lista de equipajes del cliente.
     *
     * @return La lista de equipajes del cliente.
     */
    public LinkedList<Luggage> getLuggages() {
        return luggages;
    }

    /**
     * Método setter para establecer la lista de equipajes del cliente.
     *
     * @param luggages La nueva lista de equipajes del cliente.
     */
    public void setLuggages(LinkedList<Luggage> luggages) {
        this.luggages = luggages;
    }

    /**
     * Método getter para obtener la identificación del cliente.
     *
     * @return La identificación única del cliente.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Método setter para establecer la identificación del cliente.
     *
     * @param customerId La nueva identificación del cliente.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Método estático para obtener una instancia de Customer con valores nulos.
     *
     * @return Una instancia de Customer con valores nulos.
     */
    public static Customer getNullCustomer() {
        return new Customer(null, "", "", null, "");
    }

    /**
     * Método getter para obtener el tipo de usuario.
     * El tipo de usuario 1 representa a un cliente.
     *
     * @return El tipo de usuario.
     */
    public int getType() {
        return type;
    }
}
