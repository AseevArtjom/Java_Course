package model;

import java.util.Date;
import java.util.List;

public class Event
{
    private Long id;
    private Date event_date;
    private String name;
    private List<Ticket> tickets;
    private Place place;
}
