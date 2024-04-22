package upb.sgttp.model.domain;

import upb.sgttp.controller.LoginController;
import upb.sgttp.gui.LoginView;
import upb.sgttp.model.AuthenticationModel;

public class Main {

    private static AuthenticationModel model;
    private static LoginView view;
    @SuppressWarnings("unused")
    private static LoginController controller;

    public static void main(String[] args) {

        model = new AuthenticationModel();
        view = new LoginView();
        controller = new LoginController(model, view);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
