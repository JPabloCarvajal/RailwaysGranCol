/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upb.sgttp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import upb.sgttp.gui.AdminView;
import upb.sgttp.gui.LoginView;
import upb.sgttp.gui.RouteView;
import upb.sgttp.gui.TrainView;
import upb.sgttp.gui.UserView;
import upb.sgttp.model.AuthenticationModel;
import upb.sgttp.model.RouteModel;
import upb.sgttp.model.TrainModel;
import upb.sgttp.model.UserManagementModel;

/**
 *
 * @author thewe
 */
@SuppressWarnings("F")
public class AdminPageController {

    private final AdminView view;

    public AdminPageController(AdminView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        JButton RouteButton = view.getjButton3();
        JButton TrainButton = view.getjButton2();
        JButton UserButton = view.getjButton4();
        JButton backButton = view.getjButton1();
        RouteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ir al panel de ruta 
                view.dispose();
                RouteModel model = new RouteModel();
                RouteView view = new RouteView();
                @SuppressWarnings("unused")
                RouteController controller = new RouteController(model, view);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });

        TrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ir al panel de trenes
                view.dispose();
                TrainModel model = new TrainModel();
                TrainView view = new TrainView();
                @SuppressWarnings("unused")
                TrainController controller = new TrainController(model, view);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });

        UserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ir al panel de usuarios
                view.dispose();
                UserManagementModel model = new UserManagementModel();
                UserView view = new UserView();
                @SuppressWarnings("unused")
                UserManagementController controller = new UserManagementController(view, model);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //retroceder (botón de atrás)
                view.dispose();
                AuthenticationModel model = new AuthenticationModel();
                LoginView view = new LoginView();
                @SuppressWarnings("unused")
                LoginController controller = new LoginController(model, view);
                view.setVisible(true);
                view.setLocationRelativeTo(null);
            }
        });
    }
}
