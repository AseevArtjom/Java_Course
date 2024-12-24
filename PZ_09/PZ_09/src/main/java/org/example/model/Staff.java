package org.example.model;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Staff
{
    private Long Id;

    @NonNull
    private String FirstName;
    @NonNull
    private String LastName;
    @NonNull
    private String Phone;
    @NonNull
    private String Mail;
    @NonNull
    private Long PositionId;

    public void ToString(){
        System.out.println(FirstName + " | " + LastName + " | " + Phone + " | " + Mail + " | " + PositionId);
    }
}
