package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private Long Id;
    private String FirstName;
    private String LastName;
    private Date Birth;
    private String Phone;
    private String Mail;
    private int Discount;
}
