package upb.sgttp.model.repository.Users;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Admin;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.model.domain.persons.User;
import upb.sgttp.model.repository.Admins.AdminRepository;
import upb.sgttp.model.repository.Contacts.ContactRepository;
import upb.sgttp.model.repository.Customers.CustomerRepository;
import upb.sgttp.model.repository.Employees.EmployeeRepository;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class UserRepository {

    private FileJsonInterface<UserEntity> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

//    public boolean addUser(User user) {
//        // Obtener todos los usuarios del archivo JSON
//        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//        // Verificar si userEntities es null antes de continuar
//        if (userEntities == null) {
//            userEntities = new UserEntity[0]; // Si es null, asignamos un array vacío
//        }
//
//        // Crear una nueva instancia de UserEntity a partir del usuario proporcionado
//        UserEntity newUserEntity = new UserEntity(
//                user.getPerson(),
//                user.getUsername(),
//                user.getPassword(),
//                user.getType()
//        );
//
//        // Crear un nuevo array para almacenar todos los usuarios, incluido el nuevo usuario
//        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length + 1);
//        for (UserEntity entity : userEntities) {
//            updatedUserEntities.add(entity);
//        }
//        updatedUserEntities.add(newUserEntity);
//
//        // Convertir el Array<UserEntity> a un array regular de UserEntity[]
//        UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
//        for (int i = 0; i < updatedUserEntities.size(); i++) {
//            updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
//        }
//
//        return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
//    }
//    public boolean addUser(User user) {
//        // Obtener todos los usuarios del archivo JSON
//        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//        // Verificar si userEntities es null antes de continuar
//        if (userEntities == null) {
//            userEntities = new UserEntity[0]; // Si es null, asignamos un array vacío
//        }
//
//        // Crear una nueva instancia de UserEntity a partir del usuario proporcionado
//        UserEntity newUserEntity = new UserEntity(
//                user.getPerson() instanceof Employee ? (Employee) user.getPerson() : null,
//                user.getUsername(),
//                user.getPassword(),
//                user.getType()
//        );
//
//        // Crear un nuevo array para almacenar todos los usuarios, incluido el nuevo usuario
//        Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length + 1);
//        for (UserEntity entity : userEntities) {
//            updatedUserEntities.add(entity);
//        }
//        updatedUserEntities.add(newUserEntity);
//
//        // Convertir el Array<UserEntity> a un array regular de UserEntity[]
//        // ...
//        return false;
//    }
    //-----------------------------------------------------------------------------------------
    public boolean addUser(User user) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Verificar si userEntities es null antes de continuar
        if (userEntities == null) {
            userEntities = new UserEntity[0]; // Si es null, asignamos un array vacío
        }
        String id = "";
        switch (user.getType()) {
            case 0:
                Employee employee = (Employee) user.getPerson();
                id = employee.getId();
                break;
            case 1:
                Customer customer = (Customer) user.getPerson();
                id = customer.getCustomerId();
                break;
            case 2:
                Contact contact = (Contact) user.getPerson();
                id = contact.getContactId();
                break;
            case 3:
                Admin admin = (Admin) user.getPerson();
                id = admin.getId();
                break;
        }
        // Crear una nueva instancia de UserEntity a partir del usuario proporcionado
        AbstractPerson person = user.getPerson();
        UserEntity newUserEntity;
        if (person instanceof Employee) {
            newUserEntity = new UserEntity((Employee) person, user.getUsername(), user.getPassword(), user.getType(), id);
        } else if (person instanceof Customer) {
            newUserEntity = new UserEntity((Customer) person, user.getUsername(), user.getPassword(), user.getType(), id);
        } else if (person instanceof Contact) {
            newUserEntity = new UserEntity((Contact) person, user.getUsername(), user.getPassword(), user.getType(), id);
        } else if (person instanceof Admin) {
            newUserEntity = new UserEntity((Admin) person, user.getUsername(), user.getPassword(), user.getType(), id);
        } else {
            // Handle unsupported person type
            return false;
        }

        // Crear un nuevo array para almacenar todos los usuarios, incluido el nuevo usuario
        UserEntity[] newUserEntities = new UserEntity[userEntities.length + 1];
        System.arraycopy(userEntities, 0, newUserEntities, 0, userEntities.length);
        newUserEntities[newUserEntities.length - 1] = newUserEntity;

        // Escribir el nuevo array en el archivo JSON
        fileJson.writeObjects(pathFile, newUserEntities);

        return true; // Devolver true si se añadió correctamente
    }

    public boolean removeUser(String username) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Buscar el usuario con el nombre de usuario especificado
        int indexToRemove = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el usuario, eliminarlo y escribir de nuevo los usuarios actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length - 1);
            for (int i = 0; i < userEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedUserEntities.add(userEntities[i]);
                }
            }

            UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
            for (int i = 0; i < updatedUserEntities.size(); i++) {
                updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
        } else {
            // Si no se encontró el usuario con el nombre de usuario especificado, devolver false
            return false;
        }
    }

    public boolean removeUserById(String id) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Buscar el usuario con el nombre de usuario especificado
        int indexToRemove = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getId().equals(id)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el usuario, eliminarlo y escribir de nuevo los usuarios actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<UserEntity> updatedUserEntities = new Array<>(userEntities.length - 1);
            for (int i = 0; i < userEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedUserEntities.add(userEntities[i]);
                }
            }

            UserEntity[] updatedUserEntitiesArray = new UserEntity[updatedUserEntities.size()];
            for (int i = 0; i < updatedUserEntities.size(); i++) {
                updatedUserEntitiesArray[i] = updatedUserEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedUserEntitiesArray);
        } else {
            // Si no se encontró el usuario con el nombre de usuario especificado, devolver false
            return false;
        }
    }
//    public boolean removeUserById(String id) {
//        // Obtener todos los usuarios del archivo JSON
//        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//        // Imprimir el ID que estamos buscando
//        System.out.println("Buscando usuario con ID: " + id);
//
//        // Buscar el usuario con el ID especificado
//        int indexToRemove = -1;
//        for (int i = 0; i < userEntities.length; i++) {
//            if (userEntities[i].getId().equals(id)) {
//                indexToRemove = i;
//                System.out.println("Usuario encontrado en el índice: " + i);
//                break;
//            }
//        }
//
//        // Si se encontró el usuario, eliminarlo y escribir los usuarios actualizados en el archivo JSON
//        if (indexToRemove != -1) {
//            System.out.println("Eliminando usuario...");
//            UserEntity[] updatedUserEntities = new UserEntity[userEntities.length - 1];
//            for (int i = 0, j = 0; i < userEntities.length; i++) {
//                if (i != indexToRemove) {
//                    updatedUserEntities[j++] = userEntities[i];
//                }
//            }
//            System.out.println("Usuario eliminado.");
//            // Imprimir el contenido del array de entidades de usuario antes de la eliminación
//            System.out.println("Contenido antes de la eliminación:");
//            for (UserEntity entity : userEntities) {
//                System.out.println(entity.getId());
//            }
//            // Imprimir el contenido del array de entidades de usuario después de la eliminación
//            System.out.println("Contenido después de la eliminación:");
//            for (UserEntity entity : updatedUserEntities) {
//                System.out.println(entity.getId());
//            }
//            return fileJson.writeObjects(pathFile, updatedUserEntities);
//        } else {
//            // Si no se encontró el usuario, devolver false
//            System.out.println("Usuario no encontrado.");
//            return false;
//        }
//    }

    public boolean modifyUser(String username, User modifiedUser) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Buscar el usuario con el nombre de usuario especificado
        int indexToModify = -1;
        for (int i = 0; i < userEntities.length; i++) {
            if (userEntities[i].getUsername().equals(username)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el usuario, modificarlo y escribir de nuevo los usuarios actualizados en el archivo JSON
        if (indexToModify != -1) {
            userEntities[indexToModify].setPerson(modifiedUser.getPerson());
            userEntities[indexToModify].setUsername(modifiedUser.getUsername());
            userEntities[indexToModify].setPassword(modifiedUser.getPassword());
            userEntities[indexToModify].setType(modifiedUser.getType());

            return fileJson.writeObjects(pathFile, userEntities);
        } else {
            // Si no se encontró el usuario con el nombre de usuario especificado, devolver false
            return false;
        }
    }
//    public boolean modifyUser(String username, User modifiedUser) {
//     Obtener todos los usuarios del archivo JSON
//    UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//     Buscar el usuario con el nombre de usuario especificado
//    for (int i = 0; i < userEntities.length; i++) {
//        if (userEntities[i].getUsername().equals(username)) {
//             Reemplazar el usuario existente con el usuario modificado
//            userEntities[i] = convertToUserEntity(modifiedUser);
//            
//             Escribir de nuevo los usuarios actualizados en el archivo JSON
//            return fileJson.writeObjects(pathFile, userEntities);
//        }
//    }
//
//     Si no se encontró el usuario con el nombre de usuario especificado, devolver false
//    return false;
//}
// Método para convertir un objeto User a un objeto UserEntity

//    public LinkedList<User> getAllUsersAsLinkedList() {
//        // Obtener todos los usuarios del archivo JSON
//        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//        // Crear una lista enlazada para almacenar los usuarios
//        LinkedList<User> userList = new LinkedList<>();
//
//        // Agregar cada usuario a la lista enlazada
//        for (UserEntity entity : userEntities) {
//            User user = new User(
//                    entity.getPerson(),
//                    entity.getUsername(),
//                    entity.getPassword(),
//                    entity.getType()
//            );
//            userList.add(user);
//        }
//
//        return userList;
//    }
//    public LinkedList<User> getAllUsersAsLinkedList() {
//    // Obtener todos los usuarios del archivo JSON
//    UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//    // Verificar si userEntities es null antes de continuar
//    if (userEntities == null) {
//        return new LinkedList<>(); // Si es null, devolvemos una LinkedList vacía
//    }
//
//    // Crear una nueva LinkedList de User
//    LinkedList<User> users = new LinkedList<>();
//
//    // Iterar sobre cada UserEntity en el array de usuarios
//    for (int i = 0; i < userEntities.length; i++) {
//        UserEntity entity = userEntities[i];
//
//        // Crear un nuevo User a partir de cada UserEntity
//        User user = new User(
//                entity.getPerson(),
//                entity.getUsername(),
//                entity.getPassword(),
//                entity.getType()
//        );
//
//        // Verificar el tipo de Person y hacer un casting al tipo correspondiente
//        if (user.getPerson() instanceof Admin) {
//            user.setPerson((Admin) user.getPerson());
//        } else if (user.getPerson() instanceof Employee) {
//            user.setPerson((Employee) user.getPerson());
//        } else if (user.getPerson() instanceof Contact) {
//            user.setPerson((Contact) user.getPerson());
//        } else if (user.getPerson() instanceof Customer) {
//            user.setPerson((Customer) user.getPerson());
//        }
//
//        // Agregar el nuevo User a la LinkedList
//        users.add(user);
//    }
//
//    // Devolver la LinkedList de User
//    return users;
//}
//    public LinkedList<User> getAllUsersAsLinkedList() {
//        // Obtener todos los usuarios del archivo JSON
//        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);
//
//        // Verificar si userEntities es null antes de continuar
//        if (userEntities == null) {
//            return new LinkedList<>(); // Si es null, devolvemos una LinkedList vacía
//        }
//
//        // Crear una nueva LinkedList de User
//        LinkedList<User> users = new LinkedList<>();
//
//        // Iterar sobre cada UserEntity en el array de usuarios
//        for (int i = 0; i < userEntities.length; i++) {
//            UserEntity entity = userEntities[i];
//
//            // Crear un nuevo User a partir de cada UserEntity
//            User user = new User(
//                    entity.getPerson(),
//                    entity.getUsername(),
//                    entity.getPassword(),
//                    entity.getType()
//            );
//
//            // Verificar el tipo de Person y hacer un casting al tipo correspondiente
//            if (user.getPerson() instanceof Admin) {
//                user.setPerson((Admin) user.getPerson());
//            } else if (user.getPerson() instanceof Employee) {
//                user.setPerson((Employee) user.getPerson());
//            } else if (user.getPerson() instanceof Contact) {
//                user.setPerson((Contact) user.getPerson());
//            } else if (user.getPerson() instanceof Customer) {
//                user.setPerson((Customer) user.getPerson());
//            }
//
//            // Agregar el nuevo User a la LinkedList
//            users.add(user);
//        }
//
//        // Devolver la LinkedList de User
//        return users;
//    }
    public LinkedList<User> getAllUsersAsLinkedList() {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Crear una LinkedList para almacenar los usuarios
        LinkedList<User> users = new LinkedList<>();

        // Verificar si userEntities es null antes de continuar
        if (userEntities != null) {
            // Si no es null, recorrer cada UserEntity y convertirlo a User, luego agregarlo a la lista
            for (UserEntity entity : userEntities) {
                User user = new User();
                switch (entity.getType()) {
                    case 0:

                        EmployeeRepository employee = new EmployeeRepository("src\\main\\java\\upb\\sgttp\\database\\employee.json");
                        LinkedList employees = employee.getAllEmployeesAsLinkedList();
                        user = new User(
                                getEmployee(employees, entity.getPerson().getNames()),
                                entity.getUsername(),
                                entity.getPassword(),
                                entity.getType()
                        );
                        users.add(user);
                        break;
                    case 1:
                        CustomerRepository customer = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
                        LinkedList customers = customer.getAllCustomersAsLinkedList();
                        user = new User(
                                getCustomer(customers, entity.getPerson().getNames()),
                                entity.getUsername(),
                                entity.getPassword(),
                                entity.getType()
                        );
                        break;
                    case 2:
                        ContactRepository contact = new ContactRepository("src\\main\\java\\upb\\sgttp\\database\\contacts.json");
                        LinkedList contacts = contact.getAllContactsAsLinkedList();
                        user = new User(
                                getContact(contacts, entity.getPerson().getNames()),
                                entity.getUsername(),
                                entity.getPassword(),
                                entity.getType()
                        );
                        break;
                    case 3:
                        AdminRepository admin = new AdminRepository("src\\main\\java\\upb\\sgttp\\database\\admins.json");
                        LinkedList admins = admin.getAllAdminsAsLinkedList();
                        user = new User(
                                getAdmin(admins, entity.getPerson().getNames()),
                                entity.getUsername(),
                                entity.getPassword(),
                                entity.getType()
                        );
                        break;
                }

//                User user = new User(
//                        entity.getPerson(),
//                        entity.getUsername(),
//                        entity.getPassword(),
//                        entity.getType()
//                );
                users.add(user);
            }
        }

        // Devolver la lista de usuarios
        return users;
    }

    public Employee getEmployee(LinkedList<Employee> list, String user) {
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i).getNames())) {
                return list.get(i);
            }
        }
        return new Employee("N/A", "N/A", new Array(1), "N/A");
    }

    public Admin getAdmin(LinkedList<Admin> list, String user) {
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i).getNames())) {
                return list.get(i);
            }
        }
        return new Admin("N/A", "N/A", new Array(1), "N/A");
    }

    public Contact getContact(LinkedList<Contact> list, String user) {
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i).getNames())) {
                return list.get(i);
            }
        }
        return new Contact("N/A", "N/A", new Array(1), "N/A");
    }

    public Customer getCustomer(LinkedList<Customer> list, String user) {
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i).getNames())) {
                return list.get(i);
            }
        }
        return new Customer(new LinkedList(), "N/A", "N/A", new Array(1), "N/A");
    }

    public boolean modifyUsers(LinkedList<User> modifiedUsers) {
        // Convertir la lista de usuarios modificados a un arreglo de entidades de usuario
        UserEntity[] modifiedUserEntities = new UserEntity[modifiedUsers.size()];
        String id = "";
        for (int i = 0; i < modifiedUsers.size(); i++) {
            User modifiedUser = modifiedUsers.get(i);

            switch (modifiedUser.getType()) {
                case 0:
                    Employee employee = (Employee) modifiedUser.getPerson();
                    id = employee.getId();
                    break;
                case 1:
                    Customer customer = (Customer) modifiedUser.getPerson();
                    id = customer.getCustomerId();
                    break;
                case 2:
                    Contact contact = (Contact) modifiedUser.getPerson();
                    id = contact.getContactId();
                    break;
                case 3:
                    Admin admin = (Admin) modifiedUser.getPerson();
                    id = admin.getId();
                    break;
            }
            modifiedUserEntities[i] = new UserEntity(
                    modifiedUser.getPerson(),
                    modifiedUser.getUsername(),
                    modifiedUser.getPassword(),
                    modifiedUser.getType(),
                    id
            );
        }

        // Escribir los nuevos objetos en el archivo JSON
        return fileJson.writeObjects(pathFile, modifiedUserEntities);
    }

    public User getUserById(String id) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Verificar si userEntities es null antes de continuar
        if (userEntities != null) {
            // Recorrer cada UserEntity
            for (UserEntity entity : userEntities) {
                // Verificar si el nombre de usuario coincide con el proporcionado
                if (entity.getId().equals(id)) {
                    User user = new User();
                    switch (entity.getType()) {
                        case 0:
                            EmployeeRepository employeeRepo = new EmployeeRepository("src\\main\\java\\upb\\sgttp\\database\\employee.json");
                            LinkedList<Employee> employees = employeeRepo.getAllEmployeesAsLinkedList();
                            user = new User(
                                    getEmployee(employees, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 1:
                            CustomerRepository customerRepo = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
                            LinkedList<Customer> customers = customerRepo.getAllCustomersAsLinkedList();
                            user = new User(
                                    getCustomer(customers, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 2:
                            ContactRepository contactRepo = new ContactRepository("C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\contacts.json");
                            LinkedList<Contact> contacts = contactRepo.getAllContactsAsLinkedList();
                            user = new User(
                                    getContact(contacts, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 3:
                            AdminRepository adminRepo = new AdminRepository("src\\main\\java\\upb\\sgttp\\database\\admins.json");
                            LinkedList<Admin> admins = adminRepo.getAllAdminsAsLinkedList();
                            user = new User(
                                    getAdmin(admins, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                    }
                    // Devolver el usuario encontrado
                    return user;
                }
            }
        }
        return null;
    }

    public User getUserByUsername(String username) {
        // Obtener todos los usuarios del archivo JSON
        UserEntity[] userEntities = fileJson.getObjects(pathFile, UserEntity[].class);

        // Verificar si userEntities es null antes de continuar
        if (userEntities != null) {
            // Recorrer cada UserEntity
            for (UserEntity entity : userEntities) {
                // Verificar si el nombre de usuario coincide con el proporcionado
                if (entity.getUsername().equals(username)) {
                    User user = new User();
                    switch (entity.getType()) {
                        case 0:
                            EmployeeRepository employeeRepo = new EmployeeRepository("src\\main\\java\\upb\\sgttp\\database\\employee.json");
                            LinkedList<Employee> employees = employeeRepo.getAllEmployeesAsLinkedList();
                            user = new User(
                                    getEmployee(employees, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 1:
                            CustomerRepository customerRepo = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
                            LinkedList<Customer> customers = customerRepo.getAllCustomersAsLinkedList();
                            user = new User(
                                    getCustomer(customers, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 2:
                            ContactRepository contactRepo = new ContactRepository("src\\main\\java\\upb\\sgttp\\database\\contacts.json");
                            LinkedList<Contact> contacts = contactRepo.getAllContactsAsLinkedList();
                            user = new User(
                                    getContact(contacts, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                        case 3:
                            AdminRepository adminRepo = new AdminRepository("src\\main\\java\\upb\\sgttp\\database\\admins.json");
                            LinkedList<Admin> admins = adminRepo.getAllAdminsAsLinkedList();
                            user = new User(
                                    getAdmin(admins, entity.getPerson().getNames()),
                                    entity.getUsername(),
                                    entity.getPassword(),
                                    entity.getType()
                            );
                            break;
                    }
                    // Devolver el usuario encontrado
                    return user;
                }
            }
        }
        return null;
    }
}
