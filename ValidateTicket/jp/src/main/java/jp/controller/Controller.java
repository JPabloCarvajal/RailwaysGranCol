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
import jp.view.FindTicket;

/**
 *
 * @author thewe
 */
public class Controller {
    private final FindTicket view;
    private final Model model;
    

    public Controller(FindTicket view, Model model) {
        this.view = view;
        this.model = model;
        initView();
        initController();
    }

    private void initView() {
        model.ReloadTable();
        reloadTable();
    }

    private void initController() {
        // Configurar los listeners de la vista para interactuar con el modelo
        JButton getTicketId = view.getjButton1();

        getTicketId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombres = view.getjTextField2().getText();
                String id = view.getjTextField1().getText();
                try {
                    model.ConsultTicket(id, nombres);
                    reloadTable();
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void reloadTable() {
        view.getjTable1().setModel(model.getTableModel());
    }
}
