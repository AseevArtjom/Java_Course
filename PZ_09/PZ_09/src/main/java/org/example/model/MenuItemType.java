package org.example.model;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MenuItemType
{
    private Long Id;
    @NonNull
    private String Name;

    public void ToString(){
        System.out.println("Id: " + Id + " | " + Name);
    }
}
