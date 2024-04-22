/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import jp.model.Model;
import jp.view.ShowBoarding;

/**
 *
 * @author thewe
 */
public class Controller {

    private final ShowBoarding view;
    private final Model model;

    public Controller(ShowBoarding view, Model model) throws Exception {
        this.view = view;
        this.model = model;
        initView();
        initController();
    }
    private void initView() throws Exception {
        model.ReloadTable();
        reloadTable();
    }
    private void initController() {
        // Configurar los listeners de la vista para interactuar con el modelo
        JButton Update = view.getjButton1();

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.ReloadTable();
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                reloadTable();
            }
        });
    }

    private void reloadTable() {
        view.getjTable1().setModel(model.getTableModel());
    }
}
