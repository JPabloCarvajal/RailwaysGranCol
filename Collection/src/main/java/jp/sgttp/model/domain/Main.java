/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.sgttp.model.domain;

import javax.swing.JOptionPane;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.gui.Login;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.model.domain.persons.User;

/**
 *
 * @author thewe
 */
public class Main {

    static public LinkedList<Employee> employees = new LinkedList<>();
    static public LinkedList<Customer> customers = new LinkedList<>();
    static public LinkedList<Contact> contacts = new LinkedList<>();
    static public LinkedList<User> users = new LinkedList<>();
    static public LinkedList<Admin> admins = new LinkedList<>();
//    static public Array array = new Array(5);
    static boolean login = false;
    static int typeUser = -1;
    static String id;
    static String password;

    public static void main(String[] args) {
//        boolean hasAc= Boolean.parseBoolean(JOptionPane.showInputDialog("tiene cuenta escriba true sino false:"));
//        System.out.println("hasAc = " + hasAc);
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);

//        addArray();
        setup();
//        logIn();

    }

//    public static void addArray() {
//        array.add(0, employees);
//        array.add(1, customers);
//        array.add(2, contacts);
//        array.add(3, users);
//        array.add(4, admins);
//    }

    public static void setup() {
        Array array = new Array(1);
        array.add("300");
        admins.add(new Admin("Luis", "Fuentes",array , "1"));
        users.add(new User(admins.get(0).getPerson(), "Luis", "1", admins.get(0).getType()));
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
    public static boolean getLogin(){
        return login;
    }
    public static void resetCredentials(){
        id = "";
        password = "";
        typeUser = -1;
        login = false;
    }
    public static LinkedList<User> getUsers(){
        return users;
    }
    public static void modifyListUsers(LinkedList<User>  user){
        users = user;
    }
}
