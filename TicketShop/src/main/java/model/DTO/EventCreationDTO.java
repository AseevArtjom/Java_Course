package model.DTO;

import model.Event;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EventCreationDTO {
    private Long id;
    private LocalDate eventDate;
    private String name;
    private List<TicketPackDTO> ticketPacks;
    private PlaceDTO place;
}