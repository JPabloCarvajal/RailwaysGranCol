/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.gui.AdminView;
import upb.sgttp.gui.LoginView;
import upb.sgttp.gui.UserView;
import upb.sgttp.model.AuthenticationModel;
import upb.sgttp.model.UserManagementModel;
import upb.sgttp.model.domain.Luggage;
import upb.sgttp.model.domain.persons.AbstractPerson;
import upb.sgttp.model.domain.persons.Admin;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.model.domain.persons.Customer;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.model.domain.persons.User;

/**
 *
 * @author thewe
 */
public class UserManagementController {

    private final UserView view;
    private final UserManagementModel model;
    

    public UserManagementController(UserView view, UserManagementModel model) {
        this.view = view;
        this.model = model;
        initView();
        initController();
    }

    private void initView() {
        model.ReloadTable();
        reloadTable();
    }

    private void initController() {
        // Configurar los listeners de la vista para interactuar con el modelo
        JButton addButton = view.getAddButton();
        JButton deleteButton = view.getDeleteButton();
        JButton updateButton = view.getUpdateButton();
        JButton backButton = view.getBackButton(); // Agregar el botón de atrás

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de agregar usuario
                String sType = (String) view.getUserTypeComboBox().getSelectedItem();
                String nombres = view.getNameTextField().getText();
                String apellidos = view.getLastNameTextField().getText();
                String numeros = view.getNumbersTextField().getText();
                String[] numbers = numeros.split(",");
                String usuario = view.getUsernameTextField().getText();
                String contraseña = view.getPasswordTextField().getText();
                LinkedList<User> list = model.getUserList();
                if ((!usuario.isBlank() || !contraseña.isBlank()) && !model.isUsernameUsed(usuario)) {
                    Array array = new Array(numbers);
                    int tipo = -1;
                    User user = new User();
                    switch (sType) {
                        case "Empleado":
                            tipo = 0;
                            Employee employ = new Employee(nombres, apellidos, array, model.findId(tipo));
                            user = new User(employ, usuario, contraseña, tipo);
                            break;
                        case "Cliente":
                            tipo = 1;
                            LinkedList luggage = new LinkedList<>(Luggage.getNullLuggage());
                            Customer customer = new Customer(luggage, nombres, apellidos, array, model.findId(tipo));
                            user = new User(customer, usuario, contraseña, tipo);
                            break;
                        case "Admin":
                            tipo = 3;
                            Admin admin = new Admin(nombres, apellidos, array, model.findId(tipo));
                            user = new User(admin, usuario, contraseña, tipo);
                            break;
                        case "Contact":
                            tipo = 2;
                            Contact contact = new Contact(nombres, apellidos, array, model.findId(tipo));
                            user = new User(contact, usuario, contraseña, tipo);
                            break;
                    }
                    model.addUser(user);
//                    view.reloadTable(model);
                    reloadTable();
                    view.setjTextField1();
                    view.setjTextField2();
                    view.setjTextField3();
                    view.setjTextField4();
                    view.setjTextField5();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de eliminar usuario
                int selectedRow = view.getjTable().getSelectedRow();
                if(!model.isUserinList(selectedRow)){
                    model.removeUser(selectedRow, model.getUserList().get(selectedRow));
                reloadTable();
                }
                else{
                    JOptionPane.showMessageDialog(null,"No puedes eliminarte a ti mismo.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de actualizar usuario
                int selectedRow = view.getjTable().getSelectedRow();
                LinkedList<User> list = model.getUserList();
                String sType = (String) view.getUserTypeComboBox().getSelectedItem();
                String nombres = view.getNameTextField().getText();
                String apellidos = view.getLastNameTextField().getText();
                String numeros = view.getNumbersTextField().getText();
                String[] numbers = numeros.split(",");
                String usuario = view.getUsernameTextField().getText();
                String contraseña = view.getPasswordTextField().getText();
                if ((!usuario.isBlank() || !contraseña.isBlank()) && selectedRow != -1) {
                    Array array = new Array(numbers);
                    int tipo = -1;
                    User user = new User();
                    switch (sType) {
                        case "Empleado" -> {
                            tipo = 0;
                            Employee auxE = (Employee) list.get(selectedRow).getPerson();
                            Employee employ = new Employee(nombres, apellidos, array, auxE.getId());
                            user = new User(employ, usuario, contraseña, tipo);
                        }
                        case "Cliente" -> {
                            tipo = 1;
                            Customer auxC = (Customer) list.get(selectedRow).getPerson();
                            LinkedList luggage = new LinkedList<>(Luggage.getNullLuggage());
                            Customer customer = new Customer(luggage, nombres, apellidos, array, auxC.getCustomerId());
                            user = new User(customer, usuario, contraseña, tipo);
                        }
                        case "Admin" -> {
                            tipo = 3;
                            Admin auxA = (Admin) list.get(selectedRow).getPerson();
                            Admin admin = new Admin(nombres, apellidos, array, auxA.getId());
                            user = new User(admin, usuario, contraseña, tipo);
                        }
                        case "Contact" -> {
                            tipo = 2;
                            Contact auxCo = (Contact) list.get(selectedRow).getPerson();
                            Contact contact = new Contact(nombres, apellidos, array, auxCo.getContactId());
                            user = new User(contact, usuario, contraseña, tipo);
                        }
                    }

                    if (model.updateUser(user, selectedRow)) {
//                        view.reloadTable(model);
                        reloadTable();
                        view.setjTextField1();
                        view.setjTextField2();
                        view.setjTextField3();
                        view.setjTextField4();
                        view.setjTextField5();
                    }

                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de retroceder (botón de atrás)
                view.dispose();
                AdminView view = new AdminView();
                AdminPageController controller = new AdminPageController(view);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });
    }

    private void reloadTable() {
        view.getjTable().setModel(model.getTableModel());
    }
}
