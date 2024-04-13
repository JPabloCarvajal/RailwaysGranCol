package upb.sgttp.model.domain;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.gui.Login;
import upb.sgttp.model.domain.RouteUtilities.Station;
import upb.sgttp.model.domain.persons.Admin;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.model.domain.persons.User;
import upb.sgttp.model.domain.trainUtilities.Train;
import upb.sgttp.model.repository.Admins.AdminRepository;
import upb.sgttp.model.repository.Contacts.ContactRepository;
import upb.sgttp.model.repository.Customers.CustomerRepository;
import upb.sgttp.model.repository.Employees.EmployeeRepository;
import upb.sgttp.model.repository.Trains.TrainRepository;
import upb.sgttp.model.repository.Users.UserRepository;

public class Main {
    static String luisCliente ="C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\customer.json";
    static String luisTren= "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\train.json";
    static String luisEmpleado = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\employee.json"; 
    static String luisAdmin = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\admins.json";
    static String luisContact = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\contacts.json";
    static String luisUsuario = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\train\\RailwaysGranCol\\src\\main\\java\\upb\\sgttp\\database\\users.json";

    static String jpCliente ="C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\customer.json";
    static String jpTren = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\train.json";
    static String jpEmpleado = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\employee.json";
    static String jpAdmin = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\admins.json";
    static String jpContact = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\contacts.json";
    static String jpUsuario = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\users.json";
    
    static public LinkedList<Employee> employees = new LinkedList<>();
    static public LinkedList<Customer> customers = new LinkedList<>();
    static public LinkedList<Contact> contacts = new LinkedList<>();
    static public LinkedList<User> users = new LinkedList<>();
    static public LinkedList<Admin> admins = new LinkedList<>();
    static public LinkedList<Train> trains = new LinkedList<>();
    static public LinkedList<Station> stations = new LinkedList<>();
    static public int nextId;
    static public TrainRepository train = new TrainRepository(luisTren);
    static public CustomerRepository customer = new CustomerRepository(luisCliente);
    static public EmployeeRepository employee = new EmployeeRepository(luisEmpleado);
    static public AdminRepository admin = new AdminRepository(luisAdmin);
    static public ContactRepository contact = new ContactRepository(luisContact);
    static public UserRepository user = new UserRepository(luisUsuario);

    static boolean login = false;
    static int typeUser = -1;
    static String id;
    static String password;

    public static void main(String[] args) {

        chargeTrains();
        chargeUsers();
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
    }

    public static void setup() {
        Array array = new Array(1);
        array.add("300");
        admins.add(new Admin("Luis", "Fuentes", array, "1"));
        users.add(new User(admins.get(0).getPerson(), "Luis", "1", admins.get(0).getType()));
        user.modifyUsers(users);
        admin.modifyAdmin(admins);
    }

    public static void chargeTrains() {
        trains = train.getAllTrainsAsLinkedList();
    }

    public static void chargeUsers() {
        customers = customer.getAllCustomersAsLinkedList();
        employees = employee.getAllEmployeesAsLinkedList();
        admins = admin.getAllAdminsAsLinkedList();
        contacts = contact.getAllContactsAsLinkedList();
        users = user.getAllUsersAsLinkedList();
    }

    public static int logIn(String n, String p) {
        id = n;
        password = p;
        for (int i = 0; i < users.size(); i++) {
            if (id.equals(users.get(i).getUsername())) {
                if (password.equals(users.get(i).getPassword())) {
                    login = true;
                    typeUser = users.get(i).getType();

                    return typeUser;
                } else {
                    System.out.println("password incorrecta intente denuevo.");
                    return typeUser;
                }
            } else {
                System.out.println("username incorrecto");
            }
        }
        System.out.println("login: " + login);
        System.out.println("type user: " + typeUser);
        return typeUser;
    }

    public static boolean getLogin() {
        return login;
    }

    public static void resetCredentials() {
        id = "";
        password = "";
        typeUser = -1;
        login = false;
    }

    public static LinkedList<User> getUsers() {
        return users;
    }

//    public static String getEmployeeId(int index) {
//        Employee employee = (Employee) users.get(index).getPerson();
//        return employee.getId();
//    }
//
//    public static String getCustomerId(int index) {
//        Customer customer = (Customer) users.get(index).getPerson();
//        return customer.getCustomerId();
//    }
//
//    public static String getAdminId(int index) {
//        Admin admin = (Admin) users.get(index).getPerson();
//        return admin.getId();
//    }
//
//    public static String getContactId(int index) {
//        Contact contact = (Contact) users.get(index).getPerson();
//        return contact.getContactId();
//    }
    public static String getEmployeeId(int index) {
        if (users.get(index).getPerson() instanceof Employee) {
            Employee employee = (Employee) users.get(index).getPerson();
            return employee.getId();
        } else {
            // Manejar el caso cuando la persona no es un Employee
            return null; // o lanzar una excepción, o retornar un valor por defecto, etc.
        }
    }

    public static String getCustomerId(int index) {
        if (users.get(index).getPerson() instanceof Customer) {
            Customer customer = (Customer) users.get(index).getPerson();
            return customer.getCustomerId();
        } else {
            // Manejar el caso cuando la persona no es un Customer
            return null; // o lanzar una excepción, o retornar un valor por defecto, etc.
        }
    }

    public static String getAdminId(int index) {
        if (users.get(index).getPerson() instanceof Admin) {
            Admin admin = (Admin) users.get(index).getPerson();
            return admin.getId();
        } else {
            // Manejar el caso cuando la persona no es un Admin
            return null; // o lanzar una excepción, o retornar un valor por defecto, etc.
        }
    }

    public static String getContactId(int index) {
        if (users.get(index).getPerson() instanceof Contact) {
            Contact contact = (Contact) users.get(index).getPerson();
            return contact.getContactId();
        } else {
            // Manejar el caso cuando la persona no es un Contact
            return null; // o lanzar una excepción, o retornar un valor por defecto, etc.
        }
    }

    public static void modifyEmployee(Employee employ) {
        for (int i = 0; i < employees.getSize(); i++) {
            if (employ.getId().equals(employees.get(i).getId())) {
                employees.get(i).setNames(employ.getNames());
                employees.get(i).setLastNames(employ.getLastNames());
                employees.get(i).setPhoneNumbers(employ.getPhoneNumbers());
                employees.get(i).setId(employ.getId());
            }
        }
        employee.modifyEmployees(employees);
    }

    public static void modifyCustomer(Customer element) {
        for (int i = 0; i < customers.getSize(); i++) {
            if (element.getCustomerId().equals(customers.get(i).getCustomerId())) {
                customers.get(i).setNames(element.getNames());
                customers.get(i).setLastNames(element.getLastNames());
                customers.get(i).setPhoneNumbers(element.getPhoneNumbers());
                customers.get(i).setCustomerId(element.getCustomerId());
            }
        }
        customer.modifyCustomers(customers);
    }

    public static void modifyAdmin(Admin element) {
        for (int i = 0; i < admins.getSize(); i++) {
            if (element.getId().equals(admins.get(i).getId())) {
                admins.get(i).setNames(element.getNames());
                admins.get(i).setLastNames(element.getLastNames());
                admins.get(i).setPhoneNumbers(element.getPhoneNumbers());
                admins.get(i).setId(element.getId());
            }
        }
        admin.modifyAdmin(admins);
    }

    public static void modifyContact(Contact element) {
        for (int i = 0; i < contacts.getSize(); i++) {
            if (element.getContactId().equals(employees.get(i).getId())) {
                contacts.get(i).setNames(element.getNames());
                contacts.get(i).setLastNames(element.getLastNames());
                contacts.get(i).setPhoneNumbers(element.getPhoneNumbers());
                contacts.get(i).setContactId(element.getContactId());
            }
        }
        contact.modifyContact(contacts);
    }

    public static LinkedList<Train> getTrains() {
        return trains;
    }

    public static void modifyListUsers(LinkedList<User> user) {
        users = user;
    }

    public static void modifyListTrains(LinkedList<Train> train) {
        trains = train;
    }

    public static void modifyListCustomers(LinkedList<Customer> customer) {
        customers = customer;
    }

    public static void modifyListEmployees(LinkedList<Employee> employee) {
        employees = employee;
    }

    public static void modifyListContacts(LinkedList<Contact> contact) {
        contacts = contact;
    }

    public static void modifyListAdmins(LinkedList<Admin> admin) {
        admins = admin;
    }

    public static Station searchStationByName(String name) {
        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            if (station.getStationName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        // Si no se encuentra ninguna estación con el nombre especificado, retornar null
        return null;
    }

    public static void modifyJson(String id, Train modify) {
        train.modifyTrain(id, modify);
    }

    public static void modifyJson(LinkedList<Train> trains) {
        train.modifyTrain(trains);
    }

    public static void modifyJsonCustomer(LinkedList<Customer> customers) {
        customer.modifyCustomers(customers);
    }

    public static void modifyJsonEmployee(LinkedList<Employee> employees) {
        employee.modifyEmployees(employees);
    }

    public static void modifyJsonAdmin(LinkedList<Admin> admins) {
        admin.modifyAdmin(admins);
    }

    public static void modifyJsonContact(LinkedList<Contact> contacts) {
        contact.modifyContact(contacts);
    }

    public static void modifyJsonUser(LinkedList<User> users) {
        user.modifyUsers(users);
    }

    public static void DeleteJsonTrain(String id) {
        train.removeTrain(id);
    }

    public static void addJsonTrain(Train object) {
        train.addTrain(object);
    }

    public static void addJsonCustomer(Customer object) {
        customer.addCustomer(object);
    }

    public static LinkedList<Customer> getCustomers() {
        return customers;
    }

    public static String createId(int type) {
        String generatedId = "";
        switch (type) {
//        String generatedId = "C" + nextId;
//        nextId++;
//        return generatedId;
            case 0://empleado
                nextId = employees.getSize() + 1;
                generatedId = "E" + nextId;
                nextId++;
                break;
            case 1://cliente
                nextId = customers.getSize() + 1;
                generatedId = "C" + nextId;
                nextId++;
                break;
            case 2://contacto
                nextId = contacts.getSize() + 1;
                generatedId = "CO" + nextId;
                nextId++;
                break;
            case 3://admin
                nextId = admins.getSize() + 1;
                generatedId = "A" + nextId;
                nextId++;
                break;
        }
        return generatedId;
    }

    public static String createIdTrain(int type) {
        String generatedId = "";
        switch (type) {
//        String generatedId = "C" + nextId;
//        nextId++;
//        return generatedId;
            case 0://empleado
                nextId = trains.getSize() + 1;
                generatedId = "M" + nextId;
                nextId++;
                break;
            case 1://cliente
                nextId = trains.getSize() + 1;
                generatedId = "A" + nextId;
                nextId++;
                break;
        }
        return generatedId;
    }
}