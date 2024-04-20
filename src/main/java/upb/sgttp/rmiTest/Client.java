package upb.sgttp.rmiTest;

import javax.swing.*;

public class Client extends JFrame {
    
    public Client() {
        super("Cliente RMI con GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inicializar el cliente RMI
        RmiClient rmiClient = new RmiClient();
        rmiClient.start(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
    }
    
}
