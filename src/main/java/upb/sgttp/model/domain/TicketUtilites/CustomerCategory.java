package upb.sgttp.model.domain.TicketUtilites;

import java.io.Serializable;

/**
 * Representa las categorías de clientes disponibles en el sistema de gestión de tickets.
 */
@SuppressWarnings("unused")
public enum CustomerCategory implements Serializable{
    
    PREMIUN, // Categoría de cliente premium
    EXECUTIVE, // Categoría de cliente ejecutivo
    STANDAR // Categoría de cliente estándar
}
