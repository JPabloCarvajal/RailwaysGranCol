/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import upb.sgttp.gui.AdminView;
import upb.sgttp.gui.LoginView;
import upb.sgttp.model.AuthenticationModel;

/**
 *
 * @author thewe
 */
public class LoginController {

    private final AuthenticationModel model;
    private final LoginView view;
    
    public LoginController(AuthenticationModel model, LoginView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        JButton RouteButton = view.getjButton1();
        RouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ir a la pagina de admin
                String username = view.getUsername();
                String password = view.getPassword();
                boolean authenticated = model.login(username, password);
                if (authenticated) {
                    view.setVisible(false);
                    AdminView view = new AdminView();
                    @SuppressWarnings("unused")
                    AdminPageController controller = new AdminPageController(view);
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(view, "Autenticación fallida. Por favor, inténtalo de nuevo.");
                }
            }
        });
    }
    
}
