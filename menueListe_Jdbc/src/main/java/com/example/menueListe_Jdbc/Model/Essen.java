package com.example.menueListe_Jdbc.Model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Essen {
    @Id
    private String id;
    private String kategorie;
    private String essen_name;
    private double preis;
    private String bild;
    private String zutaten;
}
