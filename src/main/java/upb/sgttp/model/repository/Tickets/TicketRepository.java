package upb.sgttp.model.repository.Tickets;

import java.io.Serializable;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.TicketUtilites.Ticket;

import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class TicketRepository implements Serializable{
    
    private FileJsonInterface<TicketEntity> fileJson;
    private String pathFile;

    public TicketRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addTicket(Ticket ticket) {

        TicketEntity[] TicketEntities = fileJson.getObjects(pathFile, TicketEntity[].class);

        if (TicketEntities == null) {
            TicketEntities = new TicketEntity[0];
        }
        TicketEntity newTicketEntity = new TicketEntity(
                ticket.getCustomer(),
                ticket.getCustomerCategory(),
                ticket.getTicketId(),
                ticket.getPurchaseDate(),
                ticket.getBoardingDate(),
                ticket.getArriveDate(),
                ticket.getValue(),
                ticket.getCustomerContact(),
                ticket.getStatus(),
                ticket.getCustomerRoute(),
                ticket.getStations()
        );

        Array<TicketEntity> updatedTicketEntities = new Array<>(TicketEntities.length + 1);
        for (TicketEntity entity : TicketEntities) {
            updatedTicketEntities.add(entity);
        }
        updatedTicketEntities.add(newTicketEntity);

        TicketEntity[] updatedTicketEntitiesArray = new TicketEntity[updatedTicketEntities.size()];
        for (int i = 0; i < updatedTicketEntities.size(); i++) {
            updatedTicketEntitiesArray[i] = updatedTicketEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedTicketEntitiesArray);
    }

    public LinkedList<Ticket> getAllTicketsAsLinkedList() {
        TicketEntity[] ticketEntities = fileJson.getObjects(pathFile, TicketEntity[].class);

        LinkedList<Ticket> ticketList = new LinkedList<>();

        for (TicketEntity entity : ticketEntities) {
            Ticket ticket = new Ticket(
                entity.getCustomer(),
                entity.getCustomerCategory(),
                entity.getTicketId(),
                entity.getPurchaseDate(),
                entity.getBoardingDate(),
                entity.getArriveDate(),
                entity. getValue(),
                entity.getCustomerContact(),
                entity.getStatus(),
                entity.getCustomerRoute(),
                entity.getStations()
        );
            ticketList.add(ticket);
        }

        return ticketList;
    }

    
    public Ticket getTicket(String ticketId) {
        TicketEntity[] ticketEntities = fileJson.getObjects(pathFile, TicketEntity[].class);

        for (TicketEntity entity : ticketEntities) {
            if (entity.getTicketId().equals(ticketId)) {
                return new Ticket(
                        entity.getCustomer(),
                        entity.getCustomerCategory(),
                        entity.getTicketId(),
                        entity.getPurchaseDate(),
                        entity.getBoardingDate(),
                        entity.getArriveDate(),
                        entity.getValue(),
                        entity.getCustomerContact(),
                        entity.getStatus(),
                        entity.getCustomerRoute(),
                        entity.getStations()
                );
            }
        }
        return null;
    }

}