package jp;

import java.rmi.Naming;
import jp.controller.Controller;
import jp.model.Model;
import jp.view.FindTicket;
import upb.sgttp.model.domain.TicketUtilites.Ticket;
import upb.sgttp.rmiTest.Server;
import jp.linkedlist.singly.LinkedList;

public class Client {

    public static boolean ConsultarExistenciaTicket(String ticketID, String customerName) throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");

        // Llama al método remoto en el servidor
        boolean existeTicket = server.ConsultarExistenciaTicket(ticketID, customerName);
        
        return existeTicket;
    }
    
    public static LinkedList<Ticket> obtenerListaTickets() throws Exception {
        // Obtén la referencia al objeto remoto
        Server server = (Server) Naming.lookup("rmi://localhost/Server");

        // Llama al método remoto en el servidor para obtener la lista de tickets
        LinkedList<Ticket> ticketList = server.getTicketList();
        
        return ticketList;
    }

    public static void main(String[] args) throws Exception {
        Model model = new Model();
        model.setFindTicketList(obtenerListaTickets());
        FindTicket view = new FindTicket();
        Controller controller = new Controller(view, model);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        
        try {
            // Ejemplo de cómo usar ConsultarExistenciaTicket
            boolean existe = ConsultarExistenciaTicket("kike123", "kike");
            System.out.println("¿Existe el ticket? " + (existe ? "Sí" : "No"));
            
            // Ejemplo de cómo usar obtenerListaTickets
            LinkedList<Ticket> listaTickets = obtenerListaTickets();
            for(int i =0; i<obtenerListaTickets().getSize();i++){
                System.out.println(listaTickets.get(i).getTicketId());
                System.out.println(listaTickets.get(i).getCustomer().getNames());
            }
            
            // Haz algo con la lista de tickets obtenida...
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }   
}
