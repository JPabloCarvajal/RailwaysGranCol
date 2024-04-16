/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.gui.AdminPage;
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

//    public UserManagementController(UserView view, UserManagementModel model) {
//        this.view = view;
//        this.model = model;
//        initView();
//        initController();
//    }
    public UserManagementController(UserView view, UserManagementModel model) {
        this.view = view;
        this.model = model;
        initView();
        initController();
    }

    private void initView() {
        // Inicializar la vista con los datos del modelo
        DefaultTableModel tableModel = model.getTableModel();
        view.getjTable().setModel(tableModel);
        view.reloadTable(model);
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
                if (!usuario.isBlank() || !contraseña.isBlank()) {
                    Array array = new Array(numbers);
//            AbstractPerson person = new AbstractPerson(nombres, contraseña, array);
                    int tipo = -1;
                    User user = new User();
                    switch (sType) {
                        case "Empleado":
                            tipo = 0;
                            Employee employ = new Employee(nombres, apellidos, array, upb.sgttp.model.domain.Main.createId(tipo));
                            user = new User(employ, usuario, contraseña, tipo);
                            break;
                        case "Cliente":
                            tipo = 1;
                            LinkedList luggage = new LinkedList<>(Luggage.getNullLuggage());
                            Customer customer = new Customer(luggage, nombres, apellidos, array, upb.sgttp.model.domain.Main.createId(tipo));
                            user = new User(customer, usuario, contraseña, tipo);
                            break;
                        case "Admin":
                            tipo = 3;
                            Admin admin = new Admin(nombres, apellidos, array, upb.sgttp.model.domain.Main.createId(tipo));
                            user = new User(admin, usuario, contraseña, tipo);
                            break;
                        case "Contact":
                            tipo = 2;
                            Contact contact = new Contact(nombres, apellidos, array, upb.sgttp.model.domain.Main.createId(tipo));
                            user = new User(contact, usuario, contraseña, tipo);
                            break;
                    }
                    model.addUser(user);
                    view.reloadTable(model);
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
                System.out.println("selectedRow = " + selectedRow);
                // Verificar si se ha seleccionado una fila
                // Eliminar la fila del modelo de la tabla

                model.removeUser(selectedRow,model.getUserList().get(selectedRow).getUsername());
                view.reloadTable(model);
//                    view.getjScrollPane1().repaint();
//                    view.dispose();
//                    UserManagementModel model = new UserManagementModel();
//                    UserView view = new UserView();
//                    UserManagementController controller = new UserManagementController(view, model);
//                    view.setVisible(true);
//                    view.setLocationRelativeTo(null);

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de actualizar usuario
                // Por ejemplo:
                // - Obtener el índice y los nuevos datos del usuario desde la vista
                // - Actualizar el usuario en el modelo
                // - Actualizar la vista
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento de retroceder (botón de atrás)
                // Por ejemplo:
                // - Cerrar la vista actual
                // - Abrir la vista anterior o realizar alguna acción de retroceso
                view.setVisible(false);
                AdminPage ventanaPrincipal = new AdminPage();
                ventanaPrincipal.setVisible(true);
                ventanaPrincipal.setLocationRelativeTo(null);
            }
        });
    }

//    private void reloadTable() {
//        // Borrar los elementos del modelo de la tabla
//        DefaultTableModel tableModel = model.getTableModel();
//        while (tableModel.getRowCount() > 0) {
//            tableModel.removeRow(0);
//        }
//
//        // Obtener la lista actualizada de usuarios del modelo
//        LinkedList<User> userList = model.getUserList();
//
//        // Iterar sobre la lista de usuarios y agregar cada usuario a la tabla
//        for (int i = 0; i < userList.size(); i++) {
//            // Obtener el usuario en la posición i
//            User user = userList.get(i);
//
//            // Obtener los datos del usuario
//            AbstractPerson person = user.getPerson();
//            String numbers = "";
//            for (int j = 0; j < person.getPhoneNumbers().size(); j++) {
//                numbers += person.getPhoneNumbers().get(j);
//                if (j < person.getPhoneNumbers().size() - 1) {
//                    numbers += ",";
//                }
//            }
//
//            // Crear un arreglo de objetos con los datos del usuario
//            Object[] rowData = new Object[7];
//            rowData[0] = person.getNames();
//            rowData[1] = person.getLastNames();
//            rowData[2] = numbers;
//            rowData[3] = user.getUsername();
//            rowData[4] = user.getPassword();
//            rowData[5] = user.getType();
//
//            // Obtener el tipo de usuario y agregar el ID correspondiente al arreglo de datos
//            int tipo = user.getType();
//            switch (tipo) {
//                case 0: // Empleado
//                    Employee employee = (Employee) person;
//                    rowData[6] = employee.getId();
//                    break;
//                case 1: // Cliente
//                    Customer customer = (Customer) person;
//                    rowData[6] = customer.getCustomerId();
//                    break;
//                case 2: // Contacto
//                    Contact contact = (Contact) person;
//                    rowData[6] = contact.getContactId();
//                    break;
//                case 3: // Administrador
//                    Admin admin = (Admin) person;
//                    rowData[6] = admin.getId();
//                    break;
//            }
//
//            // Agregar la fila a la tabla
//            tableModel.addRow(rowData);
//        }
//
//        // Actualizar la vista con el nuevo modelo de datos
//        view.getjTable().setModel(tableModel);
//    }
}
