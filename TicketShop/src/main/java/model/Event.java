package model;

import jakarta.persistence.*;
import lombok.Data;
import model.Place;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "Events")
public class Event
{
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Event_Date")
    private LocalDate event_date;

    @Column(name = "Name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PlaceId")
    private Place place;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}