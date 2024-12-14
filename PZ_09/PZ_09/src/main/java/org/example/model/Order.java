package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long Id;
    private Long ClientId;
    private Long StaffId;
    private Double TotalCost;
    private Date Created;
}
