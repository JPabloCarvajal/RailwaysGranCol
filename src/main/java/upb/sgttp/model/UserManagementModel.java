/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
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

    CustomerRepository customers = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
    EmployeeRepository employees = new EmployeeRepository("src\\main\\java\\upb\\sgttp\\database\\employee.json");
    AdminRepository admins = new AdminRepository("src\\main\\java\\upb\\sgttp\\database\\admins.json");
    ContactRepository contacts = new ContactRepository("src\\main\\java\\upb\\sgttp\\database\\contacts.json");
    UserRepository users = new UserRepository("src\\main\\java\\upb\\sgttp\\database\\users.json");
    DefaultTableModel tableModel = new DefaultTableModel();
    private final LinkedList<User> userList;

    public UserManagementModel() {
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

    // Métodos para la gestión de usuarios
    public void addUser(User user) {
        switch (user.getType()) {
            case 0 -> {
                Employee employee = (Employee) user.getPerson();
                employees.addEmployee(employee);
            }
            case 1 -> {
                Customer customer = (Customer) user.getPerson();
                customers.addCustomer(customer);
            }
            case 2 -> {
                Contact contact = (Contact) user.getPerson();
                contacts.addContact(contact);
            }
            case 3 -> {
                Admin admin = (Admin) user.getPerson();
                admins.addAdmin(admin);
            }
        }
        users.addUser(user);
        userList.add(user);
        ReloadTable();
    }

    public void removeUser(int index, User user) {//en vez de username deberia ser id pero bueno
//        if (userList.size() > 1 && index != -1) {
//            userList.remove(userList.get(index));
        if (userList.size() > 1 && index != -1) {
            userList.remove(user);
//            tableModel.removeRow(index);
            userList.remove(user);
            switch (user.getType()) {
                case 0 -> {
                    Employee employee = (Employee) user.getPerson();
                    employees.removeEmployee(employee.getId());
                    users.removeUserById(employee.getId());
                }
                case 1 -> {
                    Customer customer = (Customer) user.getPerson();
                    customers.removeCustomer(customer.getCustomerId());
                    users.removeUserById(customer.getCustomerId());
                }
                case 2 -> {
                    Contact contact = (Contact) user.getPerson();
                    contacts.removeContact(contact.getContactId());
                    users.removeUserById(contact.getContactId());
                }
                case 3 -> {
                    Admin admin = (Admin) user.getPerson();
                    admins.removeAdmin(admin.getId());
                    users.removeUserById(admin.getId());
                }
            }

            ReloadTable();
        }
    }

    public boolean updateUser(User user, int index) {
        if (userList.size() > 1 && index != -1 && user.getType() == userList.get(index).getType()) {
            switch (user.getType()) {
                case 0 -> {
                    Employee employee = (Employee) user.getPerson();
                    employees.modifyEmployee(employee.getId(), employee);
                    userList.get(index).setPerson(employee);
                }
                case 1 -> {
                    Customer customer = (Customer) user.getPerson();
                    customers.modifyCustomer(customer.getCustomerId(), customer);
                    userList.get(index).setPerson(customer);
                }
                case 2 -> {
                    Contact contact = (Contact) user.getPerson();
                    contacts.modifyContact(contact.getContactId(), contact);
                    userList.get(index).setPerson(contact);
                }
                case 3 -> {
                    Admin admin = (Admin) user.getPerson();
                    admins.modifyAdmin(admin.getId(), admin);
                    userList.get(index).setPerson(admin);
                }
            }
            users.modifyUser(userList.get(index).getUsername(), user);
            userList.get(index).setUsername(user.getUsername());
            userList.get(index).setPassword(user.getPassword());
            ReloadTable();
            return true;
        }
        return false;
    }

    public void ReloadTable() {
        while (getTableModel().getRowCount() > 0) {
            getTableModel().removeRow(0);
        }
        for (int i = 0; i < userList.size(); i++) {
            AbstractPerson person = userList.get(i).getPerson();
            String numbers = "";
            for (int j = 0; j < userList.get(i).getPerson().getPhoneNumbers().size(); j++) {
                numbers += userList.get(i).getPerson().getPhoneNumbers().get(j);
                if (j < userList.get(i).getPerson().getPhoneNumbers().size() - 1) {
                    numbers += ",";
                }
            }
            Object u[] = new Object[7];
            u[0] = person.getNames();
            u[1] = person.getLastNames();
            u[2] = numbers;
            u[3] = userList.get(i).getUsername();
            u[4] = userList.get(i).getPassword();
            u[5] = userList.get(i).getType();
            int tipo = userList.get(i).getType();
            switch (tipo) {
                case 0 -> {
                    //empleado
                    Employee empleado = (Employee) userList.get(i).getPerson();
                    u[6] = empleado.getId();
                }
                case 1 -> {
                    //cliente
                    Customer customer = (Customer) userList.get(i).getPerson();
                    u[6] = customer.getCustomerId();
                }
                case 2 -> {
                    //contact
                    Contact contact = (Contact) userList.get(i).getPerson();
                    u[6] = contact.getContactId();
                }
                case 3 -> {
                    //admin
                    Admin admin = (Admin) userList.get(i).getPerson();
                    u[6] = admin.getId();
                }
            }
            getTableModel().addRow(u);
        }
    }

    public String findId(int type) {
        String id = "";
        String tipo = "";
        String r = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        switch (type) {
            case 0 -> // empleado
                tipo = "E";
            case 1 -> // cliente
                tipo = "C";
            case 2 -> // contacto
                tipo = "CO";
            case 3 -> // admin
                tipo = "A";
        }
        id = tipo + formattedDateTime;
        return id;
    }
}
