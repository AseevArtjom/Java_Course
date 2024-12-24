package org.example.model;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Client
{
    private Long Id;

    @NonNull
    private String FirstName;
    @NonNull
    private String LastName;
    @NonNull
    private Date Birth;
    @NonNull
    private String Phone;
    @NonNull
    private String Mail;
    @NonNull
    private Integer Discount;

    public void ToString(){
        System.out.println(FirstName + " | " + LastName + " | " + Birth.toString() + " | " + Phone + " | " + Mail + " | " + Discount + "%");
    }
}
