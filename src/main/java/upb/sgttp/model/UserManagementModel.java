/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
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
import upb.sgttp.model.repository.Users.UserRepository;

/**
 *
 * @author thewe
 */
public class UserManagementModel {

    private CustomerRepository customers = new CustomerRepository("src\\main\\java\\upb\\sgttp\\database\\customer.json");
    private EmployeeRepository employees = new EmployeeRepository("src\\main\\java\\upb\\sgttp\\database\\employee.json");
    private AdminRepository admins = new AdminRepository("src\\main\\java\\upb\\sgttp\\database\\admins.json");
    private ContactRepository contacts = new ContactRepository("src\\main\\java\\upb\\sgttp\\database\\contacts.json");
    private UserRepository users = new UserRepository("src\\main\\java\\upb\\sgttp\\database\\users.json");
    private DefaultTableModel tableModel = new DefaultTableModel();
    private final LinkedList<User> userList;
    private User login = AuthenticationModel.getUserLogin();
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
        String traceability = "agrego un Usuario Id:";
        switch (user.getType()) {
            case 0 -> {
                Employee employee = (Employee) user.getPerson();
                employees.addEmployee(employee);
                TraceabilityModel.writeTraceability(traceability+employee.getId());
            }
            case 1 -> {
                Customer customer = (Customer) user.getPerson();
                customers.addCustomer(customer);
                TraceabilityModel.writeTraceability(traceability+customer.getCustomerId());
            }
            case 2 -> {
                Contact contact = (Contact) user.getPerson();
                contacts.addContact(contact);
                TraceabilityModel.writeTraceability(traceability+contact.getContactId());
            }
            case 3 -> {
                Admin admin = (Admin) user.getPerson();
                admins.addAdmin(admin);
                TraceabilityModel.writeTraceability(traceability+admin.getId());
            }
        }
        
        users.addUser(user);
        userList.add(user);
        ReloadTable();
    }

    public void removeUser(int index, User user) {
        String traceability = "elimino un usuario Id:";
        if (userList.size() > 1 && index != -1) {
            userList.remove(user);
            userList.remove(user);
            switch (user.getType()) {
                case 0 -> {
                    Employee employee = (Employee) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+employee.getId());
                    employees.removeEmployee(employee.getId());
                    users.removeUserById(employee.getId());
                }
                case 1 -> {
                    Customer customer = (Customer) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+customer.getCustomerId());
                    customers.removeCustomer(customer.getCustomerId());
                    users.removeUserById(customer.getCustomerId());
                }
                case 2 -> {
                    Contact contact = (Contact) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+contact.getContactId());
                    contacts.removeContact(contact.getContactId());
                    users.removeUserById(contact.getContactId());
                }
                case 3 -> {
                    Admin admin = (Admin) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+admin.getId());
                    admins.removeAdmin(admin.getId());
                    users.removeUserById(admin.getId());
                }
            }

            ReloadTable();
        }
    }

    public boolean updateUser(User user, int index) {
        String traceability = "modifico un usuario Id:";
        if (userList.size() > 1 && index != -1 && user.getType() == userList.get(index).getType()) {
            switch (user.getType()) {
                case 0 -> {
                    Employee employee = (Employee) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+employee.getId());
                    employees.modifyEmployee(employee.getId(), employee);
                    userList.get(index).setPerson(employee);
                }
                case 1 -> {
                    Customer customer = (Customer) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+customer.getCustomerId());
                    customers.modifyCustomer(customer.getCustomerId(), customer);
                    userList.get(index).setPerson(customer);
                }
                case 2 -> {
                    Contact contact = (Contact) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+contact.getContactId());
                    contacts.modifyContact(contact.getContactId(), contact);
                    userList.get(index).setPerson(contact);
                }
                case 3 -> {
                    Admin admin = (Admin) user.getPerson();
                    TraceabilityModel.writeTraceability(traceability+admin.getId());
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

    public boolean isUsernameUsed(String username) {
        for (int i = 0; i < userList.getSize(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return true;
            }
        }
        return false;
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

    public boolean isUserinList(int index) {
        if (login.getType() == userList.get(index).getType()) {
            switch (userList.get(index).getType()) {
                case 0 -> {
                    //empleado
                    Employee empleado = (Employee) userList.get(index).getPerson();
                    Employee empleado2 = (Employee) login.getPerson();
                    if (empleado.getId().equals(empleado2.getId())) {
                        return true;
                    }
                }
                case 1 -> {
                    //cliente
                    Customer customer = (Customer) userList.get(index).getPerson();
                    Customer customer2 = (Customer) login.getPerson();
                    if (customer.getCustomerId().equals(customer2.getCustomerId())) {
                        return true;
                    }
                }
                case 2 -> {
                    //contact
                    Contact contact = (Contact) userList.get(index).getPerson();
                    Contact contact2 = (Contact) login.getPerson();
                    if (contact.getContactId().equals(contact2.getContactId())) {
                        return true;
                    }
                }
                case 3 -> {
                    //admin
                    Admin admin = (Admin) userList.get(index).getPerson();
                    Admin admin2 = (Admin) login.getPerson();
                    if (admin.getId().equals(admin2.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
