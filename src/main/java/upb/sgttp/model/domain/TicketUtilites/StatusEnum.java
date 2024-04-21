package upb.sgttp.model.domain.TicketUtilites;

import java.io.Serializable;

/**
 * Enumera los diferentes estados relacionados con el embarque de pasajeros en el sistema.
 */
@SuppressWarnings("unused")
public enum StatusEnum implements Serializable{
    
    BOARDING, // Embarque en curso
    UNBOARDING, // Desembarque en curso
    ABOARD // Pasajeros a bordo
}
