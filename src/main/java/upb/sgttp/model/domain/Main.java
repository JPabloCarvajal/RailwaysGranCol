package upb.sgttp.model.domain;

import upb.sgttp.controller.LoginController;
import upb.sgttp.gui.LoginView;
import upb.sgttp.model.AuthenticationModel;
import upb.sgttp.rmiTest.ProcessServer;

public class Main {

    private static AuthenticationModel model;
    private static LoginView view;
    @SuppressWarnings("unused")
    private static LoginController controller;
    private static ProcessServer server;
    public static void main(String[] args) {
        model = new AuthenticationModel();
        view = new LoginView();
        controller = new LoginController(model, view);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        server = new ProcessServer();
        server.initializeServer();
    }
}
