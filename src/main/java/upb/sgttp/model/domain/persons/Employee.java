package upb.sgttp.model.domain.persons;

import jp.array.Array;

/**
 * La clase Employee representa a un empleado en el sistema.
 * Hereda de la clase AbstractPerson e incluye atributos específicos
 * como el ID del empleado y el tipo de persona.
 */
public class Employee extends AbstractPerson {

    private String id; // El ID del empleado
    private final int type = 0; // El tipo de persona, donde 0 representa un empleado

    /**
     * Constructor de la clase Employee que inicializa los atributos.
     * @param names Nombres del empleado.
     * @param lastNames Apellidos del empleado.
     * @param phoneNumbers Números de teléfono del empleado.
     * @param id ID único del empleado.
     */
    public Employee(String names, String lastNames, Array<String> phoneNumbers, String id) {
      super(names, lastNames, phoneNumbers);
      this.id = id;
    }
  
    /**
     * Método para obtener el tipo de persona.
     * @return El tipo de persona (en este caso, 0 para empleado).
     */
    public int getType() {
        return type;
    }
    
    /**
     * Método para obtener el ID del empleado.
     * @return El ID del empleado.
     */
    public String getId() {
      return id;
    }
  
    /**
     * Método para establecer el ID del empleado.
     * @param id El ID único del empleado.
     */
    public void setId(String id) {
      this.id = id;
    }
  
    /**
     * Método estático que devuelve una instancia de Employee con valores nulos.
     * @return Una instancia de Employee con valores nulos.
     */
    public static Employee getNullEmployee() {
      return new Employee("", "", new Array<>(new String[]{""}), "");
    }

    /**
     * Método para obtener los números de teléfono del empleado.
     * @return Los números de teléfono del empleado.
     */
    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Método para establecer los números de teléfono del empleado.
     * @param phoneNumbers Los números de teléfono del empleado.
     */
    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
