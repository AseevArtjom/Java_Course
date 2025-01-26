package service;

import dao.EventRepository;
import dao.PlaceRepository;
import dao.TicketRepository;
import dto.EventCreationDto;
import dto.TicketPackDto;
import model.Event;
import model.Place;
import model.Status;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService
{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public void createEvent(EventCreationDto eventCreationDto){
        Place place = placeRepository.findByName(eventCreationDto.getPlace().getName());
        if(place == null){
            place = new Place();
            place.setName(eventCreationDto.getPlace().getName());
            place.setAddress(eventCreationDto.getPlace().getAddress());
            place = placeRepository.save(place);
        }

        Event event = new Event();
        event.setEvent_date(eventCreationDto.getEvent_Date());
        event.setName(eventCreationDto.getName());
        event.setPlace(place);

        event = eventRepository.save(event);

        for (TicketPackDto ticketPackDto : eventCreationDto.getTicketPack()){
            for (int i = 0; i < ticketPackDto.getCount(); i++){
                Ticket ticket = new Ticket();
                ticket.setCost(ticketPackDto.getCost());
                ticket.setStatus(Status.FREE);
                ticket.setEvent(event);
                ticketRepository.save(ticket);
            }
        }
    }
}
