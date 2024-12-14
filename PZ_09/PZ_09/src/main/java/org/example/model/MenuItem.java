package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem
{
    private Long Id;
    private String Name_Eng;
    private String Name_Ru;
    private Long TypeId;
    private Double Cost;
}
