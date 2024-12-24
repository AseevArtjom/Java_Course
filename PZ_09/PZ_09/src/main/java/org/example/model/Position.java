package org.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Position
{
    private Long Id;

    @NonNull
    private String Name;

    public void ToString(){
        System.out.println(Name);
    }
}
