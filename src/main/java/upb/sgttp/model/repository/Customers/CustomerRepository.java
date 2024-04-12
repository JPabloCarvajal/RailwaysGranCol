package upb.sgttp.model.repository.Customers;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class CustomerRepository {

    private FileJsonInterface<CustomerEntity> fileJson;
    private String pathFile;

    public CustomerRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addCustomer(Customer customer) {
        // Obtener todos los usuarios del archivo JSON
        CustomerEntity[] CustomerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        // Verificar si userEntities es null antes de continuar
        if (CustomerEntities == null) {
            CustomerEntities = new CustomerEntity[0]; // Si es null, asignamos un array vacío
        }

        // Crear una nueva instancia de UserEntity a partir del usuario proporcionado
        CustomerEntity newCustomerEntity = new CustomerEntity(
                customer.getLuggages(),
                customer.getNames(),
                customer.getLastNames(),
                customer.getPhoneNumbers(),
                customer.getCustomerId()
        );

        // Crear un nuevo array para almacenar todos los usuarios, incluido el nuevo usuario
        Array<CustomerEntity> updatedCustomerEntities = new Array<>(CustomerEntities.length + 1);
        for (CustomerEntity entity : CustomerEntities) {
            updatedCustomerEntities.add(entity);
        }
        updatedCustomerEntities.add(newCustomerEntity);

        // Convertir el Array<UserEntity> a un array regular de UserEntity[]
        CustomerEntity[] updatedUserEntitiesArray = new CustomerEntity[updatedCustomerEntities.size()];
        for (int i = 0; i < updatedCustomerEntities.size(); i++) {
            updatedUserEntitiesArray[i] = updatedCustomerEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    public boolean removeCustomer(int customerId) {
        // Obtener todos los clientes del archivo JSON
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        // Buscar el cliente con el ID especificado
        int indexToRemove = -1;
        for (int i = 0; i < customerEntities.length; i++) {
            if (customerEntities[i].getCustomerId().equals(customerId)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el cliente, eliminarlo y escribir de nuevo los clientes actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<CustomerEntity> updatedCustomerEntities = new Array<>(customerEntities.length - 1);
            for (int i = 0; i < customerEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedCustomerEntities.add(customerEntities[i]);
                }
            }

            CustomerEntity[] updatedCustomerEntitiesArray = new CustomerEntity[updatedCustomerEntities.size()];
            for (int i = 0; i < updatedCustomerEntities.size(); i++) {
                updatedCustomerEntitiesArray[i] = updatedCustomerEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedCustomerEntitiesArray);
        } else {
            // Si no se encontró el cliente con el ID especificado, devolver false
            return false;
        }
    }

    public boolean modifyCustomer(int customerId, Customer modifiedCustomer) {
        // Obtener todos los clientes del archivo JSON
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        // Buscar el cliente con el ID especificado
        int indexToModify = -1;
        for (int i = 0; i < customerEntities.length; i++) {
            if (customerEntities[i].getCustomerId().equals(customerId)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el cliente, modificarlo y escribir de nuevo los clientes actualizados en el archivo JSON
        if (indexToModify != -1) {
            customerEntities[indexToModify].setNames(modifiedCustomer.getNames());
            customerEntities[indexToModify].setLastNames(modifiedCustomer.getLastNames());
            customerEntities[indexToModify].setPhoneNumbers(modifiedCustomer.getPhoneNumbers());
            customerEntities[indexToModify].setCustomerId(modifiedCustomer.getCustomerId());

            return fileJson.writeObjects(pathFile, customerEntities);
        } else {
            // Si no se encontró el cliente con el ID especificado, devolver false
            return false;
        }
    }

    public LinkedList<Customer> getAllCustomersAsLinkedList() {
        // Obtener todos los clientes del archivo JSON
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        // Crear una lista enlazada para almacenar los clientes
        LinkedList<Customer> customerList = new LinkedList<>();

        // Agregar cada cliente a la lista enlazada
        for (CustomerEntity entity : customerEntities) {
            Customer customer = new Customer(
                    entity.getLuggages(),
                    entity.getNames(),
                    entity.getLastNames(),
                    entity.getPhoneNumbers(),
                    entity.getCustomerId()
            );
            customerList.add(customer);
        }

        return customerList;
    }

    public boolean modifyCustomers(LinkedList<Customer> modifiedCustomers) {
        // Obtener todos los clientes del archivo JSON
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        // Verificar si customerEntities es null antes de continuar
        if (customerEntities == null) {
            customerEntities = new CustomerEntity[0]; // Si es null, asignamos un array vacío
        }

        // Convertir la LinkedList de clientes modificados a un arreglo de CustomerEntity
        CustomerEntity[] modifiedCustomerEntities = new CustomerEntity[modifiedCustomers.size()];
        for (int i = 0; i < modifiedCustomers.size(); i++) {
            Customer customer = modifiedCustomers.get(i);
            modifiedCustomerEntities[i] = new CustomerEntity(
                    customer.getLuggages(),
                    customer.getNames(),
                    customer.getLastNames(),
                    customer.getPhoneNumbers(),
                    customer.getCustomerId()
            );
        }

        // Escribir los nuevos objetos en el archivo JSON (sobreescribir el archivo)
        return fileJson.writeObjects(pathFile, modifiedCustomerEntities);
    }
}
