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
        CustomerEntity[] CustomerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        if (CustomerEntities == null) {
            CustomerEntities = new CustomerEntity[0];
        }

        CustomerEntity newCustomerEntity = new CustomerEntity(
                customer.getLuggages(),
                customer.getNames(),
                customer.getLastNames(),
                customer.getPhoneNumbers(),
                customer.getCustomerId()
        );

        Array<CustomerEntity> updatedCustomerEntities = new Array<>(CustomerEntities.length + 1);
        for (CustomerEntity entity : CustomerEntities) {
            updatedCustomerEntities.add(entity);
        }
        updatedCustomerEntities.add(newCustomerEntity);

        CustomerEntity[] updatedUserEntitiesArray = new CustomerEntity[updatedCustomerEntities.size()];
        for (int i = 0; i < updatedCustomerEntities.size(); i++) {
            updatedUserEntitiesArray[i] = updatedCustomerEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
    }

    public boolean removeCustomer(String customerId) {
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        int indexToRemove = -1;
        for (int i = 0; i < customerEntities.length; i++) {
            if (customerEntities[i].getCustomerId().equals(customerId)) {
                indexToRemove = i;
                break;
            }
        }

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
            return false;
        }
    }

    public boolean modifyCustomer(int customerId, Customer modifiedCustomer) {
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        int indexToModify = -1;
        for (int i = 0; i < customerEntities.length; i++) {
            if (customerEntities[i].getCustomerId().equals(customerId)) {
                indexToModify = i;
                break;
            }
        }

        if (indexToModify != -1) {
            customerEntities[indexToModify].setNames(modifiedCustomer.getNames());
            customerEntities[indexToModify].setLastNames(modifiedCustomer.getLastNames());
            customerEntities[indexToModify].setPhoneNumbers(modifiedCustomer.getPhoneNumbers());
            customerEntities[indexToModify].setCustomerId(modifiedCustomer.getCustomerId());

            return fileJson.writeObjects(pathFile, customerEntities);
        } else {
            return false;
        }
    }

    public LinkedList<Customer> getAllCustomersAsLinkedList() {
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        LinkedList<Customer> customerList = new LinkedList<>();

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
        CustomerEntity[] customerEntities = fileJson.getObjects(pathFile, CustomerEntity[].class);

        if (customerEntities == null) {
            customerEntities = new CustomerEntity[0];
        }

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

        return fileJson.writeObjects(pathFile, modifiedCustomerEntities);
    }
}
