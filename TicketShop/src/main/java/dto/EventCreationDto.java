package dto;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
public class EventCreationDto
{
    private Integer Id;
    private LocalDate Event_Date;
    private String Name;
    private List<TicketPackDto> TicketPack;
    private PlaceDto Place;
}
