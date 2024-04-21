package jp;

import java.rmi.Naming;
import jp.controller.Controller;
import jp.model.Model;
import jp.view.FindTicket;

public class Client {

    public static void main(String[] args) throws Exception {
        Model model = new Model();
        FindTicket view = new FindTicket();
        Controller controller = new Controller(view, model);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }   
}
