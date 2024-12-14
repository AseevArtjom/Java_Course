package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History
{
    private Long Id;
    private Double Cost;
    private Double TotalOrderCost;
    private Date Created;
    private String ClientFirstName;
    private String ClientLastName;
    private String StaffFirstName;
    private String StaffLastName;
}
