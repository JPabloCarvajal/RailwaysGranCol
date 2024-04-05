package jp.sgttp.controller;

import jp.sgttp.gui.AdminPage;
import jp.sgttp.gui.Login;
import jp.sgttp.gui.LoginIncorrect;
import jp.sgttp.model.SGTTPModel;
import jp.sgttp.model.domain.Main;
import jp.sgttp.view.SGTTPView;

public class SGTTPController {

//    private SGTTPModel model;
//    private SGTTPView view;
//  
//    public SGTTPController(SGTTPModel model, SGTTPView view) {
//      this.model = model;
//      this.view = view;
//    }
//  
//    public void start() {
//      view.init(new String[]{model.getTitle()});
//    }
//    private final Login view;
//
//    public SGTTPController(Login view) {
//        this.view = view;
//        // Aquí puedes agregar listeners a los componentes de la vista
//        view.addLoginButtonListener(evt -> loginButtonClicked());
//    }
//
//    private void loginButtonClicked() {
//        String username = view.getUsername();
//        String password = view.getPassword();
//        int userType = Main.logIn(username, password);
//
//        if (Main.getLogin()) {
//            // Si el inicio de sesión es exitoso, cierra esta ventana de inicio de sesión
//            view.dispose();
//
//            // Abre la nueva ventana de la aplicación después del inicio de sesión exitoso
//            // Aquí puedes crear una nueva instancia de tu ventana principal
//            // por ejemplo:
////            AdminPage ventanaPrincipal = new AdminPage();
//            if (userType == 3) {
//                AdminPage ventanaPrincipal = new AdminPage();
//                ventanaPrincipal.setVisible(true);
//                ventanaPrincipal.setLocationRelativeTo(null);
//            } else {
//                LoginIncorrect log = new LoginIncorrect();
//                log.setVisible(true);
//                log.setLocationRelativeTo(null);
//            }
//        } else {
//            view.dispose();
//            LoginIncorrect log = new LoginIncorrect();
//            log.setVisible(true);
//            log.setLocationRelativeTo(null);
//        }
//    }
//
//    private void loginButtonIncorrectClicked() {
//        String username = view.getUsername();
//        String password = view.getPassword();
//        int userType = Main.logIn(username, password);
//
//        if (Main.getLogin()) {
//            // Si el inicio de sesión es exitoso, cierra esta ventana de inicio de sesión
//            view.dispose();
//
//            // Abre la nueva ventana de la aplicación después del inicio de sesión exitoso
//            // Aquí puedes crear una nueva instancia de tu ventana principal
//            // por ejemplo:
////            AdminPage ventanaPrincipal = new AdminPage();
//            if (userType == 4) {
//                AdminPage ventanaPrincipal = new AdminPage();
//                ventanaPrincipal.setVisible(true);
//                ventanaPrincipal.setLocationRelativeTo(null);
//            } else {
//                LoginIncorrect log = new LoginIncorrect();
//                log.setVisible(true);
//                log.setLocationRelativeTo(null);
//            }
//        } else {
//            view.dispose();
//            LoginIncorrect log = new LoginIncorrect();
//            log.setVisible(true);
//            log.setLocationRelativeTo(null);
//        }
//    }
}
