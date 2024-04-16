/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import javax.swing.table.DefaultTableModel;
import jp.linkedlist.singly.LinkedList;
import static upb.sgttp.model.domain.Main.admin;
import static upb.sgttp.model.domain.Main.admins;
import static upb.sgttp.model.domain.Main.contact;
import static upb.sgttp.model.domain.Main.contacts;
import static upb.sgttp.model.domain.Main.customer;
import static upb.sgttp.model.domain.Main.customers;
import static upb.sgttp.model.domain.Main.employee;
import static upb.sgttp.model.domain.Main.employees;
import static upb.sgttp.model.domain.Main.trains;
import static upb.sgttp.model.domain.Main.users;
import upb.sgttp.model.domain.persons.AbstractPerson;
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
import upb.sgttp.model.repository.Users.UserRepository;

/**
 *
 * @author thewe
 */
public class UserManagementModel {

    private String luisCliente = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\customer.json";
    private String luisTren = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\train.json";
    private String luisEmpleado = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\employee.json";
    private String luisAdmin = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\admins.json";
    private String luisContact = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\contacts.json";
    private String luisUsuario = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\users.json";
    private String luisRoute = "C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\SGTTP\\src\\main\\java\\upb\\sgttp\\database\\routes.json";
    CustomerRepository customers = new CustomerRepository(luisCliente);
    EmployeeRepository employees = new EmployeeRepository(luisEmpleado);
    AdminRepository admins = new AdminRepository(luisAdmin);
    ContactRepository contacts = new ContactRepository(luisContact);
    UserRepository users = new UserRepository(luisUsuario);
    DefaultTableModel tableModel = new DefaultTableModel();
    private final LinkedList<User> userList;

    public UserManagementModel() {
//        this.tableModel = tableModel;
        this.userList = users.getAllUsersAsLinkedList();
        initTableModel();
    }

    private void initTableModel() {
        // Inicializar el modelo de la tabla con las columnas necesarias
        tableModel.addColumn("Nombres");
        tableModel.addColumn("Apellidos");
        tableModel.addColumn("Numeros");
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Contraseña");
        tableModel.addColumn("Tipo");
        tableModel.addColumn("ID");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public LinkedList<User> getUserList() {
        return userList;
    }

    // Otros métodos para manejar la lógica de gestión de usuarios aquí
    // Métodos para la gestión de usuarios
    public void addUser(User user) {
        switch (user.getType()) {
            case 0:
                Employee employee = (Employee) user.getPerson();
                employees.addEmployee(employee);
                break;
            case 1:
                Customer customer = (Customer) user.getPerson();
                customers.addCustomer(customer);
                break;
            case 2:
                Contact contact = (Contact) user.getPerson();
                contacts.addContact(contact);
                break;
            case 3:
                Admin admin = (Admin) user.getPerson();
                admins.addAdmin(admin);
                break;
        }
        users.addUser(user);
        userList.add(user);
        // Añadir fila al modelo
        Object[] rowData = getUserRowData(user);
        tableModel.addRow(rowData);
    }

    public void removeUser(int index,String username) {//en vez de username deberia ser id pero bueno
        if (userList.size() > 1 && index != -1) {
            userList.remove(userList.get(index));
            tableModel.removeRow(index);
            users.removeUser(username);
        }
    }

    public void updateUser(int index, User user) {
//        switch (user.getType()) {
//            case 0:
//                Employee employee = user;
//                break;
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//        }
//        userList.set(index, user);
//        Object[] rowData = getUserRowData(user);
//        for (int i = 0; i < rowData.length; i++) {
//            model.setValueAt(rowData[i], index, i);
//        }
    }

    // Método para obtener los datos de un usuario como un arreglo de objetos
    private Object[] getUserRowData(User user) {
        // Implementa la lógica para obtener los datos del usuario según tu estructura
        String numbers = "";
        for (int j = 0; j < user.getPerson().getPhoneNumbers().size(); j++) {
            numbers += user.getPerson().getPhoneNumbers().get(j);
            if (j < user.getPerson().getPhoneNumbers().size() - 1) {
                numbers += ",";
            }
        }
        Object u[] = new Object[7];
        u[0] = user.getPerson().getNames();
        u[1] = user.getPerson().getLastNames();
        u[2] = numbers;
        u[3] = user.getUsername();
        u[4] = user.getPassword();
        u[5] = user.getType();
        int tipo = user.getType();
        switch (tipo) {
            case 0://empleado
                Employee empleado = (Employee) user.getPerson();
                u[6] = empleado.getId();
                break;
            case 1://cliente
                Customer customer = (Customer) user.getPerson();
                u[6] = customer.getCustomerId();
                break;
            case 2://contact
                Contact contact = (Contact) user.getPerson();
                u[6] = contact.getContactId();
                break;
            case 3://admin
                Admin admin = (Admin) user.getPerson();
                u[6] = admin.getId();
                break;
        }
        return u;
    }
}
