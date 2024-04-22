package jp;

import jp.controller.Controller;
import jp.model.Model;
import jp.view.TicketSale;

public class Main {
        
    public static void main(String[] args) {
        TicketSale view = new TicketSale();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
