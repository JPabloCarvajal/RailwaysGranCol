package jp;
import java.rmi.Naming;
import upb.sgttp.rmiTest.Server;

public class Client {

    public static boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");

        // Llama al método remoto en el servidor
        boolean existeTicket = server.ConsultarExistenciaTicket(ticketID, customerName);
        
        return existeTicket;
    }

    public static void main(String[] args) {
        try {
            // Ejemplo de cómo usar ConsultarExistenciaTicket
            boolean existe = ConsultarExistenciaTicket("kike123", "kike");
            System.out.println("¿Existe el ticket? " + (existe ? "Sí" : "No"));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }   
}
