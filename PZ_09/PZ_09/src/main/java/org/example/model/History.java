package org.example.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class History
{
    private Long Id;
    @NonNull
    private Double Cost;
    @NonNull
    private Double TotalOrderCost;
    @NonNull
    private Date Created;
    @NonNull
    private String ClientFirstName;
    @NonNull
    private String ClientLastName;
    @NonNull
    private String StaffFirstName;
    @NonNull
    private String StaffLastName;

    public void ToString(){
        System.out.println(Cost + " | " + TotalOrderCost + " | " + Created + " | " + "Client:{" + ClientFirstName + "," + ClientLastName + "}" + " | " + "Staff:{" + StaffFirstName + "," + StaffLastName + "}");
    }
}
