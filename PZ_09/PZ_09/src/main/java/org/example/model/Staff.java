package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Staff
{
    private Long Id;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Mail;
    private Long PositionId;
}
