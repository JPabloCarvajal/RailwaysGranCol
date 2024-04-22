package jp;

import jp.controller.Controller;
import jp.model.Model;
import jp.view.ShowBoarding;

public class Main {
    public static void main(String[] args) throws Exception {
        ShowBoarding view = new ShowBoarding();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
