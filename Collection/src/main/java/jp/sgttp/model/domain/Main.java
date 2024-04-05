package jp.sgttp.model.domain;

import javax.swing.JOptionPane;
import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.controller.SGTTPController;
import jp.sgttp.gui.Login;
import jp.sgttp.model.domain.RouteUtilities.Station;
import jp.sgttp.model.domain.persons.Admin;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.domain.persons.Customer;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.model.domain.persons.User;
import jp.sgttp.model.domain.trainUtilities.Train;
import jp.sgttp.model.repository.Trains.TrainRepository;

public class Main {

    static public LinkedList<Employee> employees = new LinkedList<>();
    static public LinkedList<Customer> customers = new LinkedList<>();
    static public LinkedList<Contact> contacts = new LinkedList<>();
    static public LinkedList<User> users = new LinkedList<>();
    static public LinkedList<Admin> admins = new LinkedList<>();
    static public LinkedList<Train> trains = new LinkedList<>();
    static public LinkedList<Station> stations = new LinkedList<>();
    static public TrainRepository train = new TrainRepository("C:\\Users\\thewe\\OneDrive\\Escritorio\\nuevo train\\RailwaysGranCol\\Collection\\src\\main\\java\\jp\\sgttp\\database\\train.json");
//    static public Array array = new Array(5);
    static boolean login = false;
    static int typeUser = -1;
    static String id;
    static String password;

    public static void main(String[] args) {
        setup();
        chargeTrains();
        Login log = new Login();
        log.setVisible(true);
        log.setLocationRelativeTo(null);
    }

    public static void setup() {
        Array array = new Array(1);
        array.add("300");
        admins.add(new Admin("Luis", "Fuentes", array, "1"));
        users.add(new User(admins.get(0).getPerson(), "Luis", "1", admins.get(0).getType()));
    }

    public static void chargeTrains() {
        trains = train.getAllTrainsAsLinkedList();
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

    public static LinkedList<Train> getTrains() {
        return trains;
    }

    public static void modifyListUsers(LinkedList<User> user) {
        users = user;
    }

    public static void modifyListTrains(LinkedList<Train> train) {
        trains = train;
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
    public static void modifyJson(String id,Train modify){
        train.modifyTrain(id, modify);
    }
    public static void DeleteJsonTrain(String id){
        train.removeTrain(id);
    }
    public static void addJsonTrain(Train object){
        train.addTrain(object);
    }
}
