package org.example.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order
{
    private Long Id;

    @NonNull
    private Long ClientId;
    @NonNull
    private Long StaffId;
    @NonNull
    private Double TotalCost;
    @NonNull
    private Date Created;

    public void ToString(){
        System.out.println(ClientId + " | " + StaffId + " | " + TotalCost + " | " + Created);
    }
}
