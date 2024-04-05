package jp.sgttp.controller;
import jp.sgttp.gui.AdminPage;
import jp.sgttp.gui.Login;
import jp.sgttp.gui.LoginIncorrect;
import jp.sgttp.model.SGTTPModel;
import jp.sgttp.model.domain.Main;
import jp.sgttp.view.SGTTPView;

public class SGTTPController {
    
    private final Login view;

    public SGTTPController(Login view) {
        this.view = view;
        // Aquí puedes agregar listeners a los componentes de la vista
        view.addLoginButtonListener(evt -> loginButtonClicked());
    }

    private void loginButtonClicked() {
        String username = view.getUsername();
        String password = view.getPassword();
        int userType = Main.logIn(username, password);

        if (Main.getLogin()) {
            view.close(); // Cierra la ventana de inicio de sesión
            // Abre la nueva ventana de la aplicación después del inicio de sesión exitoso
            if (userType == 3) {
                AdminPage adminPage = new AdminPage();
                adminPage.setVisible(true);
                adminPage.setLocationRelativeTo(null);
            } else {
                LoginIncorrect loginIncorrect = new LoginIncorrect();
                loginIncorrect.setVisible(true);
            }
        } else {
            LoginIncorrect loginIncorrect = new LoginIncorrect();
            loginIncorrect.setVisible(true);
        }
    }
  }
