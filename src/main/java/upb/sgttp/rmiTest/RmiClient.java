package upb.sgttp.rmiTest;

import javax.swing.*;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
    private HelloWithName stub;

    public void start(JFrame frame) {
        try {
            // Conectar al servidor RMI
            Registry registry = LocateRegistry.getRegistry("localhost");
            stub = (HelloWithName) registry.lookup("Hello");

            // Crear la interfaz gráfica
            JTextField nameField = new JTextField();
            JButton setNameButton = new JButton("Establecer Nombre");
            JLabel responseLabel = new JLabel();

            setNameButton.addActionListener(e -> {
                try {
                    stub.setName(nameField.getText());
                    String response = stub.sayHello();
                    responseLabel.setText(response);
                } catch (Exception ex) {
                    responseLabel.setText("Error: " + ex.getMessage());
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1));
            panel.add(new JLabel("Nombre:"));
            panel.add(nameField);
            panel.add(setNameButton);
            panel.add(responseLabel);

            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.toString());
            e.printStackTrace();
        }
    }
}
