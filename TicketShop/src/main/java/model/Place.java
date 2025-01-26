package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Places")
public class Place
{
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Address")
    private String address;

    @Column(name = "Name")
    private String name;
}
