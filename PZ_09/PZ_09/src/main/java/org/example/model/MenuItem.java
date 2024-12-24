package org.example.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MenuItem
{
    private Long Id;

    @NonNull
    private String Name_Eng;
    @NonNull
    private String Name_Ru;
    @NonNull
    private Long TypeId;
    @NonNull
    private Double Cost;

    public void ToString(){
        System.out.println(Name_Eng + " | " + Name_Ru + " | " + TypeId + " | " + Cost);
    }
}
