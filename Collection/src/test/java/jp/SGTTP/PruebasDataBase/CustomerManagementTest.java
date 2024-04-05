package jp.SGTTP.PruebasDataBase;


import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.repository.Customers.CustomerRepository;
import jp.util.iterator.Iterator;

public class CustomerManagementTest {
    public static void main(String[] args) {

        String pathFile = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\customer.json";


        CustomerRepository customerRepository = new CustomerRepository(pathFile);

        try {
            // Luggage luggage,String names, String lastNames, Array<String> phoneNumbers
            Luggage luggage = new Luggage(001, 20.5f,1);
            LinkedList<Luggage> maletas = new LinkedList<>();
            maletas.add(luggage);
            maletas.add(luggage);
            Customer customer = new Customer(maletas,"popeye" , "Doe", new Array<>(new String[]{"123456789"}),123123);
            customerRepository.addCustomer(customer);

            // Eliminar un cliente existente
            int customerIdToRemove = 0; // Cambiar por el ID del cliente que deseas remover
            boolean removed = customerRepository.removeCustomer(customerIdToRemove);
            if (removed) {
                System.out.println("Customer removed successfully.");
            } else {
                System.out.println("Failed to remove customer with ID: " + customerIdToRemove);
            }

            // Modificar un  existente
            int customerIdToModify = 123123; // Cambiar por el ID del cliente que deseas modificar
            Luggage luggage2 = new Luggage(0021, 20.215f,2);
            LinkedList<Luggage> maletass = new LinkedList<>();
            maletas.add(luggage2);
            maletas.add(luggage2);
            Customer customerToModify = new Customer(maletass,"Jo22123hn" , "Do1232e", new Array<>(new String[]{"12341231256789"}),123);
            boolean modified = customerRepository.modifyCustomer(customerIdToModify, customerToModify);
            if (modified) {
                System.out.println("Customer modified successfully.");
            } else {
                System.out.println("Failed to modify customer with ID: " + customerIdToModify);
            }

            // Obtener todos los clientes como una lista enlazada y mostrarlos
            Iterator<Customer> iterator = customerRepository.getAllCustomersAsLinkedList().iterator();
            System.out.println("All customers:");
            while(iterator.hasNext()) {
                Customer temp = iterator.next();
                System.out.println(temp.getLuggages().toString()); 
                System.out.println(temp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


