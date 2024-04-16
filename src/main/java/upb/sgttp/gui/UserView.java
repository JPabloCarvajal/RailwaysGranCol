/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.gui;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.UserManagementModel;
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
public class UserView extends javax.swing.JFrame {

    private JButton addButton;
    private JButton deleteButton;
    private JButton modifyButton;
    private JButton prevButton;
    private JComboBox<String> userTypeComboBox;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel numbersLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel userTypeLabel;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField nameTextField;
    private JTextField lastNameTextField;
    private JTextField numbersTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;

    public UserView() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        titleLabel = new JLabel();
        addButton = new JButton();
        deleteButton = new JButton();
        modifyButton = new JButton();
        prevButton = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField();
        numbersLabel = new JLabel();
        numbersTextField = new JTextField();
        usernameLabel = new JLabel();
        usernameTextField = new JTextField();
        passwordLabel = new JLabel();
        passwordTextField = new JTextField();
        userTypeLabel = new JLabel();
        userTypeComboBox = new JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("Gestión de usuarios");

        addButton.setText("Agregar");

        deleteButton.setText("Dar de baja");

        modifyButton.setText("Modificar");

        prevButton.setText("Prev");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombres", "Apellidos", "Numeros", "Usuario", "Contraseña", "Tipo", "Id"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        nameLabel.setText("Nombres");

        lastNameLabel.setText("Apellidos");

        numbersLabel.setText("Números");

        usernameLabel.setText("Usuario");

        passwordLabel.setText("Contraseña");

        userTypeLabel.setText("Tipo");
        userTypeComboBox.addItem("Cliente");
        userTypeComboBox.addItem("Empleado");
        userTypeComboBox.addItem("Admin");
        userTypeComboBox.addItem("Contact");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(titleLabel)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(addButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(modifyButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(deleteButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(prevButton))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameLabel)
                                                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lastNameLabel)
                                                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(numbersLabel)
                                                                        .addComponent(numbersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(usernameLabel)
                                                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(passwordLabel)
                                                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(userTypeLabel)
                                                                        .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(deleteButton)
                                        .addComponent(modifyButton)
                                        .addComponent(prevButton))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(lastNameLabel)
                                        .addComponent(numbersLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numbersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(passwordLabel)
                                        .addComponent(userTypeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getUpdateButton() {
        return modifyButton;
    }

    public void setModifyButton(JButton modifyButton) {
        this.modifyButton = modifyButton;
    }

    public JButton getBackButton() {
        return prevButton;
    }

    public void setPrevButton(JButton prevButton) {
        this.prevButton = prevButton;
    }

    public JComboBox<String> getUserTypeComboBox() {
        return userTypeComboBox;
    }

    public void setUserTypeComboBox(JComboBox<String> userTypeComboBox) {
        this.userTypeComboBox = userTypeComboBox;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public JLabel getNumbersLabel() {
        return numbersLabel;
    }

    public void setNumbersLabel(JLabel numbersLabel) {
        this.numbersLabel = numbersLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getUserTypeLabel() {
        return userTypeLabel;
    }

    public void setUserTypeLabel(JLabel userTypeLabel) {
        this.userTypeLabel = userTypeLabel;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public JTextField getNumbersTextField() {
        return numbersTextField;
    }

    public void setNumbersTextField(JTextField numbersTextField) {
        this.numbersTextField = numbersTextField;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public void setjTextField1() {
        this.nameTextField.setText("");
    }

    public void setjTextField2() {
        this.lastNameTextField.setText("");
    }

    public void setjTextField3() {
        this.numbersTextField.setText("");
    }

    public void setjTextField4() {
        this.usernameTextField.setText("");
    }

    public void setjTextField5() {
        this.passwordTextField.setText("");
    }

//    public void reloadTable(UserManagementModel model) {
        //borrar los elementos del modelo
//        LinkedList<User> list = model.getUserList();
//        while (model.getTableModel().getRowCount() > 0) {
//            model.getTableModel().removeRow(0);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            AbstractPerson person = list.get(i).getPerson();
//            String numbers = "";
//            for(int j=0;j<list.get(i).getPerson().getPhoneNumbers().size();j++){
//                numbers+=list.get(i).getPerson().getPhoneNumbers().get(j);
//                if(j<list.get(i).getPerson().getPhoneNumbers().size()-1){
//                    numbers+=",";
//                }
//            }
//            Object u[] = new Object[7];
//            u[0] = person.getNames();
//            u[1] = person.getLastNames();
//            u[2] = numbers;
//            u[3] = list.get(i).getUsername();
//            u[4] = list.get(i).getPassword();
//            u[5] = list.get(i).getType();
//            int tipo = list.get(i).getType();
//            switch(tipo){
//                case 0://empleado
//                    Employee empleado = (Employee) list.get(i).getPerson();
//                    u[6] = empleado.getId();
//                    break;
//                case 1://cliente
//                    Customer customer = (Customer) list.get(i).getPerson();
//                    u[6] = customer.getCustomerId();
//                    break;
//                case 2://contact
//                    Contact contact = (Contact) list.get(i).getPerson();
//                    u[6] = contact.getContactId();
//                    break;
//                case 3://admin
//                    Admin admin = (Admin) list.get(i).getPerson();
//                    u[6] = admin.getId();
//                    break;
//            }
//            model.getTableModel().addRow(u);
//        }
//        jTable1.setModel(model.getTableModel());
//        jTable1.setModel(model.getTableModel());
//    }
}
